package com.github.s3114.testmod.datagen.cliant;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.block.TestModBlocks;
import com.github.s3114.testmod.item.TestModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLaunguageProvider extends LanguageProvider {
    public JAJPLaunguageProvider(PackOutput output) {
        super(output, TestMod.MODID , Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(TestModItems.RAW_HOGE,"生のHoge");
        addItem(TestModItems.HOGE,"Hoge");

        addBlock(TestModBlocks.HOGE_BLOCK,"Hogeブロック");
        addBlock(TestModBlocks.HOGE_ORE,"Hoge鉱石");
        addBlock(TestModBlocks.DEEPSLATE_HOGE_ORE,"深層Hoge鉱石");

        add("creativetab.test_tab", "テストタブ");

    }
}
