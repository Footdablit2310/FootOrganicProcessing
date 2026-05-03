package com.footdablit2310.footorganicprocessing.content.blocks;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFControllerBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public final class PTFBlockEntities {

    public static final BlockEntityEntry<PTFControllerBlockEntity> PTF_CONTROLLER =
            FootOrganicProcessing.REGISTRATE
                    .blockEntity("ptf_controller", PTFControllerBlockEntity::new)
                    .validBlocks(PTFBlocks.PTF_CONTROLLER)
                    .register();

    public static void register() {}
}
