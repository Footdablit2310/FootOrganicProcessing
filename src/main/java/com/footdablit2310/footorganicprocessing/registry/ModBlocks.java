package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    private static final CreateRegistrate REG = FootOrganicProcessing.REGISTRATE;

    public static final BlockEntry<Block> PTF_CASING =
            REG.block("ptf_casing", Block::new)
                    .properties(p -> BlockBehaviour.Properties.of().strength(5f))
                    .item()
                        .build()
                    .register();

    public static void register() {}
}
