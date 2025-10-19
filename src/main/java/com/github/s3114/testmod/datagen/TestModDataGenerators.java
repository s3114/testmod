package com.github.s3114.testmod.datagen;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.datagen.cliant.ENUSLaunguageProvider;
import com.github.s3114.testmod.datagen.cliant.JAJPLaunguageProvider;
import com.github.s3114.testmod.datagen.cliant.TestModBlockStateProvider;
import com.github.s3114.testmod.datagen.cliant.TestModItemModelProvider;
import com.github.s3114.testmod.datagen.server.TestModBlockTagsProvider;
import com.github.s3114.testmod.datagen.server.TestModGlobalLootModifierProvider;
import com.github.s3114.testmod.datagen.server.TestModRecipeProvider;
import com.github.s3114.testmod.datagen.server.TestModWorldGenProvider;
import com.github.s3114.testmod.datagen.server.loot.TestModLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        // Itemのモデルファイルの生成
        generator.addProvider(event.includeClient(), new TestModItemModelProvider(packOutput, existingFileHelper));

        // Blockのモデルファイルの生成
        generator.addProvider(event.includeClient(), new TestModBlockStateProvider(packOutput, existingFileHelper));

        // ENUSの言語ファイルの生成
        generator.addProvider(event.includeClient(), new ENUSLaunguageProvider(packOutput));

        // JAJPの言語ファイルの生成
        generator.addProvider(event.includeClient(), new JAJPLaunguageProvider(packOutput));

        // レシピファイルの生成
        generator.addProvider(event.includeServer(), new TestModRecipeProvider(packOutput));

        // ルートテーブルの生成
        generator.addProvider(event.includeServer(), TestModLootTables.create(packOutput));

        // ブロックタグの生成
        generator.addProvider(event.includeServer(), new TestModBlockTagsProvider(packOutput, lookUpProvider, existingFileHelper));

        // GlobalLootModifier
        generator.addProvider(event.includeServer(), new TestModGlobalLootModifierProvider(packOutput));

        // WorldGen
        generator.addProvider(event.includeServer(), new TestModWorldGenProvider(packOutput, lookUpProvider));

    }
}
