package net.mcreator.mso.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.IWorld;

import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Map;
import java.util.HashMap;

public class RngProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure Rng!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (MsoModVariables.WorldVariables.get(world).customrng >= 100) {
			MsoModVariables.WorldVariables.get(world).customrng = 0;
			MsoModVariables.WorldVariables.get(world).syncData(world);
		} else {
			MsoModVariables.WorldVariables.get(world).customrng = (MsoModVariables.WorldVariables.get(world).customrng + 1);
			MsoModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
