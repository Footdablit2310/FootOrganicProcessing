package com.footdablit2310.footorganicprocessing.content.squeezer;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SqueezerBlockEntity extends KineticBlockEntity {

    private SqueezerMode mode = SqueezerMode.SQUEEZING;

    public SqueezerMode getMode() {
        return mode;
    }

    public void setMode(SqueezerMode mode) {
        this.mode = mode;
        setChanged();
    }


    public SqueezerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SQUEEZER_BE.get(), pos, state);
    }

    @Override
    public float calculateStressApplied() {
        if (mode == SqueezerMode.SQUEEZING) {
            return 64f;
        }
        return 2048f;
    }

    public enum SqueezerMode {
        SQUEEZING,
        COMPRESSING
    }
    


    //TODO:# add processing logic (log → resin + stick)
    //TODO:# add animation sync for dual clamp
}
