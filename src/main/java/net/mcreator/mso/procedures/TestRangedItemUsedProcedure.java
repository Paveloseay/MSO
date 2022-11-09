package net.mcreator.mso.procedures;

import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoMod;

import java.util.Map;

public class TestRangedItemUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure TestRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				AbstractArrowEntity entityToSpawn = new ArrowEntity(_ent.world, _ent);
				entityToSpawn.shoot(_ent.getLookVec().x, _ent.getLookVec().y, _ent.getLookVec().z, 1, 0);
				entityToSpawn.setDamage(5);
				entityToSpawn.setKnockbackStrength(5);
				_ent.world.addEntity(entityToSpawn);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				AbstractArrowEntity entityToSpawn = new ArrowEntity(_ent.world, _ent);
				entityToSpawn.shoot(_ent.getLookVec().x, _ent.getLookVec().y, _ent.getLookVec().z, 1, 0);
				entityToSpawn.setDamage(5);
				entityToSpawn.setKnockbackStrength(5);
				_ent.world.addEntity(entityToSpawn);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				AbstractArrowEntity entityToSpawn = new ArrowEntity(_ent.world, _ent);
				entityToSpawn.shoot(_ent.getLookVec().x, _ent.getLookVec().y, _ent.getLookVec().z, 1, 0);
				entityToSpawn.setDamage(5);
				entityToSpawn.setKnockbackStrength(5);
				_ent.world.addEntity(entityToSpawn);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				AbstractArrowEntity entityToSpawn = new ArrowEntity(_ent.world, _ent);
				entityToSpawn.shoot(_ent.getLookVec().x, _ent.getLookVec().y, _ent.getLookVec().z, 1, 0);
				entityToSpawn.setDamage(5);
				entityToSpawn.setKnockbackStrength(5);
				_ent.world.addEntity(entityToSpawn);
			}
		}
	}
}
