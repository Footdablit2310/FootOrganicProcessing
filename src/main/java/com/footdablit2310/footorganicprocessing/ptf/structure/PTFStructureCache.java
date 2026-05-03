package com.footdablit2310.footorganicprocessing.ptf.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class PTFStructureCache {

    private final Map<Direction, Map<BlockPos, Block>> rotated = new EnumMap<>(Direction.class);
    private final Map<Direction, Map<BlockPos, Block>> mirroredX = new EnumMap<>(Direction.class);
    private final Map<Direction, Map<BlockPos, Block>> mirroredZ = new EnumMap<>(Direction.class);

    public PTFStructureCache(PTFStructureDefinition def) {
        for (Direction dir : new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST}) {

            Map<BlockPos, Block> baseRot = new HashMap<>();
            Map<BlockPos, Block> baseMirrorX = new HashMap<>();
            Map<BlockPos, Block> baseMirrorZ = new HashMap<>();

            for (var entry : def.getLayout().entrySet()) {
                BlockPos pos = entry.getKey();
                Block block = entry.getValue();

                BlockPos r = PTFStructureTransform.rotate(pos, dir);
                baseRot.put(r, block);

                BlockPos mx = PTFStructureTransform.mirrorX(r);
                baseMirrorX.put(mx, block);

                BlockPos mz = PTFStructureTransform.mirrorZ(r);
                baseMirrorZ.put(mz, block);
            }

            rotated.put(dir, baseRot);
            mirroredX.put(dir, baseMirrorX);
            mirroredZ.put(dir, baseMirrorZ);
        }
    }

    public Map<BlockPos, Block> get(Direction dir) {
        return rotated.get(dir);
    }

    public Map<BlockPos, Block> getMirrorX(Direction dir) {
        return mirroredX.get(dir);
    }

    public Map<BlockPos, Block> getMirrorZ(Direction dir) {
        return mirroredZ.get(dir);
    }
    public Iterable<Direction> getAllDirections() {
    return rotated.keySet();
    }

}
