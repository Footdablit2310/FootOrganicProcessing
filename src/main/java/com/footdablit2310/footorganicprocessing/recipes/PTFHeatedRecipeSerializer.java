package com.footdablit2310.footorganicprocessing.recipes;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class PTFHeatedRecipeSerializer implements RecipeSerializer<PTFHeatedRecipe> {

    // JSON codec — always returns null for now
    public static final MapCodec<PTFHeatedRecipe> CODEC =
            MapCodec.unit((PTFHeatedRecipe) null);

    // Network codec — always returns null for now
    public static final StreamCodec<RegistryFriendlyByteBuf, PTFHeatedRecipe> STREAM_CODEC =
            StreamCodec.unit((PTFHeatedRecipe) null);
    // TODO: Make this file operational by implementing the codecs and registering the serializer.
    @Override
    public MapCodec<PTFHeatedRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, PTFHeatedRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
