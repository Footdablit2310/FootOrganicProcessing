package com.footdablit2310.footorganicprocessing.registry.ptf;

public enum PTFHeatLevel {
    NONE(0),
    WARM(1),
    HEATED(2),
    SUPERHEATED(3),
    HYPERHEATED(4);

    public final int tier;

    PTFHeatLevel(int tier) {
        this.tier = tier;
    }

    public boolean isAtLeast(PTFHeatLevel other) {
        return this.tier >= other.tier;
    }
}
