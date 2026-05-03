package com.footdablit2310.footorganicprocessing.content.blocks;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFControllerBlock;
import com.tterrag.registrate.util.entry.BlockEntry;

public final class PTFBlocks {

    public static final BlockEntry<PTFControllerBlock> PTF_CONTROLLER =
            FootOrganicProcessing.REGISTRATE
                    .block("ptf_controller", PTFControllerBlock::new)
                    .register();

    public static void register() {}
}
