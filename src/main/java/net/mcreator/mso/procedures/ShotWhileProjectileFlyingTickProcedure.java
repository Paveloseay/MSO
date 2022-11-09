package net.mcreator.mso.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.mso.MsoMod;

import java.util.Map;

public class ShotWhileProjectileFlyingTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure ShotWhileProjectileFlyingTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure ShotWhileProjectileFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure ShotWhileProjectileFlyingTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure ShotWhileProjectileFlyingTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, (int) 5, 0, 0, 0, 0);
		}
	}
}
