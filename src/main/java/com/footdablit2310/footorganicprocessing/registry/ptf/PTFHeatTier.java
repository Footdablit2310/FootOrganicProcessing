package com.footdablit2310.footorganicprocessing.registry.ptf;

public enum PTFHeatTier {
    NONE(0),
    HEATED(750),
    SUPERHEATED(1500),
    ULTRAHEATED(3000); // PTF-exclusive

    public final int minHeat;

    PTFHeatTier(int minHeat) {
        this.minHeat = minHeat;
    }

    public static PTFHeatTier fromHeat(int heat) {
        PTFHeatTier result = NONE;
        for (PTFHeatTier tier : values()) {
            if (heat >= tier.minHeat) {
                result = tier;
            }
        }
        return result;
    }
}
