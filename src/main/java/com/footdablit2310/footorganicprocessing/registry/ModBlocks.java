package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFControllerBlock;
import com.footdablit2310.footorganicprocessing.content.blocks.squeezer.SqueezerBlock;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import com.footdablit2310.footorganicprocessing.content.blocks.centrifuge.*;

public class ModBlocks {

    public static final Registrate REGISTRATE = FootOrganicProcessing.REGISTRATE;

    // -------------------------
    //  PTF CONTROLLER
    // -------------------------
    public static final BlockEntry<PTFControllerBlock> PTF_CONTROLLER =
            REGISTRATE.block("ptf_controller", PTFControllerBlock::new)
                    .properties(p -> p
                            .mapColor(MapColor.METAL)
                            .strength(4.0F, 6.0F)
                            .requiresCorrectToolForDrops())
                    .simpleItem()
                    .register();

    // -------------------------
    //  SQUEEZER
    // -------------------------
    public static final BlockEntry<SqueezerBlock> SQUEEZER =
            REGISTRATE.block("squeezer", SqueezerBlock::new)
                    .properties(p -> p
                            .mapColor(MapColor.STONE)
                            .strength(3.0F))
                    .simpleItem()
                    .register();

    // -------------------------
    //  ULTRA STURDY BLOCK
    // -------------------------
    public static final BlockEntry<Block> ULTRA_STURDY_BLOCK =
            REGISTRATE.block("ultra_sturdy_block", Block::new)
                    .properties(p -> p
                            .mapColor(MapColor.COLOR_BLACK)
                            .strength(10.0F, 1200.0F)
                            .requiresCorrectToolForDrops())
                    .simpleItem()
                    .register();

    // -------------------------
    //  CASINGS (T1, T2, T3)
    // -------------------------
    public static final BlockEntry<Block> CASING_T1 =
            REGISTRATE.block("casing_t1", Block::new)
                    .properties(p -> p
                            .mapColor(MapColor.COLOR_LIGHT_GRAY)
                            .strength(3.0F))
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> CASING_T2 =
            REGISTRATE.block("casing_t2", Block::new)
                    .properties(p -> p
                            .mapColor(MapColor.COLOR_GRAY)
                            .strength(4.0F))
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> CASING_T3 =
            REGISTRATE.block("casing_t3", Block::new)
                    .properties(p -> p
                            .mapColor(MapColor.COLOR_BLACK)
                            .strength(6.0F))
                    .simpleItem()
                    .register();

    public static final BlockEntry<CentrifugeBlock> CENTRIFUGE =
            REGISTRATE.block("centrifuge", CentrifugeBlock::new)
                    .simpleItem()
                    .register();

    public static void register() {}
}
