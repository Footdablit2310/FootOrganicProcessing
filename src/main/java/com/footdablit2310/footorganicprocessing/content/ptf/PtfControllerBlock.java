package com.footdablit2310.footorganicprocessing.content.ptf;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;

public class PtfControllerBlock extends Block implements EntityBlock {

    public PtfControllerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PtfBlockEntity(pos, state);
    }

    //TODO:# right-click to open UI / show status
    //TODO:# multiblock validation hook
}
