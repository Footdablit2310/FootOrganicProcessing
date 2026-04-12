package com.footdablit2310.footorganicprocessing.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class PTFHeatedRecipe implements Recipe<RecipeInput> {

    public enum HeatTier {
        HEATED_750,
        SUPERHEATED_1500,
        ULTRAHEATED_3000
    }

    private final ResourceLocation id;
    private final HeatTier heatTier;
    private final ItemStack input;
    private final ItemStack output;
    private final float secondaryYield;

    public PTFHeatedRecipe(ResourceLocation id, HeatTier heatTier,
                           ItemStack input, ItemStack output, float secondaryYield) {
        this.id = id;
        this.heatTier = heatTier;
        this.input = input;
        this.output = output;
        this.secondaryYield = secondaryYield;
    }

    @Override
    public boolean matches(RecipeInput inv, Level level) {
        return true; // refine later
    }

    @Override
    public ItemStack assemble(RecipeInput inv, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return true;
    }

    public ResourceLocation getId() {
        return id;
    }

    // These will compile once ModRecipeTypes/Serializers exist
    @Override
    public RecipeSerializer<?> getSerializer() {
        return null; // placeholder
    }

    @Override
    public RecipeType<?> getType() {
        return null; // placeholder
    }

    public HeatTier heatTier() {
        return heatTier;
    }

    public float secondaryYield() {
        return secondaryYield;
    }

    public ItemStack input() {
        return input;
    }
}
