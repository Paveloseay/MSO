package net.mcreator.mso.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class M1Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure M1!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MsoModVariables.PlayerVariables())).Mana >= 5) {
			return true;
		}
		return false;
	}
}
