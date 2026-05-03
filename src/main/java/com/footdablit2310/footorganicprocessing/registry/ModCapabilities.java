package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFCasingBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;

public class ModCapabilities {

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {

        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            ModBlockEntities.PTF_CASING.get(),
            (be, side) -> ((PTFCasingBlockEntity) be).getInventory()
        );

    }
}
