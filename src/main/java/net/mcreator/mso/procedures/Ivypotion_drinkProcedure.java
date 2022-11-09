package net.mcreator.mso.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.potion.PoisonresistancePotionEffect;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class Ivypotion_drinkProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure Ivypotion_drink!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(PoisonresistancePotionEffect.potion, (int) 1500, (int) 0));
	}
}
