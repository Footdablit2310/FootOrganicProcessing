package com.footdablit2310.footorganicprocessing.ptf.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;

public final class PTFStructureDefinitions {

    public static final PTFStructureDefinition PTF = new PTFStructureDefinition();

    static {
        // TODO: Replace with your real multiblock layout.
        // This is only here so the validator compiles and runs.

        PTF.add(BlockPos.ZERO, Blocks.IRON_BLOCK);
    }

    private PTFStructureDefinitions() {}
}
