package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.squeezer.SqueezerBlockEntity;
import com.footdablit2310.footorganicprocessing.content.ptf.PtfBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FootOrganicProcessing.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SqueezerBlockEntity>> SQUEEZER_BE =
            BLOCK_ENTITIES.register("squeezer",
                    () -> BlockEntityType.Builder.of(
                                    SqueezerBlockEntity::new,
                                    ModBlocks.SQUEEZER.get()
                            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PtfBlockEntity>> PTF_BE =
            BLOCK_ENTITIES.register("ptf_controller",
                    () -> BlockEntityType.Builder.of(
                                    PtfBlockEntity::new,
                                    ModBlocks.PTF_CONTROLLER.get()
                            ).build(null));
    
}
