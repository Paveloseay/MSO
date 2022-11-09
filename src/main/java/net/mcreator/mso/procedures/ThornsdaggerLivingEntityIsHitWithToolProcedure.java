package net.mcreator.mso.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.potion.KillingspreePotionEffect;
import net.mcreator.mso.MsoMod;

import java.util.Map;
import java.util.Collection;

public class ThornsdaggerLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure ThornsdaggerLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == KillingspreePotionEffect.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check(entity) > 0) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) >= 25
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 4) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager()
								.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
					}
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) <= 15
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 8) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager()
								.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "kill");
					}
				}
			} else {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("youhavebeenwarned").setDamageBypassesArmor(), (float) 10);
				}
			}
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 60, (int) 1));
		}
	}
}
