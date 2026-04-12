package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.items.ptf.CoilItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import com.tterrag.registrate.Registrate;

public class ModItems {
    public static final Registrate REGISTRATE = 
        FootOrganicProcessing.REGISTRATE;

    public static final ItemEntry<Item> STICKY_RESIDUE =
            REGISTRATE.item("sticky_residue", Item::new)
                    .properties(p -> p.stacksTo(64))
                    .register();
    public static final ItemEntry<Item> BIOMASS =
            REGISTRATE.item("biomass", Item::new)
                    .properties(p -> p.stacksTo(64))
                    .register();
    public static final ItemEntry<Item> PLASTIC =
            REGISTRATE.item("plastic", Item::new)
                    .properties(p -> p.stacksTo(64))
                    .register();
    public static final ItemEntry<Item> RESIN =
            REGISTRATE.item("resin", Item::new)
                    .properties(p -> p.stacksTo(64))
                    .register();
    public static final ItemEntry<Item> SPIRIT_GLUE =
            REGISTRATE.item("spirit_glue", Item::new)
                    .register();

    public static final ItemEntry<Item> TAR =
            REGISTRATE.item("tar", Item::new)
                    .register();

    public static final ItemEntry<Item> AROMATICS =
            REGISTRATE.item("aromatics", Item::new)
                    .register();

    public static final ItemEntry<Item> LIGHT_HYDROCARBONS =
            REGISTRATE.item("light_hydrocarbons", Item::new)
                    .register();

    public static final ItemEntry<Item> CRACKED_GAS =
            REGISTRATE.item("cracked_gas", Item::new)
                    .register();

    public static final ItemEntry<Item> BIO_OIL =
            REGISTRATE.item("bio_oil", Item::new)
                    .register();

    public static final ItemEntry<Item> METHANOL =
            REGISTRATE.item("methanol", Item::new)
                    .register();

    // Industrial
    public static final ItemEntry<Item> ULTRA_STURDY_SHEET =
            REGISTRATE.item("ultra_sturdy_sheet", Item::new)
                    .register();

    // -------------------------------------------------------------------------
    // COILS (F3)
    // -------------------------------------------------------------------------

    public static final ItemEntry<CoilItem> COIL_T1_H = REGISTRATE.item("coil_t1_h", props ->
            new CoilItem(props,
                    1000,      // durability
                    750,       // heat output
                    1500,      // heat resistance
                    0.0000015  // wear chance
            )
    ).register();

    public static final ItemEntry<CoilItem> COIL_T2_SH = REGISTRATE.item("coil_t2_sh", props ->
            new CoilItem(props,
                    1500,
                    1500,
                    2250,
                    0.000003
            )
    ).register();

    public static final ItemEntry<CoilItem> COIL_T3_UH = REGISTRATE.item("coil_t3_uh", props ->
            new CoilItem(props,
                    2000,
                    3000,
                    3000,
                    0.000006
            )
    ).register();

    public static final ItemEntry<CoilItem> COIL_T3R_UH_R = REGISTRATE.item("coil_t3r_uh_r", props ->
            new CoilItem(props,
                    4000,
                    3000,
                    12000,
                    0.0000006
            )
    ).register();

    // Casings (item form only)
    public static final ItemEntry<Item> CASING_T1 =
            REGISTRATE.item("casing_t1", Item::new)
                    .register();

    public static final ItemEntry<Item> CASING_T2 =
            REGISTRATE.item("casing_t2", Item::new)
                    .register();

    public static final ItemEntry<Item> CASING_T3 =
            REGISTRATE.item("casing_t3", Item::new)
                    .register();

    public static void register() {}
}
