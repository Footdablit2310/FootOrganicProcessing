package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFControllerBlockEntity;
import com.footdablit2310.footorganicprocessing.content.blocks.squeezer.SqueezerBlockEntity;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class ModBlockEntities {

    public static final Registrate REGISTRATE = FootOrganicProcessing.REGISTRATE;

    public static final BlockEntityEntry<PTFControllerBlockEntity> PTF_CONTROLLER =
            REGISTRATE.blockEntity("ptf_controller", PTFControllerBlockEntity::new)
                    .validBlocks(ModBlocks.PTF_CONTROLLER)
                    .register();

    public static final BlockEntityEntry<SqueezerBlockEntity> SQUEEZER =
            REGISTRATE.blockEntity("squeezer", SqueezerBlockEntity::new)
                    .validBlocks(ModBlocks.SQUEEZER)
                    .register();


    public static void register() {}
}
