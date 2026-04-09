package com.footdablit2310.footorganicprocessing.datagen.loot;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FOPLootTables extends LootTableProvider {

    public FOPLootTables(PackOutput output,
                         CompletableFuture<HolderLookup.Provider> lookup) {
        super(output,
              Set.of(),
              List.of(new SubProviderEntry(FOPBlockLoot::new, LootContextParamSets.BLOCK)),
              lookup);
    }

    private static class FOPBlockLoot extends BlockLootSubProvider {

        protected FOPBlockLoot(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        protected void generate() {
            // TODO: add concrete loot definitions, e.g.:
            // dropSelf(ModBlocks.PTF_CONTROLLER.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            // TODO: if Registrate access pattern changes, update this mapping.
            return FootOrganicProcessing.REGISTRATE
                    .getAll(Registries.BLOCK)
                    .stream()
                    .map(entry -> entry.get())
                    .toList();
        }
    }
}
