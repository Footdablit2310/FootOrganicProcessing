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
        basicItem(ModItems.TAR.get());
        basicItem(ModItems.SOOT.get());
        basicItem(ModItems.AROMATICS.get());
        basicItem(ModItems.LIGHT_HYDROCARBONS.get());
        basicItem(ModItems.SYNGAS.get());
        basicItem(ModItems.BIO_OIL.get());
        basicItem(ModItems.HYDROCARBONS.get());
        basicItem(ModItems.CRACKED_GAS.get());
        basicItem(ModItems.CLEAN_OIL.get());

        // Spirit Glue uses Create's super glue model
        withExistingParent(ModItems.SPIRIT_GLUE.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("create", "item/super_glue"));
    }

}
