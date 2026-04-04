package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, FootOrganicProcessing.MOD_ID);

    public static final DeferredHolder<Block, Block> SQUEEZER =
            BLOCKS.register("squeezer",
                    () -> new com.footdablit2310.footorganicprocessing.content.squeezer.SqueezerBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.METAL)
                                    .strength(3.5F)
                                    .requiresCorrectToolForDrops()
                    ));

    public static final DeferredHolder<Block, Block> PTF_CONTROLLER =
            BLOCKS.register("ptf_controller",
                    () -> new com.footdablit2310.footorganicprocessing.content.ptf.PtfControllerBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.METAL)
                                    .strength(4.0F)
                                    .requiresCorrectToolForDrops()
                    ));

    //TODO:# add casings, coils, vents for PTF multiblock
}
