package com.footdablit2310.footorganicprocessing.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import com.footdablit2310.footorganicprocessing.registry.ModBlocks;

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
    protected void addTags(HolderLookup.Provider provider) {
        // Casings
        tag(BlockTags.create(ResourceLocation.fromNamespaceAndPath("footorganicprocessing", "casings")))
            .add(ModBlocks.CASING_T1.get())
            .add(ModBlocks.CASING_T2.get())
            .add(ModBlocks.CASING_T3.get());
    }
}
