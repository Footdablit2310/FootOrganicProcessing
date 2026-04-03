package com.footdablit2310.footorganicprocessing.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class FootItemTagProvider extends ItemTagsProvider {

    public FootItemTagProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookup,
            CompletableFuture<TagLookup<Block>> blockTags,
            ExistingFileHelper helper
    ) {
        super(output, lookup, blockTags, "footorganicprocessing", helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // stub
    }
}
