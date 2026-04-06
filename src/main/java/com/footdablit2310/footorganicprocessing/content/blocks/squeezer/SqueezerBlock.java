package com.footdablit2310.footorganicprocessing.content.blocks.squeezer;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class SqueezerBlock extends Block implements EntityBlock {

    public SqueezerBlock(Properties props) {
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SqueezerBlockEntity(pos, state);
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> type
    ) {
        if (level.isClientSide) return null;

        return type == ModBlockEntities.SQUEEZER_BE.get()
                ? (lvl, pos, st, be) -> SqueezerBlockEntity.tick(lvl, pos, st, (SqueezerBlockEntity) be)
                : null;
    }

}
