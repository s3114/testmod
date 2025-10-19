package com.github.s3114.testmod.datagen.server;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.item.TestModItems;
import com.github.s3114.testmod.loot.AddItemModifier;
import com.github.s3114.testmod.loot.ReplaceItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class TestModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public TestModGlobalLootModifierProvider(PackOutput output) {
        super(output, TestMod.MODID);
    }

    @Override
    protected void start() {
        //廃ポータルのチェスト
        add("raw_hoge_from_ruined_portal",new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/ruined_portal")
                ).build()
        }, TestModItems.RAW_HOGE.get()));

        //ゾンビのドロップ
        add("raw_hoge_from_zombie",new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("entities/zombie")
                ).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, TestModItems.RAW_HOGE.get()));

        //スニッファーの掘り出し物
        add("raw_hoge_from_sniffer_digging",new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("gameplay/sniffer_digging")
                ).build()
        }, TestModItems.RAW_HOGE.get(), 0.5f));

        //怪しげな砂
        add("raw_hoge_from_sus_sand",new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("archaeology/desert_pyramid")
                ).build()
        }, TestModItems.RAW_HOGE.get(), 0.5f));
    }
}