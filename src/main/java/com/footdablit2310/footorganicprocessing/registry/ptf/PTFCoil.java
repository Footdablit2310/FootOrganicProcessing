package com.footdablit2310.footorganicprocessing.registry.ptf;

public record PTFCoil(
        String id,
        int maxHeat,        // maximum heat this coil can reach
        int resistance,     // higher = slower heat ramp
        int wearPerTick,    // how fast THIS coil wears out
        int maxDurability   // total durability of THIS coil
) {}
