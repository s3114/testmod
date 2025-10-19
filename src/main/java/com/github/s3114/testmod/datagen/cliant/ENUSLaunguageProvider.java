package com.github.s3114.testmod.datagen.cliant;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.block.TestModBlocks;
import com.github.s3114.testmod.item.TestModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLaunguageProvider extends LanguageProvider {
    public ENUSLaunguageProvider(PackOutput output) {
        super(output, TestMod.MODID , Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(TestModItems.RAW_HOGE,"Raw Hoge");
        addItem(TestModItems.HOGE,"Hoge");

        addBlock(TestModBlocks.HOGE_BLOCK,"Hoge Block");
        addBlock(TestModBlocks.HOGE_ORE,"Hoge Ore");
        addBlock(TestModBlocks.DEEPSLATE_HOGE_ORE,"Deepslate Hoge Ore");

        add("creativetab.test_tab", "Test Tab");

    }
}
