package com.footdablit2310.footorganicprocessing.ptf;

import com.footdablit2310.footorganicprocessing.api.ptf.PTFTier;
import java.util.HashMap;
import java.util.Map;

public class PTFTierManager {

    private static final Map<Integer, PTFTier> TIERS = new HashMap<>();
    private static int maxTier = 0;

    public static void loadDefaults() {
        // Load from XLSX or JSON
        // Example:
        registerTier(new PTFTier(0, 1, 0));
        registerTier(new PTFTier(1, 2, 1));
        registerTier(new PTFTier(2, 3, 1));
    }

    public static void registerTier(PTFTier tier) {
        TIERS.put(tier.level(), tier);
        maxTier = Math.max(maxTier, tier.level());
    }

    public static PTFTier get(int level) {
        return TIERS.get(level);
    }

    public static int maxTier() {
        return maxTier;
    }
}
