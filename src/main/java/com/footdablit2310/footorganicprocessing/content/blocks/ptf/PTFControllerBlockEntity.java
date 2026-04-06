package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;

public class PTFControllerBlockEntity extends BlockEntity {

    public PTFControllerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PTF_CONTROLLER_BE.get(), pos, state);
    }

    //TODO: Ticking logic will be added later (Step F)
}
