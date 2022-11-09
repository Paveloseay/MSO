package net.mcreator.mso.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class ThornsshieldskillselectProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure Thornsshieldskillselect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).thornsshieldskillselect == 2) {
			{
				double _setval = 1;
				entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.thornsshieldskillselect = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lThorns Fortress"), (true));
			}
		} else if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).thornsshieldskillselect == 1) {
			{
				double _setval = 2;
				entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.thornsshieldskillselect = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7b\u00A7lInsta shield"), (true));
			}
		}
	}
}
