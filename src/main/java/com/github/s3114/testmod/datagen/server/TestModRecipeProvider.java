package com.github.s3114.testmod.datagen.server;

import com.github.s3114.testmod.TestMod;
import com.github.s3114.testmod.block.TestModBlocks;
import com.github.s3114.testmod.item.TestModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class TestModRecipeProvider extends RecipeProvider {

    private static final List<ItemLike> HOGE_SMELTABLE =
            List.of(TestModItems.RAW_HOGE.get(),
                    TestModBlocks.HOGE_ORE.get(),
                    TestModBlocks.DEEPSLATE_HOGE_ORE.get());

    public TestModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC,
                TestModItems.RAW_HOGE.get(),
                RecipeCategory.BUILDING_BLOCKS,
                TestModBlocks.HOGE_BLOCK.get());
        oreSmelting(consumer, HOGE_SMELTABLE, RecipeCategory.MISC,
                TestModItems.HOGE.get(), 1.0f,200,"hoge");
        oreBlasting(consumer, HOGE_SMELTABLE, RecipeCategory.MISC,
                TestModItems.HOGE.get(), 1.0f,100,"hoge");
    }

    //かまど
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    //溶鉱炉
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    //全体
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,
                            TestMod.MODID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder
                .shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder
                .shaped(pPackedCategory, pPacked)
                .define('#', pUnpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked))
                .save(pFinishedRecipeConsumer);
    }
}
