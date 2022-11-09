package net.mcreator.mso.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class WaterfallskillselecrtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure Waterfallskillselecrt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).waterfallskillselect == 2) {
			{
				double _setval = 1;
				entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.waterfallskillselect = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7d\u00A7lQuick slash"), (true));
			}
		} else if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).waterfallskillselect == 1) {
			{
				double _setval = 2;
				entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.waterfallskillselect = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A79\u00A7lCleanse"), (true));
			}
		}
	}
}
