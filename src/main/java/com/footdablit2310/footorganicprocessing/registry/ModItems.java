package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, FootOrganicProcessing.MOD_ID);

    // Organic
    public static final DeferredHolder<Item, Item> BIOMASS = ITEMS.register("biomass",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> RESIN = ITEMS.register("resin",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> STICKY_RESIDUE = ITEMS.register("sticky_residue",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SPIRIT_GLUE = ITEMS.register("spirit_glue",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLASTIC = ITEMS.register("plastic",
            () -> new Item(new Item.Properties()));

    // PTF / Chemical Outputs
    public static final DeferredHolder<Item, Item> TAR = ITEMS.register("tar",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SOOT = ITEMS.register("soot",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> AROMATICS = ITEMS.register("aromatics",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> LIGHT_HYDROCARBONS = ITEMS.register("light_hydrocarbons",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SYNGAS = ITEMS.register("syngas",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> BIO_OIL = ITEMS.register("bio_oil",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> HYDROCARBONS = ITEMS.register("hydrocarbons",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> CRACKED_GAS = ITEMS.register("cracked_gas",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> CLEAN_OIL = ITEMS.register("clean_oil",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ULTRA_STURDY_SHEET =
            ITEMS.register("ultra_sturdy_sheet",
                    () -> new Item(new Item.Properties()));

    //TODO:# revisit ModItems when adding fluids or block items
}
