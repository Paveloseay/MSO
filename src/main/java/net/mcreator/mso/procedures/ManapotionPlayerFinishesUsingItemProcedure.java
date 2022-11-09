package net.mcreator.mso.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class ManapotionPlayerFinishesUsingItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure ManapotionPlayerFinishesUsingItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MsoModVariables.PlayerVariables())).Mana + 30);
			entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Mana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
