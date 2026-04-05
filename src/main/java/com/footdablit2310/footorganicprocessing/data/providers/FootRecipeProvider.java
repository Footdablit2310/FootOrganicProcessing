package com.footdablit2310.footorganicprocessing.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.footdablit2310.footorganicprocessing.registry.ModItems;
import com.footdablit2310.footorganicprocessing.data.recipes.CompressingRecipeBuilder;

public class FootRecipeProvider extends RecipeProvider {

    public FootRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }
    protected ResourceLocation modLoc(String path) {
    return ResourceLocation.fromNamespaceAndPath("footorganicprocessing", path);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        // Spirit Glue (Sticky Residue + Resin)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SPIRIT_GLUE.get())
                .requires(ModItems.STICKY_RESIDUE.get())
                .requires(ModItems.RESIN.get())
                .unlockedBy("has_resin", has(ModItems.RESIN.get()))
                .save(output);

        // Sticky Residue (placeholder)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STICKY_RESIDUE.get())
                .requires(Items.HONEYCOMB)
                .requires(ModItems.RESIN.get())
                .unlockedBy("has_resin", has(ModItems.RESIN.get()))
                .save(output);

        // Plastic (placeholder)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLASTIC.get())
                .requires(ModItems.RESIN.get())
                .unlockedBy("has_resin", has(ModItems.RESIN.get()))
                .save(output);
        CompressingRecipeBuilder.compressing(ModItems.ULTRA_STURDY_SHEET.get())
                .addInput(Ingredient.of(AllBlocks.BRASS_BLOCK))
                .addInput(Ingredient.of(AllItems.STURDY_SHEET.get()))
                .duration(432000) // 6 IRL hours at 20 TPS
                .stress(2048)
                .save(output, modLoc("ultra_sturdy_sheet"));

        //TODO:# add Create recipes (Press, Mixer, Basin)
        //TODO:# add PTF recipes
    }

}
