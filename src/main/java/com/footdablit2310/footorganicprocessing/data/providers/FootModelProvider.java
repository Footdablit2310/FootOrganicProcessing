package com.footdablit2310.footorganicprocessing.data.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FootModelProvider extends ItemModelProvider {

    public FootModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, "footorganicprocessing", helper);
    }

    @Override
    protected void registerModels() {
        // stub
    }
}
