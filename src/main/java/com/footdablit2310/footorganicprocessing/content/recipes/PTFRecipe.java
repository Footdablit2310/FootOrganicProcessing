package com.footdablit2310.footorganicprocessing.content.recipes;

import com.footdablit2310.footorganicprocessing.registry.ModRecipeTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class PTFRecipe implements Recipe<RecipeInput> {

    private final ResourceLocation id;

    public PTFRecipe(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public boolean matches(RecipeInput input, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(RecipeInput input, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return true;
    }

    // ❗ keep this, but REMOVE @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
    return ModRecipeTypes.PTF_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
    return ModRecipeTypes.PTF.get();
    }


    public static class Serializer implements RecipeSerializer<PTFRecipe> {

        @Override
        public MapCodec<PTFRecipe> codec() {
            return ResourceLocation.CODEC
                    .fieldOf("id")
                    .xmap(PTFRecipe::new, PTFRecipe::getId);
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, PTFRecipe> streamCodec() {
            return StreamCodec.of(
                    (buf, recipe) -> buf.writeResourceLocation(recipe.getId()),
                    buf -> new PTFRecipe(buf.readResourceLocation())
            );
        }
    }
}
