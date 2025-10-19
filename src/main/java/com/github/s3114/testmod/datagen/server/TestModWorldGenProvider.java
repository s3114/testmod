package com.github.s3114.testmod.datagen.server;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.worldgen.biome.TestModBiomeModifiers;
import com.github.s3114.testmod.worldgen.features.TestModOreFeatures;
import com.github.s3114.testmod.worldgen.placement.TestModOrePlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TestModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, TestModOreFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, TestModOrePlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, TestModBiomeModifiers::bootstrap);

    public TestModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TestMod.MODID));
    }
}
