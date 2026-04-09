package com.footdablit2310.footorganicprocessing.datagen.tags;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class FOPBlockTags extends TagsProvider<Block> {

    public FOPBlockTags(PackOutput output,
                        CompletableFuture<HolderLookup.Provider> lookup,
                        ExistingFileHelper helper) {
        super(output, Registries.BLOCK, lookup, FootOrganicProcessing.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        // TODO: PTF casings
        // TODO: PTF coils
        // TODO: Machine frames
        // TODO: Organic processing blocks
    }
}
