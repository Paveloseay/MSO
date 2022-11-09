package net.mcreator.mso.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Map;
import java.util.HashMap;

public class ManaregenProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure Manaregen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MsoModVariables.PlayerVariables())).Mana + 0.05);
			entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Mana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MsoModVariables.PlayerVariables())).commandshotcooldown - 1);
			entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.commandshotcooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
