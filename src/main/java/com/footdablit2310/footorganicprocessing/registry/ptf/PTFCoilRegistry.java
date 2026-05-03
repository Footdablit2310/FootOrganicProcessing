package com.footdablit2310.footorganicprocessing.registry.ptf;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class PTFCoilRegistry {

    private static final Map<String, PTFCoil> REGISTRY = new HashMap<>();

    private PTFCoilRegistry() {}

    public static PTFCoil register(String id, int maxHeat, int resistance, int wearPerTick, int maxDurability) {
        PTFCoil coil = new PTFCoil(id, maxHeat, resistance, wearPerTick, maxDurability);
        REGISTRY.put(id, coil);
        return coil;
    }

    public static PTFCoil get(String id) {
        return REGISTRY.get(id);
    }

    public static Collection<PTFCoil> all() {
        return REGISTRY.values();
    }
}
