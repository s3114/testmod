package com.github.s3114.testmod.worldgen.features;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.block.TestModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class TestModOreFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOGE_ORE_KEY =
            createKey("hoge_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> hogeOres = List.of(
                OreConfiguration.target(stone, TestModBlocks.HOGE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate, TestModBlocks.DEEPSLATE_HOGE_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(context, HOGE_ORE_KEY, Feature.ORE, new OreConfiguration(hogeOres,9 ));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(TestMod.MODID, name));
    }
}
