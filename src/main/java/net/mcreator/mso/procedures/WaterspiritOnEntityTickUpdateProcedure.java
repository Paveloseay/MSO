package net.mcreator.mso.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.mso.item.SWORDSLASHItem;
import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class WaterspiritOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure WaterspiritOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure WaterspiritOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure WaterspiritOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure WaterspiritOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure WaterspiritOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		CleanseOnEffectActiveTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 250) {
			if (MsoModVariables.WorldVariables.get(world).customrng == 25) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"effect give @p mso:dispell 15 15");
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 200) {
			if (MsoModVariables.WorldVariables.get(world).customrng == 75) {
				if (entity instanceof LivingEntity) {
					LivingEntity _ent = (LivingEntity) entity;
					if (!_ent.world.isRemote()) {
						SWORDSLASHItem.shoot(_ent.world, _ent, new Random(), 3, 1, (int) 2.5);
					}
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 150) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"effect clear @p mso:cleanse");
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 100) {
			if (MsoModVariables.WorldVariables.get(world).customrng == 50 || MsoModVariables.WorldVariables.get(world).customrng == 100) {
				if (entity instanceof LivingEntity) {
					LivingEntity _ent = (LivingEntity) entity;
					if (!_ent.world.isRemote()) {
						SWORDSLASHItem.shoot(_ent.world, _ent, new Random(), 3, 1, (int) 2.5);
					}
				}
			}
		}
	}
}
