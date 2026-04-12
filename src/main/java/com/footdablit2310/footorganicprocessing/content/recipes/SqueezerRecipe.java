package com.footdablit2310.footorganicprocessing.content.recipes;

import com.footdablit2310.footorganicprocessing.registry.ModRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.network.codec.StreamCodec;

public class SqueezerRecipe implements Recipe<RecipeInput> {

    private final ResourceLocation id;

    public SqueezerRecipe(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public boolean matches(RecipeInput input, Level level) { return false; }

    @Override
    public ItemStack assemble(RecipeInput input, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) { return true; }

    public ResourceLocation getId() { return id; }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.SQUEEZER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.SQUEEZER.get();
    }


    public static class Serializer implements RecipeSerializer<SqueezerRecipe> {

        @Override
        public MapCodec<SqueezerRecipe> codec() {
            return ResourceLocation.CODEC
                    .fieldOf("id")
                    .xmap(SqueezerRecipe::new, SqueezerRecipe::getId);
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SqueezerRecipe> streamCodec() {
            return StreamCodec.of(
                    (buf, recipe) -> buf.writeResourceLocation(recipe.getId()),
                    buf -> new SqueezerRecipe(buf.readResourceLocation())
            );
        }
    }
}
