package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PTFStructureHelper {

    public static boolean validateStructure(Level level, BlockPos controllerPos) {
        // TODO: real multiblock validation
        // For now: always valid if the block exists
        BlockState state = level.getBlockState(controllerPos);
        return state.getBlock() instanceof PTFBlock;
    }

    public static PTFTier detectTier(Level level, BlockPos controllerPos) {
        // TODO: real detection logic
        // For now: always Tier 1
        return PTFTier.TIER_1;
    }
}
