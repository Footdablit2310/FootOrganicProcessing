package com.footdablit2310.footorganicprocessing.registry.ptf;

import net.minecraft.world.item.ItemStack;

public record PTFRecipe(
        String id,
        ItemStack input,
        ItemStack output,
        int processingTime, // in ticks
        int requiredHeat    // INT heat requirement
) {}
