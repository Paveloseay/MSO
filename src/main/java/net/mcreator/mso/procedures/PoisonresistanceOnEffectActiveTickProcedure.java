package net.mcreator.mso.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoMod;

import java.util.Map;

public class PoisonresistanceOnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure PoisonresistanceOnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.POISON);
		}
	}
}
