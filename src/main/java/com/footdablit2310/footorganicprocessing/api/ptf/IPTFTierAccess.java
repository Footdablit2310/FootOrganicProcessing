package com.footdablit2310.footorganicprocessing.api.ptf;

import net.minecraft.resources.ResourceLocation;

public interface IPTFTierAccess {

    PTFTier getTier(int level);

    PTFTier getTierForRecipe(ResourceLocation recipeId);

    boolean isTierValid(int level);

    int maxTier();

    void registerCustomTier(PTFTier tier);

    void overrideTier(int level, int heatRadius, int superHeatRadius);
}
