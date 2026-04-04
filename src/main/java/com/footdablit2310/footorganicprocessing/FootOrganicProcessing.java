package com.footdablit2310.footorganicprocessing;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.footdablit2310.footorganicprocessing.registry.ModBlocks;
import com.footdablit2310.footorganicprocessing.registry.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FootOrganicProcessing.MOD_ID)
public class FootOrganicProcessing {

    public static final String MOD_ID = "footorganicprocessing";

    public FootOrganicProcessing(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        //TODO:# register menus, recipe types later
    }
}
