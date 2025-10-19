package com.github.s3114.testmod.datagen.cliant;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.block.TestModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TestModBlockStateProvider extends BlockStateProvider {

    public TestModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MODID , exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(TestModBlocks.HOGE_BLOCK);
        simpleBlockWithItem(TestModBlocks.HOGE_ORE);
        simpleBlockWithItem(TestModBlocks.DEEPSLATE_HOGE_ORE);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
