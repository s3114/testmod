package com.github.s3114.testmod.block;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.item.TestModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TestModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    public static final RegistryObject<Block> HOGE_BLOCK = registerBlockItem("hoge_block",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_BLOCK).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> HOGE_ORE = registerBlockItem("hoge_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_BLOCK),
                    UniformInt.of(3, 1000000000)));

    public static final RegistryObject<Block> DEEPSLATE_HOGE_ORE = registerBlockItem("deepslate_hoge_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));


    private static <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        TestModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
