package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
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

    // Coils
    public static final ItemEntry<Item> COIL_T1 =
            FootOrganicProcessing.REGISTRATE.item("coil_t1", Item::new)
                    .register();

    public static final ItemEntry<Item> COIL_T2 =
            FootOrganicProcessing.REGISTRATE.item("coil_t2", Item::new)
                    .register();

    public static final ItemEntry<Item> COIL_T3 =
            FootOrganicProcessing.REGISTRATE.item("coil_t3", Item::new)
                    .register();

    public static final ItemEntry<Item> COIL_T3_R =
            FootOrganicProcessing.REGISTRATE.item("coil_t3_r", Item::new)
                    .register();

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
