package net.mcreator.mso.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.Property;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.mso.particle.QuickshieldparticleParticle;
import net.mcreator.mso.item.AcidspearItem;
import net.mcreator.mso.block.ThornsBlock;
import net.mcreator.mso.block.DryGrassBlock;
import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ThornsshieldrightclickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure Thornsshieldrightclick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure Thornsshieldrightclick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure Thornsshieldrightclick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure Thornsshieldrightclick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure Thornsshieldrightclick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == AcidspearItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Blocks.AIR
						.asItem()) {
			if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MsoModVariables.PlayerVariables())).thornsshieldskillselect == 2
					&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MsoModVariables.PlayerVariables())).Mana >= 5) {
				{
					double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MsoModVariables.PlayerVariables())).Mana - 5);
					entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 60, (int) 0));
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(QuickshieldparticleParticle.particle, x, y, z, (int) 25, 1, 1, 1, 0);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			} else {
				if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).thornsshieldskillselect == 1
						&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MsoModVariables.PlayerVariables())).Mana >= 20) {
					{
						double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MsoModVariables.PlayerVariables())).Mana - 20);
						entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == DryGrassBlock.block
									|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.AIR) {
								{
									BlockPos _bp = new BlockPos(x, y, z);
									BlockState _bs = ThornsBlock.block.getDefaultState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
										if (_property != null && _bs.get(_property) != null)
											try {
												_bs = _bs.with(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlockState(_bp, _bs, 3);
								}
							}
						}
					}
				}
			}
		}
	}
}
