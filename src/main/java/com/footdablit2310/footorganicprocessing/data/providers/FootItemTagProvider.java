package com.footdablit2310.footorganicprocessing.data.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import com.footdablit2310.footorganicprocessing.registry.ModItems;

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

        // Organic materials
        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("footorganicprocessing", "organic")))
            .add(ModItems.BIOMASS.get());

        // Adhesives
        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("footorganicprocessing", "adhesives")))
            .add(ModItems.SPIRIT_GLUE.get());

        // Chemicals
        tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("footorganicprocessing", "chemicals")))
            .add(ModItems.RESIN.get())
            .add(ModItems.STICKY_RESIDUE.get())
            .add(ModItems.PLASTIC.get())
            .add(ModItems.TAR.get())
            .add(ModItems.SOOT.get())
            .add(ModItems.AROMATICS.get())
            .add(ModItems.LIGHT_HYDROCARBONS.get())
            .add(ModItems.SYNGAS.get())
            .add(ModItems.BIO_OIL.get())
            .add(ModItems.HYDROCARBONS.get())
            .add(ModItems.CRACKED_GAS.get())
            .add(ModItems.CLEAN_OIL.get());
    }

}
