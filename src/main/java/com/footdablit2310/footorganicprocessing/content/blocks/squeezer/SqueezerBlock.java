package com.footdablit2310.footorganicprocessing.content.blocks.squeezer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SqueezerBlock extends Block implements EntityBlock {

    public SqueezerBlock(Properties props) {
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SqueezerBlockEntity(pos, state);
    }
}
