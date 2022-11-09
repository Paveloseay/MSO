package net.mcreator.mso.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoMod;

import java.util.Map;

public class SpearrangeWhileProjectileFlyingTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MsoMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SpearrangeWhileProjectileFlyingTick!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		{
			Entity _ent = sourceentity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"kill @e[type=mso:projectile_spearrange]");
			}
		}
	}
}
