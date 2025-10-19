package com.github.s3114.testmod.worldgen.placement;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.worldgen.features.TestModOreFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class TestModOrePlacement {

    public static final ResourceKey<PlacedFeature> ORE_HOGE =
            createKey("ore_hoge");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, ORE_HOGE,
                configuredFeatures.getOrThrow(TestModOreFeatures.HOGE_ORE_KEY),
                commonOrePlacement(90,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(112))));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(TestMod.MODID, name));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}