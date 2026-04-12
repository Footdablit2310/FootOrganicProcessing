package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.recipe.CentrifugeRecipe;
import com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.recipe.CentrifugeRecipeSerializer;
import com.footdablit2310.footorganicprocessing.content.recipes.PTFRecipe;
import com.footdablit2310.footorganicprocessing.content.recipes.SqueezerRecipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModRecipeTypes {

    // -------------------------
    // Deferred Registers
    // -------------------------
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, FootOrganicProcessing.MOD_ID);

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, FootOrganicProcessing.MOD_ID);

    // -------------------------
    // PTF
    // -------------------------
    public static final DeferredHolder<RecipeType<?>, RecipeType<PTFRecipe>> PTF =
            RECIPE_TYPES.register("ptf", () -> new RecipeType<PTFRecipe>() {});

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PTFRecipe>> PTF_SERIALIZER =
            SERIALIZERS.register("ptf", PTFRecipe.Serializer::new);

    // -------------------------
    // Squeezer
    // -------------------------
    public static final DeferredHolder<RecipeType<?>, RecipeType<SqueezerRecipe>> SQUEEZER =
            RECIPE_TYPES.register("squeezer", () -> new RecipeType<SqueezerRecipe>() {});

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SqueezerRecipe>> SQUEEZER_SERIALIZER =
            SERIALIZERS.register("squeezer", SqueezerRecipe.Serializer::new);

    // -------------------------
    // Centrifuge
    // -------------------------
    public static final DeferredHolder<RecipeType<?>, RecipeType<CentrifugeRecipe>> CENTRIFUGE =
            RECIPE_TYPES.register("centrifuge", () -> new RecipeType<CentrifugeRecipe>() {});

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CentrifugeRecipe>> CENTRIFUGE_SERIALIZER =
            SERIALIZERS.register("centrifuge", CentrifugeRecipeSerializer::new);

    public static void register() {}
}
