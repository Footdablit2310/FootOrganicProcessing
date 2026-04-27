package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public class PTFBlocks {

    public static BlockEntry<PTFControllerBlock> PTF_CONTROLLER;

    public static BlockEntry<Block> COIL_T1_H;
    public static BlockEntry<Block> COIL_T2_SH;
    public static BlockEntry<Block> COIL_T3_UH;
    public static BlockEntry<Block> COIL_T3R_UH_R;

    public static BlockEntry<Block> CASING_T1;
    public static BlockEntry<Block> CASING_T2;
    public static BlockEntry<Block> CASING_T3;

    public static void register() {

        PTF_CONTROLLER = FootOrganicProcessing.REGISTRATE
                .block("ptf_controller", PTFControllerBlock::new)
                .properties(p -> p
                        .mapColor(MapColor.METAL)
                        .strength(5f, 12f)
                        .requiresCorrectToolForDrops()
                        .noOcclusion())
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get()))
                .item()
                .build()
                .register();

        COIL_T1_H = coil("coil_t1_h");
        COIL_T2_SH = coil("coil_t2_sh");
        COIL_T3_UH = coil("coil_t3_uh");
        COIL_T3R_UH_R = coil("coil_t3r_uh_r");

        CASING_T1 = casing("casing_t1");
        CASING_T2 = casing("casing_t2");
        CASING_T3 = casing("casing_t3");
    }

    private static BlockEntry<Block> coil(String name) {
        return FootOrganicProcessing.REGISTRATE
                .block(name, Block::new)
                .properties(p -> p
                        .mapColor(MapColor.METAL)
                        .strength(3f, 8f)
                        .requiresCorrectToolForDrops())
                .simpleItem()
                .register();
    }

    private static BlockEntry<Block> casing(String name) {
        return FootOrganicProcessing.REGISTRATE
                .block(name, Block::new)
                .properties(p -> p
                        .mapColor(MapColor.METAL)
                        .strength(8f, 24f)
                        .requiresCorrectToolForDrops())
                .simpleItem()
                .register();
    }
}
