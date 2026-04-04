package com.footdablit2310.footorganicprocessing.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import java.util.concurrent.CompletableFuture;
import net.minecraft.world.item.Items;
import com.footdablit2310.footorganicprocessing.registry.ModItems;

public class FootRecipeProvider extends RecipeProvider {

    public FootRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
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

        //TODO:# add Create recipes (Press, Mixer, Basin)
        //TODO:# add PTF recipes
    }

}
