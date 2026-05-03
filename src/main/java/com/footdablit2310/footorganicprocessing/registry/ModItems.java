package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.items.CoilItem;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;

public final class ModItems {

    private static ItemEntry<Item> item(String id) {
        return FootOrganicProcessing.REGISTRATE.item(id, Item::new)
                .properties(p -> p.stacksTo(64))
                .register();
    }

    // Basic materials
    public static final ItemEntry<Item> BIOMASS = item("biomass");
    public static final ItemEntry<Item> RESIN = item("resin");
    public static final ItemEntry<Item> WAX = item("wax");
    public static final ItemEntry<Item> BOWL_OF_MASH = item("bowl_of_mash");

    // Plastics
    public static final ItemEntry<Item> PLASTIC = item("plastic");

    // Residues / glue
    public static final ItemEntry<Item> STICKY_RESIDUE = item("sticky_residue");
    public static final ItemEntry<Item> SPIRIT_GLUE = item("spirit_glue");

    // Sheets / blocks
    public static final ItemEntry<Item> ULTRA_STURDY_SHEET = item("ultra_sturdy_sheet");

    // Coils
    // Coils
    public static final ItemEntry<CoilItem> COIL_T1_H =
        FootOrganicProcessing.REGISTRATE.item("coil_t1_h",
            p -> new CoilItem(p.stacksTo(64),
                1,          // tier
                750,        // heat output
                1500,       // heat resistance
                0.0000015   // wear rate
            )).register();

    public static final ItemEntry<CoilItem> COIL_T2_SH =
        FootOrganicProcessing.REGISTRATE.item("coil_t2_sh",
            p -> new CoilItem(p.stacksTo(64),
                2,
                1500,
                2250,
                0.0000030
            )).register();

    public static final ItemEntry<CoilItem> COIL_T3_UH =
        FootOrganicProcessing.REGISTRATE.item("coil_t3_uh",
            p -> new CoilItem(p.stacksTo(64),
                3,
                3000,
                3000,
                0.0000060
            )).register();

    public static final ItemEntry<CoilItem> COIL_T3R_UHR =
        FootOrganicProcessing.REGISTRATE.item("coil_t3r_uhr",
            p -> new CoilItem(p.stacksTo(64),
                4,
                3000,
                12000,
                0.0000006
            )).register();


    // Bucket Items
    public static final ItemEntry<BucketItem> SYNGAS_BUCKET =
        FootOrganicProcessing.REGISTRATE.item("syngas_bucket",
                p -> new BucketItem(ModFluids.SYNGAS.get(), p.stacksTo(1)))
                .register();


}
