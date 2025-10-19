package com.github.s3114.testmod.tab;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.block.TestModBlocks;
import com.github.s3114.testmod.item.TestModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TestModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = TABS.register("test_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TestModItems.RAW_HOGE.get()))
                    .title(Component.translatable("creativetab.test_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(TestModItems.RAW_HOGE.get());
                        pOutput.accept(TestModItems.HOGE.get());

                        pOutput.accept(TestModBlocks.HOGE_BLOCK.get());
                        pOutput.accept(TestModBlocks.HOGE_ORE.get());
                        pOutput.accept(TestModBlocks.DEEPSLATE_HOGE_ORE.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
