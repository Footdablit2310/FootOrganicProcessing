package com.footdablit2310.footorganicprocessing.content.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class SimpleRecipeInput implements RecipeInput {

    private final ItemStack stack;

    public SimpleRecipeInput(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack getItem(int index) {
        return index == 0 ? stack : ItemStack.EMPTY;
    }

    @Override
    public int size() {
        return 1;
    }
}
