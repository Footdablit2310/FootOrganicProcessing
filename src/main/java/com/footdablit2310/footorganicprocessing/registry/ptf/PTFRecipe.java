package com.footdablit2310.footorganicprocessing.registry.ptf;

import net.minecraft.world.item.ItemStack;

public record PTFRecipe(
        ItemStack input,
        ItemStack output,
        int heatRequired,
        int time
) {}
