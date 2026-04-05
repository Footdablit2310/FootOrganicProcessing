package com.footdablit2310.footorganicprocessing.data.recipes;

import com.footdablit2310.footorganicprocessing.recipes.CompressingRecipe;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.ArrayList;
import java.util.List;

public class CompressingRecipeBuilder {

    private final List<Ingredient> inputs = new ArrayList<>();
    private final ItemStack result;
    private int duration = 432000;
    private int stress = 2048;

    public CompressingRecipeBuilder(ItemStack result) {
        this.result = result;
    }

    public static CompressingRecipeBuilder compressing(Item result) {
        return new CompressingRecipeBuilder(new ItemStack(result));
    }

    public CompressingRecipeBuilder addInput(Ingredient ingredient) {
        inputs.add(ingredient);
        return this;
    }

    public CompressingRecipeBuilder duration(int ticks) {
        this.duration = ticks;
        return this;
    }

    public CompressingRecipeBuilder stress(int su) {
        this.stress = su;
        return this;
    }

    public void save(RecipeOutput output, ResourceLocation id) {
        output.accept(id,
        new CompressingRecipe(id, inputs, result, duration, stress),
        null
        );
    }
}
