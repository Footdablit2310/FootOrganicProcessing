package com.footdablit2310.footorganicprocessing.recipes;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FootRecipeSerializers {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, "footorganicprocessing");

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CompressingRecipe>> COMPRESSING =
            SERIALIZERS.register("compressing", CompressingRecipeSerializer::new);
}
