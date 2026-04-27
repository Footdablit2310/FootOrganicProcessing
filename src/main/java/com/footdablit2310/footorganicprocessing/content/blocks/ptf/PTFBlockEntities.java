package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class PTFBlockEntities {

    public static BlockEntityEntry<PTFControllerBlockEntity> PTF_CONTROLLER;

    public static void register() {

        PTF_CONTROLLER = FootOrganicProcessing.REGISTRATE
                .blockEntity("ptf_controller", PTFControllerBlockEntity::new)
                .validBlocks(PTFBlocks.PTF_CONTROLLER)
                .register();
    }
}
