package net.mcreator.mso.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.mso.potion.DispellPotionEffect;
import net.mcreator.mso.MsoMod;

import java.util.Map;
import java.util.Iterator;

public class CleanseOnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure CleanseOnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(DispellPotionEffect.potion);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.INSTANT_DAMAGE);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.NAUSEA);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.BLINDNESS);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.HUNGER);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.WEAKNESS);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.POISON);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.WITHER);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.UNLUCK);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.BAD_OMEN);
		}
		if (entity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("mso:ablessing"));
			AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
