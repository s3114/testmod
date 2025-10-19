package com.github.s3114.testmod;

import com.github.s3114.testmod.block.TestModBlocks;
import com.github.s3114.testmod.loot.TestModLootModifiers;
import com.github.s3114.testmod.tab.TestModTabs;
import com.github.s3114.testmod.item.TestModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;


// TODO https://www.youtube.com/watch?v=kvHwqzwTsKI&t=245s
@Mod(TestMod.MODID)
public class TestMod {
    public static final String MODID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        //アイテムレジストリをイベントバスに登録
        TestModItems.register(modEventBus);

        //クリエイティブタブをイベントバスに登録
        TestModTabs.register(modEventBus);

        //ブロックレジストリをイベントバスに登録
        TestModBlocks.register(modEventBus);

        // GlobalLootModifierレジストリをイベントバスに登録
        TestModLootModifiers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

//        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

//    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if(event.getTabKey() == Tabs.TEST_TAB.getKey()) {
//            event.accept(Items.RAW_HOGE);
//        }
//    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
