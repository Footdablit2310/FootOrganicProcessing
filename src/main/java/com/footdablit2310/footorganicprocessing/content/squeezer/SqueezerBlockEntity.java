package com.footdablit2310.footorganicprocessing.content.squeezer;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SqueezerBlockEntity extends KineticBlockEntity {

    public SqueezerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SQUEEZER_BE.get(), pos, state);
    }

    @Override
    public float calculateStressApplied() {
        return 64f;
    }

    //TODO:# add processing logic (log → resin + stick)
    //TODO:# add animation sync for dual clamp
}
