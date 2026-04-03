package com.footdablit2310.footorganicprocessing.integration.footlib;

import com.footdablit2310.footlib.api.shared.foot_organic_processing.IPTFTierAccess;
import com.footdablit2310.footlib.api.shared.foot_organic_processing.PTFTier;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class PTFTierAccessImpl implements IPTFTierAccess {

    private final Map<Integer, PTFTier> tiers = new HashMap<>();
    private final Map<ResourceLocation, Integer> recipeTiers = new HashMap<>();
    private int maxTier = 0;

    @Override
    public PTFTier getTier(int level) {
        return tiers.get(level);
    }

    @Override
    public PTFTier getTierForRecipe(ResourceLocation recipeId) {
        int lvl = recipeTiers.getOrDefault(recipeId, 0);
        return tiers.getOrDefault(lvl, new PTFTier(0, 0, 0));
    }

    @Override
    public boolean isTierValid(int level) {
        return tiers.containsKey(level);
    }

    @Override
    public int maxTier() {
        return maxTier;
    }

    @Override
    public void registerCustomTier(PTFTier tier) {
        tiers.put(tier.level(), tier);
        maxTier = Math.max(maxTier, tier.level());
    }

    @Override
    public void overrideTier(int level, int heatRadius, int superHeatRadius) {
        tiers.put(level, new PTFTier(level, heatRadius, superHeatRadius));
        maxTier = Math.max(maxTier, level);
    }

    @Override
    public void setRecipeTier(ResourceLocation recipeId, int level) {
        recipeTiers.put(recipeId, level);
    }
}
