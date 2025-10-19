package com.github.s3114.testmod.datagen.cliant;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.item.TestModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TestModItemModelProvider extends ItemModelProvider {
    public TestModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(TestModItems.RAW_HOGE.get());
        basicItem(TestModItems.HOGE.get());
    }
}
