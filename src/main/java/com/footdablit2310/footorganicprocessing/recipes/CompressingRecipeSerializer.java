package com.footdablit2310.footorganicprocessing.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;

public class CompressingRecipeSerializer implements RecipeSerializer<CompressingRecipe> {

    public static final MapCodec<CompressingRecipe> CODEC =
        RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                Ingredient.CODEC.listOf().fieldOf("inputs").forGetter(CompressingRecipe::getInputs),
                ItemStack.CODEC.fieldOf("result").forGetter(r -> r.getResultItem(null)),
                com.mojang.serialization.Codec.INT.fieldOf("duration").forGetter(CompressingRecipe::getDuration),
                com.mojang.serialization.Codec.INT.fieldOf("stress").forGetter(CompressingRecipe::getStress)
            ).apply(instance, (inputs, result, duration, stress) ->
                new CompressingRecipe(null, inputs, result, duration, stress)
            )
        );

    public static final StreamCodec<RegistryFriendlyByteBuf, CompressingRecipe> STREAM_CODEC =
        StreamCodec.of(
            (buf, recipe) -> {
                buf.writeVarInt(recipe.getInputs().size());
                for (Ingredient ing : recipe.getInputs()) {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ing);
                }
                ItemStack.STREAM_CODEC.encode(buf, recipe.getResultItem(null));
                buf.writeInt(recipe.getDuration());
                buf.writeInt(recipe.getStress());
            },
            buf -> {
                int count = buf.readVarInt();
                List<Ingredient> inputs = new java.util.ArrayList<>();
                for (int i = 0; i < count; i++) {
                    inputs.add(Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
                }
                ItemStack result = ItemStack.STREAM_CODEC.decode(buf);
                int duration = buf.readInt();
                int stress = buf.readInt();
                return new CompressingRecipe(null, inputs, result, duration, stress);
            }
        );

    @Override
    public MapCodec<CompressingRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CompressingRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
