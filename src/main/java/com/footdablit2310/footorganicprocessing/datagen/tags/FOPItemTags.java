package com.footdablit2310.footorganicprocessing.datagen.tags;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.registry.ModTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class FOPItemTags extends TagsProvider<Item> {

    public FOPItemTags(PackOutput output,
                       CompletableFuture<HolderLookup.Provider> lookup,
                       ExistingFileHelper helper) {
        super(output, Registries.ITEM, lookup, FootOrganicProcessing.MOD_ID, helper);
    }

    private static ResourceLocation mc(String id) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", id);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        // Tier 1 biomass sources
        tag(ModTags.Items.BIOMASS_T1)
                .addOptional(mc("oak_leaves"))
                .addOptional(mc("birch_leaves"))
                .addOptional(mc("spruce_leaves"))
                .addOptional(mc("acacia_leaves"))
                .addOptional(mc("dark_oak_leaves"))
                .addOptional(mc("azalea_leaves"))
                .addOptional(mc("flowering_azalea_leaves"))
                .addOptional(mc("dry_leaves"))
                .addOptional(mc("cocoa_beans"))
                .addOptional(mc("wheat_seeds"));

        // Tier 2 biomass sources
        tag(ModTags.Items.BIOMASS_T2)
                .addOptional(mc("potato"))
                .addOptional(mc("sugar_cane"))
                .addOptional(mc("wheat"));

        // Tier 3 biomass sources
        tag(ModTags.Items.BIOMASS_T3)
                .addOptional(mc("oak_log"))
                .addOptional(mc("spruce_log"));

        // Tier 4 biomass sources
        tag(ModTags.Items.BIOMASS_T4)
                .addOptional(mc("honeycomb"))
                .addOptional(mc("honeycomb_block"));
    }
}
