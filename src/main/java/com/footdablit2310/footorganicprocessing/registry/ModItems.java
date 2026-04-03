package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModItems {
    private static final CreateRegistrate REG = FootOrganicProcessing.REGISTRATE;

    public static final ItemEntry<Item> PLASTIC = REG
            .item("plastic", Item::new)
            .register();

    public static final ItemEntry<Item> STICKY_RESIDUE = REG
            .item("sticky_residue", Item::new)
            .register();

    public static final ItemEntry<Item> WEAK_GLUE = REG
            .item("weak_glue", Item::new)
            .register();

    public static final ItemEntry<Item> SAWDUST = REG
            .item("sawdust", Item::new)
            .register();

    public static void register() {}
}
