package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footlib.api.common.heat.HeatTier;

public record PTFTier(
        int tier,
        int gridSize,
        int heatedZones,
        int superheatedZones,
        int ultraheatedZones,
        int feCost,
        HeatTier outputTier
) {

    public static final PTFTier TIER_1 = new PTFTier(1, 1, 9, 0, 0, 128, HeatTier.HEATED);
    public static final PTFTier TIER_2 = new PTFTier(2, 3, 9, 0, 0, 2048, HeatTier.HEATED);
    public static final PTFTier TIER_3 = new PTFTier(3, 3, 8, 1, 0, 32768, HeatTier.SUPERHEATED);
    public static final PTFTier TIER_4 = new PTFTier(4, 5, 16, 9, 0, 262144, HeatTier.SUPERHEATED);
    public static final PTFTier TIER_5 = new PTFTier(5, 9, 56, 16, 9, 2097152, HeatTier.ULTRAHEATED);
    public static final PTFTier TIER_6 = new PTFTier(6, 13, 88, 56, 25, 16777216, HeatTier.ULTRAHEATED);

    public static PTFTier byTier(int tier) {
        return switch (tier) {
            case 1 -> TIER_1;
            case 2 -> TIER_2;
            case 3 -> TIER_3;
            case 4 -> TIER_4;
            case 5 -> TIER_5;
            case 6 -> TIER_6;
            default -> null;
        };
    }
}
