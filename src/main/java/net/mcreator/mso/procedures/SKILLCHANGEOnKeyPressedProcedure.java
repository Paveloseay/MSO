package net.mcreator.mso.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.item.WaterfallItem;
import net.mcreator.mso.item.ThornsshieldItem;
import net.mcreator.mso.item.ThornslogbowItem;
import net.mcreator.mso.item.ThornsdaggerItem;
import net.mcreator.mso.MsoMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class SKILLCHANGEOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure SKILLCHANGEOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == ThornsdaggerItem.block) {
			IvydaggerskillselectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == ThornslogbowItem.block) {
			ThornslogbowskillselectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == ThornsshieldItem.block) {
			ThornsshieldskillselectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == WaterfallItem.block) {
			WaterfallskillselecrtProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
