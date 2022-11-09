package net.mcreator.mso.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.mso.MsoMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class FireshieldActiveTickConditionProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure FireshieldActiveTickCondition!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure FireshieldActiveTickCondition!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure FireshieldActiveTickCondition!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure FireshieldActiveTickCondition!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure FireshieldActiveTickCondition!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entity instanceof PlayerEntity)) {
					world.setBlockState(new BlockPos(x, y, z), Blocks.FIRE.getDefaultState(), 3);
				}
			}
		}
	}
}
