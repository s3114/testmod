package com.github.s3114.testmod.datagen.server.loot;

import com.github.s3114.testmod.block.TestModBlocks;
import com.github.s3114.testmod.item.TestModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class TestModBlockLootTables extends BlockLootSubProvider {
    protected TestModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(TestModBlocks.HOGE_BLOCK.get());
        this.add(TestModBlocks.HOGE_ORE.get(), block -> this.createOreDrop(block, TestModItems.RAW_HOGE.get()));
        this.add(TestModBlocks.DEEPSLATE_HOGE_ORE.get(), block -> this.createOreDrop(block, TestModItems.RAW_HOGE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TestModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
