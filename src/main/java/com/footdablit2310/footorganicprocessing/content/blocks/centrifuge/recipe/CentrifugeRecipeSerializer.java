package com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.recipe;

import com.footdablit2310.footlib.api.common.heat.HeatTier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

import java.util.ArrayList;
import java.util.List;

public class CentrifugeRecipeSerializer implements RecipeSerializer<CentrifugeRecipe> {

    public static final MapCodec<CentrifugeRecipe> CODEC =
        RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                ResourceLocation.CODEC.fieldOf("id").forGetter(CentrifugeRecipe::getId),
                ItemStack.CODEC.fieldOf("input").forGetter(CentrifugeRecipe::getInput),
                ItemStack.CODEC.listOf().fieldOf("outputs").forGetter(CentrifugeRecipe::getOutputs),
                HeatTier.CODEC.fieldOf("heat").forGetter(CentrifugeRecipe::getRequiredHeat)
            ).apply(instance, CentrifugeRecipe::new)
        );

    @Override
    public MapCodec<CentrifugeRecipe> codec() {
        return CODEC;
    }

    public static final StreamCodec<RegistryFriendlyByteBuf, CentrifugeRecipe> STREAM_CODEC =
        new StreamCodec<>() {

            @Override
            public CentrifugeRecipe decode(RegistryFriendlyByteBuf buf) {
                ResourceLocation id = ResourceLocation.STREAM_CODEC.decode(buf);
                ItemStack input = ItemStack.STREAM_CODEC.decode(buf);

                int size = buf.readVarInt();
                List<ItemStack> outputs = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    outputs.add(ItemStack.STREAM_CODEC.decode(buf));
                }

                HeatTier heat = buf.readEnum(HeatTier.class);

                return new CentrifugeRecipe(id, input, outputs, heat);
            }

            @Override
            public void encode(RegistryFriendlyByteBuf buf, CentrifugeRecipe recipe) {
                ResourceLocation.STREAM_CODEC.encode(buf, recipe.getId());
                ItemStack.STREAM_CODEC.encode(buf, recipe.getInput());

                List<ItemStack> outputs = recipe.getOutputs();
                buf.writeVarInt(outputs.size());
                for (ItemStack stack : outputs) {
                    ItemStack.STREAM_CODEC.encode(buf, stack);
                }

                buf.writeEnum(recipe.getRequiredHeat());
            }
        };

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CentrifugeRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
