package com.footdablit2310.footorganicprocessing.content.blocks.squeezer;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.footdablit2310.footorganicprocessing.registry.ModRecipeTypes;
import com.footdablit2310.footorganicprocessing.content.recipes.SimpleRecipeInput;
import com.footdablit2310.footorganicprocessing.content.recipes.SqueezerRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Optional;

public class SqueezerBlockEntity extends BlockEntity {

    public enum SqueezerMode {
        SQUEEZING,
        COMPRESSING
    }

    private final SimpleContainer inventory = new SimpleContainer(2);
    private int progress = 0;
    private static final int MAX_PROGRESS = 100;

    private SqueezerMode mode = SqueezerMode.SQUEEZING;

    public SqueezerBlockEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.SQUEEZER.get(), pos, state);
    }

    public void setMode(SqueezerMode mode) {
        this.mode = mode;
        setChanged();
    }

    public SqueezerMode getMode() {
        return mode;
    }

    // -----------------------------------------------------
    // TICK LOOP
    // -----------------------------------------------------
    public static void tick(Level level, BlockPos pos, BlockState state, SqueezerBlockEntity be) {
        if (level.isClientSide) return;

        Optional<RecipeHolder<SqueezerRecipe>> recipe = be.getCurrentRecipe(level);

        if (recipe.isEmpty()) {
            be.progress = 0;
            return;
        }

        be.progress++;

        if (be.progress >= MAX_PROGRESS) {
            be.craft(recipe.get(), level.registryAccess());
            be.progress = 0;
        }

        be.setChanged();
    }

    // -----------------------------------------------------
    // RECIPE LOOKUP
    // -----------------------------------------------------
    private Optional<RecipeHolder<SqueezerRecipe>> getCurrentRecipe(Level level) {
        SimpleRecipeInput input = new SimpleRecipeInput(inventory.getItem(0));

        return level.getRecipeManager().getRecipeFor(ModRecipeTypes.SQUEEZER.get(), input, level);

    }

    // -----------------------------------------------------
    // CRAFTING
    // -----------------------------------------------------
    private void craft(RecipeHolder<SqueezerRecipe> holder, HolderLookup.Provider provider) {
        SqueezerRecipe recipe = holder.value();

        ItemStack result = recipe.getResultItem(provider);
        ItemStack output = inventory.getItem(1);

        if (output.isEmpty()) {
            inventory.setItem(1, result.copy());
        } else if (output.is(result.getItem())) {
            output.grow(result.getCount());
        }

        inventory.removeItem(0, 1);
    }
}
