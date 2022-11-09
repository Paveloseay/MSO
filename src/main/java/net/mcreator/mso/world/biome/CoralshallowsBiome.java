
package net.mcreator.mso.world.biome;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import net.mcreator.mso.entity.FyshEntity;
import net.mcreator.mso.block.GlazesandBlock;
import net.mcreator.mso.MsoModElements;

@MsoModElements.ModElement.Tag
public class CoralshallowsBiome extends MsoModElements.ModElement {
	public static Biome biome;

	public CoralshallowsBiome(MsoModElements instance) {
		super(instance, 148);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(-14300984).setWaterFogColor(-14511457)
						.withSkyColor(7972607).withFoliageColor(-15961776).withGrassColor(-14712261).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(GlazesandBlock.block.getDefaultState(),
								GlazesandBlock.block.getDefaultState(), Blocks.WATER.getDefaultState())));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(FyshEntity.entity, 20, 5, 5));
				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-0.5f).scale(0.1f).temperature(1f)
						.downfall(0.5f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("mso:coralshallows"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), BiomeDictionary.Type.WET,
				BiomeDictionary.Type.OCEAN);
	}
}
