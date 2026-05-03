package com.footdablit2310.footorganicprocessing.ptf.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class PTFStructureDefinition {

    private final Map<BlockPos, Block> layout = new HashMap<>();

    public void add(BlockPos pos, Block block) {
        layout.put(pos, block);
    }

    public Map<BlockPos, Block> getLayout() {
        return layout;
    }
}
