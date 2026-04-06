package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PTFControllerBlock extends Block implements EntityBlock {

    public PTFControllerBlock(Properties props) {
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PTFControllerBlockEntity(pos, state);
    }
}
