package com.footdablit2310.footorganicprocessing.ptf.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public final class PTFValidator {

    private PTFValidator() {}

    public static boolean validate(Level level, BlockPos origin, PTFStructureCache cache) {

        // Try all 4 rotations
        for (var dir : cache.getAllDirections()) {

            if (matches(level, origin, cache.get(dir))) return true;
            if (matches(level, origin, cache.getMirrorX(dir))) return true;
            if (matches(level, origin, cache.getMirrorZ(dir))) return true;
        }

        return false;
    }

    private static boolean matches(Level level, BlockPos origin, Map<BlockPos, Block> layout) {
        for (var entry : layout.entrySet()) {
            BlockPos offset = entry.getKey();
            Block expected = entry.getValue();

            BlockPos worldPos = origin.offset(offset);

            if (!level.getBlockState(worldPos).is(expected)) {
                return false;
            }
        }
        return true;
    }
}
