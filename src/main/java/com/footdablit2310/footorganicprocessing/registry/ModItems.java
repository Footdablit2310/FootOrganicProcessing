package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.items.ptf.CoilItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final ItemEntry<Item> STICKY_RESIDUE =
            FootOrganicProcessing.REGISTRATE.item("sticky_residue", Item::new)
                    .properties(p -> p.stacksTo(64))
                    .register();

    public static final ItemEntry<Item> SPIRIT_GLUE =
            FootOrganicProcessing.REGISTRATE.item("spirit_glue", Item::new)
                    .register();

    public static final ItemEntry<Item> TAR =
            FootOrganicProcessing.REGISTRATE.item("tar", Item::new)
                    .register();

    public static final ItemEntry<Item> AROMATICS =
            FootOrganicProcessing.REGISTRATE.item("aromatics", Item::new)
                    .register();

    public static final ItemEntry<Item> LIGHT_HYDROCARBONS =
            FootOrganicProcessing.REGISTRATE.item("light_hydrocarbons", Item::new)
                    .register();

    public static final ItemEntry<Item> CRACKED_GAS =
            FootOrganicProcessing.REGISTRATE.item("cracked_gas", Item::new)
                    .register();

    public static final ItemEntry<Item> CLEAN_OIL =
            FootOrganicProcessing.REGISTRATE.item("clean_oil", Item::new)
                    .register();

    public static final ItemEntry<Item> METHANOL =
            FootOrganicProcessing.REGISTRATE.item("methanol", Item::new)
                    .register();

    // Industrial
    public static final ItemEntry<Item> ULTRA_STURDY_SHEET =
            FootOrganicProcessing.REGISTRATE.item("ultra_sturdy_sheet", Item::new)
                    .register();

    // -------------------------------------------------------------------------
    // COILS (F3)
    // -------------------------------------------------------------------------

    public static final ItemEntry<CoilItem> COIL_T1_H = FootOrganicProcessing.REGISTRATE.item("coil_t1_h", props ->
            new CoilItem(props,
                    1000,      // durability
                    750,       // heat output
                    1500,      // heat resistance
                    0.0000015  // wear chance
            )
    ).register();

    public static final ItemEntry<CoilItem> COIL_T2_SH = FootOrganicProcessing.REGISTRATE.item("coil_t2_sh", props ->
            new CoilItem(props,
                    1500,
                    1500,
                    2250,
                    0.000003
            )
    ).register();

    public static final ItemEntry<CoilItem> COIL_T3_UH = FootOrganicProcessing.REGISTRATE.item("coil_t3_uh", props ->
            new CoilItem(props,
                    2000,
                    3000,
                    3000,
                    0.000006
            )
    ).register();

    public static final ItemEntry<CoilItem> COIL_T3R_UH_R = FootOrganicProcessing.REGISTRATE.item("coil_t3r_uh_r", props ->
            new CoilItem(props,
                    4000,
                    3000,
                    12000,
                    0.0000006
            )
    ).register();

    // Casings (item form only)
    public static final ItemEntry<Item> CASING_T1 =
            FootOrganicProcessing.REGISTRATE.item("casing_t1", Item::new)
                    .register();

    public static final ItemEntry<Item> CASING_T2 =
            FootOrganicProcessing.REGISTRATE.item("casing_t2", Item::new)
                    .register();

    public static final ItemEntry<Item> CASING_T3 =
            FootOrganicProcessing.REGISTRATE.item("casing_t3", Item::new)
                    .register();

    public static void register() {}
}
