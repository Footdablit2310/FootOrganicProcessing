package com.footdablit2310.footorganicprocessing.registry.ptf;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class PTFRegistry {

    private static final Map<ResourceLocation, PTFDefinition> REGISTRY = new HashMap<>();

    public static void register(PTFDefinition def) {
        REGISTRY.put(def.id(), def);
    }

    public static PTFDefinition get(ResourceLocation id) {
        return REGISTRY.get(id);
    }

    public static Set<ResourceLocation> allIds() {
        return REGISTRY.keySet();
    }
}
