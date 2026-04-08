package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class PTFControllerBlock extends Block implements EntityBlock {

    public PTFControllerBlock(Properties props) {
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PTFControllerBlockEntity(pos, state);
    }
    @Override
    public BlockEntityTicker<PTFControllerBlockEntity> getTicker(Level level, BlockState state, BlockEntityType<PTFControllerBlockEntity> type) {
        return level.isClientSide ? null : (lvl, pos, st, be) -> PTFControllerBlockEntity.tick(lvl, pos, st, be);
    }

}
