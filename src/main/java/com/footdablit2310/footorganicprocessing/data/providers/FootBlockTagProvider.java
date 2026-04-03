package com.footdablit2310.footorganicprocessing.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class FootBlockTagProvider extends BlockTagsProvider {

    public FootBlockTagProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookup,
            ExistingFileHelper helper
    ) {
        super(output, lookup, "footorganicprocessing", helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {}
}

