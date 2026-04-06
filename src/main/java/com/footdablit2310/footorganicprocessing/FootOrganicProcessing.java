package com.footdablit2310.footorganicprocessing;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.footdablit2310.footorganicprocessing.registry.ModBlocks;
//import com.footdablit2310.footorganicprocessing.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import com.tterrag.registrate.Registrate;

@Mod(FootOrganicProcessing.MOD_ID)
public class FootOrganicProcessing {
    public static final String MOD_ID = "footorganicprocessing";

    public static final Registrate REGISTRATE =
            Registrate.create(MOD_ID);

    public FootOrganicProcessing(IEventBus bus) {
        REGISTRATE.registerEventListeners(bus);
        ModBlocks.BLOCKS.register(bus);
        ModBlockEntities.BLOCK_ENTITIES.register(bus);
        //TODO: Adding items back in causes a crash, need to figure out why...
    }
}
