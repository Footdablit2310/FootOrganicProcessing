package com.footdablit2310.footorganicprocessing.registry.ptf;

import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class PTFRegistry {

    private static final Map<ResourceLocation, PTFDefinition> DEFINITIONS = new HashMap<>();
    private static final Map<String, PTFRecipe> RECIPES = new HashMap<>();

    private PTFRegistry() {}

    public static void registerDefinition(ResourceLocation id, PTFDefinition def) {
        DEFINITIONS.put(id, def);
    }

    public static PTFDefinition get(ResourceLocation id) {
        return DEFINITIONS.get(id);
    }

    public static void registerRecipe(PTFRecipe recipe) {
        RECIPES.put(recipe.id(), recipe);
    }

    public static Collection<PTFRecipe> getRecipes() {
        return RECIPES.values();
    }
}
