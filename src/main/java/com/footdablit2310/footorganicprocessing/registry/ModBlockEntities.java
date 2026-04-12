package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFControllerBlockEntity;
import com.footdablit2310.footorganicprocessing.content.blocks.squeezer.SqueezerBlockEntity;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.CentrifugeRotorBlockEntity;

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

    public static final BlockEntityEntry<CentrifugeRotorBlockEntity> CENTRIFUGE_ROTOR =
            REGISTRATE.blockEntity("centrifuge_rotor",
                    (BlockEntityType<CentrifugeRotorBlockEntity> type, BlockPos pos, BlockState state) ->
                            new CentrifugeRotorBlockEntity(type, pos, state))
                    .validBlocks(ModBlocks.CENTRIFUGE_ROTOR)
                    .register();

    public static void register() {}
}
