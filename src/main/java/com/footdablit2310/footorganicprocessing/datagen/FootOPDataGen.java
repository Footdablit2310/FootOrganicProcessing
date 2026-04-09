package com.footdablit2310.footorganicprocessing.datagen;

import com.footdablit2310.footorganicprocessing.datagen.recipes.FOPRecipeProvider;
import com.footdablit2310.footorganicprocessing.datagen.tags.FOPItemTags;
import com.footdablit2310.footorganicprocessing.datagen.tags.FOPBlockTags;
import com.footdablit2310.footorganicprocessing.datagen.loot.FOPLootTables;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FootOPDataGen {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            gen.addProvider(true, new FOPRecipeProvider(output, event.getLookupProvider()));
            gen.addProvider(true, new FOPItemTags(output, event.getLookupProvider(), helper));
            gen.addProvider(true, new FOPBlockTags(output, event.getLookupProvider(), helper));
            gen.addProvider(true, new FOPLootTables(output, event.getLookupProvider()));

            // TODO: Add Create-style recipe datagen provider
            // TODO: Add PTF recipe datagen provider
            // TODO: Add polymerizer / centrifuge / press providers
        }
    }
}
