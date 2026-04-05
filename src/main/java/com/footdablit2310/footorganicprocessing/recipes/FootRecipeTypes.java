package com.footdablit2310.footorganicprocessing.recipes;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.resources.ResourceLocation;

public class FootRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, "footorganicprocessing");

    public static final DeferredHolder<RecipeType<?>, RecipeType<CompressingRecipe>> COMPRESSING =
            TYPES.register("compressing",
                    () -> RecipeType.simple(ResourceLocation.fromNamespaceAndPath("footorganicprocessing", "compressing")));
}
