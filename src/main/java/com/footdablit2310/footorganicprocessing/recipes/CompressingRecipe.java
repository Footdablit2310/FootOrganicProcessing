package com.footdablit2310.footorganicprocessing.recipes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.Level;
import java.util.List;

public class CompressingRecipe implements Recipe<RecipeInput> {

    private final ResourceLocation id;
    private final List<Ingredient> inputs;
    private final ItemStack result;
    private final int duration;
    private final int stress;

    public CompressingRecipe(ResourceLocation id, List<Ingredient> inputs, ItemStack result, int duration, int stress) {
        this.id = id;
        this.inputs = inputs;
        this.result = result;
        this.duration = duration;
        this.stress = stress;
    }

    public List<Ingredient> getInputs() { return inputs; }
    public int getDuration() { return duration; }
    public int getStress() { return stress; }

    @Override
    public boolean matches(RecipeInput input, Level level) {
        return false; // Squeezer handles matching manually
    }

    @Override
    public ItemStack assemble(RecipeInput input, HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result.copy();
    }

    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FootRecipeSerializers.COMPRESSING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return FootRecipeTypes.COMPRESSING.get();
    }
}
