package net.mcreator.mso.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.MsoMod;

import java.util.Map;

public class ArcherBodyTickEventProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure ArcherBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.fallDistance = (float) (0);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 60, (int) 0, (false), (false)));
	}
}
