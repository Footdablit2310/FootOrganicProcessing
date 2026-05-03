package com.footdablit2310.footorganicprocessing.ptf.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public final class PTFStructureTransform {

    private PTFStructureTransform() {}

    public static BlockPos rotate(BlockPos pos, Direction rotation) {
        return switch (rotation) {
            case NORTH -> pos;
            case EAST  -> new BlockPos(-pos.getZ(), pos.getY(), pos.getX());
            case SOUTH -> new BlockPos(-pos.getX(), pos.getY(), -pos.getZ());
            case WEST  -> new BlockPos(pos.getZ(), pos.getY(), -pos.getX());
            default    -> pos;
        };
    }

    public static BlockPos mirrorX(BlockPos pos) {
        return new BlockPos(-pos.getX(), pos.getY(), pos.getZ());
    }

    public static BlockPos mirrorZ(BlockPos pos) {
        return new BlockPos(pos.getX(), pos.getY(), -pos.getZ());
    }
}
