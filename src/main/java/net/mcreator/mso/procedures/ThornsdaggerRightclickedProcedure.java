package net.mcreator.mso.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.potion.KillingspreePotionEffect;
import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.Map;

public class ThornsdaggerRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure ThornsdaggerRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure ThornsdaggerRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).ivydaggerskillselect == 2
				&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana >= 20) {
			{
				double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana - 20);
				entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(KillingspreePotionEffect.potion, (int) 200, (int) 0));
		} else {
			if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MsoModVariables.PlayerVariables())).ivydaggerskillselect == 1
					&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MsoModVariables.PlayerVariables())).Mana >= 7) {
				{
					double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MsoModVariables.PlayerVariables())).Mana - 7);
					entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 50, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 50, (int) 1));
				for (int index0 = 0; index0 < (int) (50); index0++) {
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							entity.fallDistance = (float) (0);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 1);
				}
			}
		}
	}
}
