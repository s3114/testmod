package com.github.s3114.testmod.datagen.server;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.block.TestModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TestModBlockTagsProvider extends BlockTagsProvider {
    public TestModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TestModBlocks.HOGE_BLOCK.get(),
                TestModBlocks.HOGE_ORE.get(),
                TestModBlocks.DEEPSLATE_HOGE_ORE.get()
        );
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                TestModBlocks.HOGE_BLOCK.get(),
                TestModBlocks.HOGE_ORE.get(),
                TestModBlocks.DEEPSLATE_HOGE_ORE.get()
                );
    }
}
