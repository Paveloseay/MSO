
package net.mcreator.mso.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.network.IPacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;

import net.mcreator.mso.item.ManafishItem;
import net.mcreator.mso.entity.renderer.LivefishRenderer;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class LivefishEntity extends MsoModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.WATER_CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 0.4f)).build("livefish").setRegistryName("livefish");

	public LivefishEntity(MsoModElements instance) {
		super(instance, 194);
		FMLJavaModLoadingContext.get().getModEventBus().register(new LivefishRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("mso:coralshallows").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(entity, 20, 5, 5));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SquidEntity::func_223365_b);
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 5);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
			ammma = ammma.createMutableAttribute(ForgeMod.SWIM_SPEED.get(), 0.5);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 2;
			setNoAI(false);
			this.setPathPriority(PathNodeType.WATER, 0);
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.isInWater())
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						float f = (float) (MathHelper.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
						float f1 = (float) (this.speed * CustomEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw, f, 10);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.rotationYawHead = CustomEntity.this.rotationYaw;
						if (CustomEntity.this.isInWater()) {
							CustomEntity.this.setAIMoveSpeed((float) CustomEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
							float f2 = -(float) (MathHelper.atan2(dy, MathHelper.sqrt(dx * dx + dz * dz)) * (180F / Math.PI));
							f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85, 85);
							CustomEntity.this.rotationPitch = this.limitAngle(CustomEntity.this.rotationPitch, f2, 5);
							float f3 = MathHelper.cos(CustomEntity.this.rotationPitch * (float) (Math.PI / 180.0));
							CustomEntity.this.setMoveForward(f3 * f1);
							CustomEntity.this.setMoveVertical((float) (f1 * dy));
						} else {
							CustomEntity.this.setAIMoveSpeed(f1 * 0.05F);
						}
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
						CustomEntity.this.setMoveVertical(0);
						CustomEntity.this.setMoveForward(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new AvoidEntityGoal(this, JawfishEntity.CustomEntity.class, (float) 3, 40, 50));
			this.goalSelector.addGoal(2, new AvoidEntityGoal(this, PlayerEntity.class, (float) 3, 40, 50));
			this.goalSelector.addGoal(3, new AvoidEntityGoal(this, ServerPlayerEntity.class, (float) 3, 50, 50));
			this.goalSelector.addGoal(4, new PanicGoal(this, 75));
			this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 40, 40));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.WATER;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(ManafishItem.block));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), 0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tropical_fish.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tropical_fish.death"));
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader world) {
			return world.checkNoEntityCollision(this);
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}
	}
}
