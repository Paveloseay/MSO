package net.mcreator.mso.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mso.particle.AbsorbParticle;
import net.mcreator.mso.item.SWORDSLASHItem;
import net.mcreator.mso.MsoModVariables;
import net.mcreator.mso.MsoMod;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class WaterfallskillsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MsoMod.LOGGER.warn("Failed to load dependency world for procedure Waterfallskills!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MsoMod.LOGGER.warn("Failed to load dependency x for procedure Waterfallskills!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MsoMod.LOGGER.warn("Failed to load dependency y for procedure Waterfallskills!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MsoMod.LOGGER.warn("Failed to load dependency z for procedure Waterfallskills!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MsoMod.LOGGER.warn("Failed to load dependency entity for procedure Waterfallskills!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).waterfallskillselect == 2
				&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana >= 15) {
			{
				double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana - 15);
				entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			CleanseOnEffectActiveTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 100, (int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mso:cleanse")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.2);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("mso:cleanse")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1.2, false);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(AbsorbParticle.particle, x, y, z, (int) 25, 1, 1, 1, 0);
			}
		} else if ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MsoModVariables.PlayerVariables())).waterfallskillselect == 1
				&& (entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana >= 10) {
			{
				double _setval = ((entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MsoModVariables.PlayerVariables())).Mana - 10);
				entity.getCapability(MsoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 1));
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
					if (entity instanceof LivingEntity) {
						LivingEntity _ent = (LivingEntity) entity;
						if (!_ent.world.isRemote()) {
							SWORDSLASHItem.shoot(_ent.world, _ent, new Random(), 3, (float) 2.5, 1);
						}
					}
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
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager().handleCommand(
											_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
											"kill @e[type=mso:projectile_swordslash]");
								}
							}
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
									if (entity instanceof LivingEntity) {
										LivingEntity _ent = (LivingEntity) entity;
										if (!_ent.world.isRemote()) {
											SWORDSLASHItem.shoot(_ent.world, _ent, new Random(), 3, (float) 2.5, 1);
										}
									}
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
											{
												Entity _ent = entity;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"kill @e[type=mso:projectile_swordslash]");
												}
											}
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
													if (entity instanceof LivingEntity) {
														LivingEntity _ent = (LivingEntity) entity;
														if (!_ent.world.isRemote()) {
															SWORDSLASHItem.shoot(_ent.world, _ent, new Random(), 3, (float) 2.5, 1);
														}
													}
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
															{
																Entity _ent = entity;
																if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																	_ent.world.getServer().getCommandManager().handleCommand(
																			_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																			"kill @e[type=mso:projectile_swordslash]");
																}
															}
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
																	if (entity instanceof LivingEntity) {
																		LivingEntity _ent = (LivingEntity) entity;
																		if (!_ent.world.isRemote()) {
																			SWORDSLASHItem.shoot(_ent.world, _ent, new Random(), 3, (float) 2.5, 1);
																		}
																	}
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
																			{
																				Entity _ent = entity;
																				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																					_ent.world.getServer().getCommandManager().handleCommand(
																							_ent.getCommandSource().withFeedbackDisabled()
																									.withPermissionLevel(4),
																							"kill @e[type=mso:projectile_swordslash]");
																				}
																			}
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
																					if (entity instanceof LivingEntity) {
																						LivingEntity _ent = (LivingEntity) entity;
																						if (!_ent.world.isRemote()) {
																							SWORDSLASHItem.shoot(_ent.world, _ent, new Random(), 3,
																									(float) 2.5, 1);
																						}
																					}
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
																							{
																								Entity _ent = entity;
																								if (!_ent.world.isRemote
																										&& _ent.world.getServer() != null) {
																									_ent.world.getServer().getCommandManager()
																											.handleCommand(
																													_ent.getCommandSource()
																															.withFeedbackDisabled()
																															.withPermissionLevel(4),
																													"kill @e[type=mso:projectile_swordslash]");
																								}
																							}
																							MinecraftForge.EVENT_BUS.unregister(this);
																						}
																					}.start(world, (int) 0.15);
																					MinecraftForge.EVENT_BUS.unregister(this);
																				}
																			}.start(world, (int) 4.85);
																			MinecraftForge.EVENT_BUS.unregister(this);
																		}
																	}.start(world, (int) 0.15);
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 4.85);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 0.15);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 4.85);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 0.15);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 4.85);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 0.15);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 4.85);
		}
	}
}
