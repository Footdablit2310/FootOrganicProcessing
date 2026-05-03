package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFControllerBlockEntity;
import com.footdablit2310.footorganicprocessing.content.blocks.squeezer.SqueezerBlockEntity;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFCasingBlockEntity;
import com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.CentrifugeBlockEntity;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.minecraft.world.level.block.entity.BlockEntity;

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

    public static final BlockEntityEntry<CentrifugeBlockEntity> CENTRIFUGE =
            REGISTRATE.blockEntity("centrifuge", CentrifugeBlockEntity::new)
                    .validBlocks(ModBlocks.CENTRIFUGE)
                    .register();


    public static final BlockEntityEntry<BlockEntity> PTF_CASING =
        REGISTRATE.blockEntity("ptf_casing", PTFCasingBlockEntity::new)
                .validBlocks(
                        ModBlocks.CASING_T1,
                        ModBlocks.CASING_T2,
                        ModBlocks.CASING_T3
                )
                .register();



    public static void register() {}
}
