package com.github.s3114.testmod.loot;

import com.github.s3114.testmod.TestMod;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestModLootModifiers {
    // レジストリを作成
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
                    TestMod.MODID);
    // レジストリにCodecを追加
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> REPLACE_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("replace_item", ReplaceItemModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}