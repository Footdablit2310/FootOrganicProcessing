package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PTFCasingBlock extends Block implements EntityBlock {

    private final int casingTier;

    public PTFCasingBlock(Properties props, int tier) {
        super(props);
        this.casingTier = tier;
    }

    public int getCasingTier() {
        return casingTier;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PTFCasingBlockEntity(ModBlockEntities.PTF_CASING.get(), pos, state);
    }
}
