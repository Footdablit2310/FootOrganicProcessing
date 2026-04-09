package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.content.blocks.ptf.PTFControllerBlockEntity;

import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class ModCapabilities {

    public static void register(RegisterCapabilitiesEvent event) {

        // Item handler capability
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                ModBlockEntities.PTF_CONTROLLER.get(),
                (PTFControllerBlockEntity be, Direction side) -> be.getItemHandler()
        );

        // Energy capability
        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                ModBlockEntities.PTF_CONTROLLER.get(),
                (PTFControllerBlockEntity be, Direction side) -> be.getEnergyStorage()
        );
    }
}
