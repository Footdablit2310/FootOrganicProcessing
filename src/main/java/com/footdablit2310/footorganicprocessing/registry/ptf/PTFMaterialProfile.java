package com.footdablit2310.footorganicprocessing.registry.ptf;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.Set;

public record PTFMaterialProfile(
        Set<Item> items,
        Set<Block> blocks,
        Set<Fluid> fluids
) {
    public static PTFMaterialProfile empty() {
        return new PTFMaterialProfile(Set.of(), Set.of(), Set.of());
    }
}
