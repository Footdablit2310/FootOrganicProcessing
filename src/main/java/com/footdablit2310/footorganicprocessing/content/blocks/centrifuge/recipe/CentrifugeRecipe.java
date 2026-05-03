package com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.recipe;

import com.footdablit2310.footorganicprocessing.registry.ModRecipeTypes;
import com.footdablit2310.footlib.api.common.heat.HeatTier;

import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public class CentrifugeRecipe implements Recipe<RecipeInput> {

    private final ResourceLocation id;
    private final ItemStack input;
    private final List<ItemStack> outputs;
    private final HeatTier requiredHeat;

    public CentrifugeRecipe(ResourceLocation id,
                            ItemStack input,
                            List<ItemStack> outputs,
                            HeatTier requiredHeat) {
        this.id = id;
        this.input = input;
        this.outputs = outputs;
        this.requiredHeat = requiredHeat;
    }

    public ResourceLocation getId() {
        return id;
    }

    public ItemStack getInput() {
        return input;
    }

    public List<ItemStack> getOutputs() {
        return outputs;
    }

    public HeatTier getRequiredHeat() {
        return requiredHeat;
    }

    @Override
    public boolean matches(RecipeInput inv, Level level) {
        // BE handles matching
        return true;
    }

    @Override
    public ItemStack assemble(RecipeInput inv, HolderLookup.Provider provider) {
        // BE handles output
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return false;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return outputs.isEmpty() ? ItemStack.EMPTY : outputs.get(0);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.CENTRIFUGE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.CENTRIFUGE.get();
    }
}
