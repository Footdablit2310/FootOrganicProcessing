package com.footdablit2310.footorganicprocessing;

import com.footdablit2310.footorganicprocessing.registry.ModBlocks;
import com.footdablit2310.footorganicprocessing.datagen.FootOPDataGen;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.footdablit2310.footorganicprocessing.registry.ModItems;
import com.tterrag.registrate.Registrate;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FootOrganicProcessing.MOD_ID)
public class FootOrganicProcessing {

    public static final String MOD_ID = "footorganicprocessing";

    // The ONE TRUE Registrate instance
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public FootOrganicProcessing(IEventBus modEventBus) {

        // Hook Registrate into the mod event bus
        REGISTRATE.registerEventListeners(modEventBus);

        // Register your content
        ModBlocks.register();
        ModItems.register();
        ModBlockEntities.register();
        modEventBus.addListener(FootOPDataGen::gatherData);
        //TODO: Register other content (e.g. containers, recipes, etc.) as needed
    }
}
