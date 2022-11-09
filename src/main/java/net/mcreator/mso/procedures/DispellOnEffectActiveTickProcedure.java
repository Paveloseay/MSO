package net.mcreator.mso.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.potion.KillingspreePotionEffect;
import net.mcreator.mso.potion.FireshieldPotionEffect;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class DispellOnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure DispellOnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(FireshieldPotionEffect.potion);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(KillingspreePotionEffect.potion);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.SPEED);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.HASTE);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.INSTANT_HEALTH);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.REGENERATION);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.FIRE_RESISTANCE);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.WATER_BREATHING);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.INVISIBILITY);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.NIGHT_VISION);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.HEALTH_BOOST);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.ABSORPTION);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.SATURATION);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.LUCK);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.SLOW_FALLING);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.CONDUIT_POWER);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.DOLPHINS_GRACE);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.HERO_OF_THE_VILLAGE);
		}
	}
}
