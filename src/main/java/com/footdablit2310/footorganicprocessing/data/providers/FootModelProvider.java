package com.footdablit2310.footorganicprocessing.data.providers;

import com.footdablit2310.footorganicprocessing.registry.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FootModelProvider extends ItemModelProvider {

    public FootModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, "footorganicprocessing", helper);
    }

    @Override
    protected void registerModels() {

        // Basic solids
        basicItem(ModItems.BIOMASS.get());
        basicItem(ModItems.RESIN.get());
        basicItem(ModItems.STICKY_RESIDUE.get());
        basicItem(ModItems.PLASTIC.get());

        // Spirit Glue uses Create's super glue model
        withExistingParent(ModItems.SPIRIT_GLUE.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("create", "item/super_glue"));
    }

}
