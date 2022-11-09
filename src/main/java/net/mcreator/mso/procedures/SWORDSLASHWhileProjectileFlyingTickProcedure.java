package net.mcreator.mso.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import net.mcreator.mso.particle.CleanseparticleParticle;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class SWORDSLASHWhileProjectileFlyingTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure SWORDSLASHWhileProjectileFlyingTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure SWORDSLASHWhileProjectileFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure SWORDSLASHWhileProjectileFlyingTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure SWORDSLASHWhileProjectileFlyingTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(CleanseparticleParticle.particle, x, y, z, (int) 5, 1, 1, 1, 1);
		}
	}
}
