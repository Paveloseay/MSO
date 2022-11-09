package net.mcreator.mso.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.particle.CommandshotParticle;
import net.mcreator.mso.item.VineItem;
import net.mcreator.mso.item.ShotItem;
import net.mcreator.mso.item.ArcherItem;
import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Random;
import java.util.Map;

public class ThornslogbowEntitySwingsItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure ThornslogbowEntitySwingsItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure ThornslogbowEntitySwingsItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure ThornslogbowEntitySwingsItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure ThornslogbowEntitySwingsItem!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure ThornslogbowEntitySwingsItem!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MsoMod.LOGGER.warn("Failed to load dependency itemstack for procedure ThornslogbowEntitySwingsItem!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).thornslogbowskillselect == 1) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
					.getItem() == ArcherItem.body) {
				if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana >= 12) {
					{
						double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MsoModVariables.PlayerVariables())).Mana - 12);
						entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 20);
					if (entity instanceof LivingEntity) {
						LivingEntity _ent = (LivingEntity) entity;
						if (!_ent.world.isRemote()) {
							VineItem.shoot(_ent.world, _ent, new Random(), (float) 3.6, (float) 1.8, 0);
						}
					}
				}
			} else {
				if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana >= 20) {
					{
						double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MsoModVariables.PlayerVariables())).Mana - 20);
						entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 25);
					if (entity instanceof LivingEntity) {
						LivingEntity _ent = (LivingEntity) entity;
						if (!_ent.world.isRemote()) {
							VineItem.shoot(_ent.world, _ent, new Random(), 3, (float) 1.5, 0);
						}
					}
				}
			}
		} else if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).commandshotcooldown <= 0
				&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).thornslogbowskillselect == 2) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
					.getItem() == ArcherItem.body) {
				if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana >= 18) {
					{
						double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MsoModVariables.PlayerVariables())).Mana - 18);
						entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 21;
						entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.commandshotcooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 20);
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("block.enchantment_table.use")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("block.enchantment_table.use")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(CommandshotParticle.particle, x, y, z, (int) 25, 1, 1, 1, 0);
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (((entity instanceof LivingEntity)
									? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
									: ItemStack.EMPTY).getItem() == ArcherItem.body
									&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MsoModVariables.PlayerVariables())).Mana >= 18
									&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MsoModVariables.PlayerVariables())).commandshotcooldown <= 2) {
								if (entity instanceof LivingEntity) {
									LivingEntity _ent = (LivingEntity) entity;
									if (!_ent.world.isRemote()) {
										ShotItem.shoot(_ent.world, _ent, new Random(), (float) 4.2, (float) 4.2, 0);
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				}
			}
		}
	}
}
