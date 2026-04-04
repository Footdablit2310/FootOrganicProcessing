package com.footdablit2310.footorganicprocessing.content.ptf;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PtfBlockEntity extends BlockEntity {

    public PtfBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PTF_BE.get(), pos, state);
    }

    //TODO:# FE storage + consumption
    //TODO:# temperature modes (750°C / 1500°C)
    //TODO:# coil wear + tier logic
    //TODO:# multiblock structure validation
    //TODO:# hook into PTF recipe system
}
