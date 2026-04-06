package com.footdablit2310.footorganicprocessing.content.blocks.squeezer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;

public class SqueezerBlockEntity extends BlockEntity {

    public enum SqueezerMode {
        SQUEEZING,
        COMPRESSING
    }

    private SqueezerMode mode = SqueezerMode.SQUEEZING;

    public SqueezerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SQUEEZER_BE.get(), pos, state);
    }

    public void setMode(SqueezerMode mode) {
        this.mode = mode;
        setChanged();
    }

    public SqueezerMode getMode() {
        return mode;
    }

    // Ticking logic will be added later (Step F)
}
