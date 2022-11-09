package net.mcreator.mso.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.item.ArcherItem;
import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Random;
import java.util.Map;

public class ThornslogbowPlayerFinishesUsingItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure ThornslogbowPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure ThornslogbowPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure ThornslogbowPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure ThornslogbowPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure ThornslogbowPlayerFinishesUsingItem!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MsoMod.LOGGER.warn("Failed to load dependency itemstack for procedure ThornslogbowPlayerFinishesUsingItem!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
				.getItem() == ArcherItem.body) {
			if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MsoModVariables.PlayerVariables())).Mana >= 6) {
				{
					double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MsoModVariables.PlayerVariables())).Mana - 8);
					entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 25);
				if (entity instanceof LivingEntity) {
					LivingEntity _ent = (LivingEntity) entity;
					if (!_ent.world.isRemote()) {
						AbstractArrowEntity entityToSpawn = new ArrowEntity(_ent.world, _ent);
						entityToSpawn.shoot(_ent.getLookVec().x, _ent.getLookVec().y, _ent.getLookVec().z, (float) 3.6, 0);
						entityToSpawn.setDamage((float) 1.8);
						entityToSpawn.setKnockbackStrength(1);
						_ent.world.addEntity(entityToSpawn);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
							SoundCategory.NEUTRAL, (float) 2, (float) 2);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
							SoundCategory.NEUTRAL, (float) 2, (float) 2, false);
				}
			}
		} else {
			if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MsoModVariables.PlayerVariables())).Mana >= 10) {
				{
					double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MsoModVariables.PlayerVariables())).Mana - 10);
					entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 30);
				if (entity instanceof LivingEntity) {
					LivingEntity _ent = (LivingEntity) entity;
					if (!_ent.world.isRemote()) {
						AbstractArrowEntity entityToSpawn = new ArrowEntity(_ent.world, _ent);
						entityToSpawn.shoot(_ent.getLookVec().x, _ent.getLookVec().y, _ent.getLookVec().z, 3, 0);
						entityToSpawn.setDamage((float) 1.5);
						entityToSpawn.setKnockbackStrength(1);
						_ent.world.addEntity(entityToSpawn);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
		}
	}
}
