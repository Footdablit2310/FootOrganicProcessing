package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public final class ModBlocks {
    private static Registrate REGISTRATE = FootOrganicProcessing.REGISTRATE;

    public static final BlockEntry<Block> ULTRA_STURDY_BLOCK =
            REGISTRATE.block("ultra_sturdy_block", Block::new)
                    .properties(p -> p.strength(50f, 1200f).mapColor(MapColor.METAL))
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> PTF_CONTROLLER =
            REGISTRATE.block("ptf_controller", Block::new)
                    .properties(p -> p.strength(5f).mapColor(MapColor.COLOR_RED))
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> PTF_CASING =
            REGISTRATE.block("ptf_casing", Block::new)
                    .properties(p -> p.strength(20f).mapColor(MapColor.COLOR_GRAY))
                    .simpleItem()
                    .register();
    
    public static final BlockEntry<Block> SQUEEZER =
            REGISTRATE.block("squeezer", Block::new)
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> CASING_T1 =
            REGISTRATE.block("casing_t1", Block::new)
                    .simpleItem()
                    .register();
    public static final BlockEntry<Block> CASING_T2 =
            REGISTRATE.block("casing_t2", Block::new)
                    .simpleItem()
                    .register();
    public static final BlockEntry<Block> CASING_T3 =
            REGISTRATE.block("casing_t3", Block::new)
                    .simpleItem()
                    .register();
}
