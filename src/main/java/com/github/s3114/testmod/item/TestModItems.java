package com.github.s3114.testmod.item;

import com.github.s3114.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestModItems {
    //レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    //レジストリにアイテムを登録
    public static final RegistryObject<Item> RAW_HOGE = ITEMS.register("raw_hoge", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HOGE = ITEMS.register("hoge", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        //レジストリをeventbusに追加
        ITEMS.register(eventBus);
    }
}
