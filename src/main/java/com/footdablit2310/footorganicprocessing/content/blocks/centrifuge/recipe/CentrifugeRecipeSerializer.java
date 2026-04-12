package com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.recipe;

import com.footdablit2310.footlib.api.common.heat.HeatTier;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.ArrayList;
import java.util.List;

public class CentrifugeRecipeSerializer implements RecipeSerializer<CentrifugeRecipe> {

    // JSON codec (id is injected by RecipeManager, not stored in JSON)
    public static final MapCodec<CentrifugeRecipe> CODEC =
        RecordCodecBuilder.mapCodec(instance -> instance.group(
            ItemStack.CODEC.fieldOf("input").forGetter(CentrifugeRecipe::getInput),
            ItemStack.CODEC.listOf().fieldOf("outputs").forGetter(CentrifugeRecipe::getOutputs),
            HeatTier.CODEC.fieldOf("heat").forGetter(CentrifugeRecipe::getRequiredHeat)
        ).apply(instance, (input, outputs, heat) ->
            new CentrifugeRecipe(
                ResourceLocation.fromNamespaceAndPath("footop", "dummy"), // replaced later by RecipeManager
                input,
                outputs,
                heat
            )
        ));

    // Network codec
    public static final StreamCodec<RegistryFriendlyByteBuf, CentrifugeRecipe> STREAM_CODEC =
        new StreamCodec<>() {

            @Override
            public void encode(RegistryFriendlyByteBuf buf, CentrifugeRecipe recipe) {
                // input
                ItemStack.STREAM_CODEC.encode(buf, recipe.getInput());

                // outputs
                buf.writeVarInt(recipe.getOutputs().size());
                for (ItemStack stack : recipe.getOutputs()) {
                    ItemStack.STREAM_CODEC.encode(buf, stack);
                }

                // heat tier
                buf.writeEnum(recipe.getRequiredHeat());
            }

            @Override
            public CentrifugeRecipe decode(RegistryFriendlyByteBuf buf) {
                // input
                ItemStack input = ItemStack.STREAM_CODEC.decode(buf);

                // outputs
                int count = buf.readVarInt();
                List<ItemStack> outputs = new ArrayList<>(count);
                for (int i = 0; i < count; i++) {
                    outputs.add(ItemStack.STREAM_CODEC.decode(buf));
                }

                // heat tier
                HeatTier heat = buf.readEnum(HeatTier.class);

                return new CentrifugeRecipe(
                    ResourceLocation.fromNamespaceAndPath("footop", "dummy"),
                    input,
                    outputs,
                    heat
                );
            }
        };

    @Override
    public MapCodec<CentrifugeRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CentrifugeRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
