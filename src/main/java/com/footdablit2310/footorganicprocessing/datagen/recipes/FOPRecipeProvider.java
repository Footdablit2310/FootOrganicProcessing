package com.footdablit2310.footorganicprocessing.datagen.recipes;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.registry.ModItems;
import com.footdablit2310.footorganicprocessing.registry.ModTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class FOPRecipeProvider extends RecipeProvider {

    public FOPRecipeProvider(PackOutput output,
                             CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {

    // --- BIOMASS YIELD RECIPES (DONE) ---

    // TODO: Organic chain recipes
    // TODO: Resin → wax → glue chain
    // TODO: Tar → soot → hydrocarbons chain

    // --- CREATE-STYLE RECIPES ---
    // These are just JSON recipes with type "create:mixing", "create:compacting", etc.
    // You can generate them manually or via a helper.

    // TODO: create:mixing — biomass slurry
    // TODO: create:mixing — polymer precursor
    // TODO: create:compacting — resin blocks
    // TODO: create:pressing — wax sheets
    // TODO: create:centrifuging — tar separation

    // --- PTF RECIPES ---
    // Custom recipe types (if you add them) or Create heating recipes.

    // TODO: PTF Heated (750°C)
    // TODO: PTF Superheated (1500°C)
    // TODO: PTF Ultraheated (3000°C)

    // TODO: PTF coil/casing tier JSONs
    // TODO: PTF tier grid JSONs
    }

}
