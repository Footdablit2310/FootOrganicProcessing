package com.footdablit2310.footorganicprocessing.internal_integration.footlib;

import com.footdablit2310.footlib.api.shared.foot_organic_processing.ptf.PTFTierBuilder;
import com.footdablit2310.footlib.api.shared.foot_organic_processing.ptf.PTFTierRegistry;
import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import net.minecraft.resources.ResourceLocation;

public final class FootOPPTFTiers {

    public static void registerTiers() {
        String mod = FootOrganicProcessing.MOD_ID;

        PTFTierRegistry.register(
                ResourceLocation.fromNamespaceAndPath(mod, "tier_1"),
                PTFTierBuilder.create()
                        .gridSize(1)
                        .heatedZones(9)
                        .superheatedZones(0)
                        .ultraheatedZones(0)
                        .fePerTick(128)
                        .build()
        );

        PTFTierRegistry.register(
                ResourceLocation.fromNamespaceAndPath(mod, "tier_2"),
                PTFTierBuilder.create()
                        .gridSize(3)
                        .heatedZones(9)
                        .superheatedZones(0)
                        .ultraheatedZones(0)
                        .fePerTick(2048)
                        .build()
        );

        //TODO: IMPL: ... tiers 3–6 ...
    }
}
