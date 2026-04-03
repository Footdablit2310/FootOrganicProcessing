package com.footdablit2310.footorganicprocessing.data;

import com.footdablit2310.footorganicprocessing.data.providers.*;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class FootDataGenerators {

    public static void gatherData(GatherDataEvent event) {

        var generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        // -------------------------
        // RECIPES (works now)
        // -------------------------
        generator.addProvider(
                event.includeServer(),
                new FootRecipeProvider(output, lookup)
        );

        // -------------------------
        // ITEM TAGS (stub)
        // -------------------------
        generator.addProvider(
                event.includeServer(),
                new FootItemTagProvider(output, lookup, lookup.thenApply(p -> null), helper)
        );

        // -------------------------
        // BLOCK TAGS (stub)
        // -------------------------
        generator.addProvider(
                event.includeServer(),
                new FootBlockTagProvider(output, lookup, helper)
        );

        // -------------------------
        // MODELS (stub)
        // -------------------------
        generator.addProvider(
                event.includeClient(),
                new FootModelProvider(output, helper)
        );

        // -------------------------
        // LOOT TABLES — REMOVED
        // NeoForge 1.21.1 does NOT support subclassing LootTableProvider
        // -------------------------
    }
}
