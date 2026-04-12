package com.footdablit2310.footorganicprocessing.organic;

public enum BiomassTier {
    BASIC(1, 0.25f, "Very low-yield starter biomass"),
    STARCHY(2, 1.0f, "Standard biomass for Starch Plastic"),
    RESINOUS(3, 2.0f, "High-yield biomass for Shellac + Glue"),
    PREMIUM(4, 3.0f, "Clean, efficient biomass for advanced plastics");

    public final int tier;
    public final float yield;
    public final String notes;

    BiomassTier(int tier, float yield, String notes) {
        this.tier = tier;
        this.yield = yield;
        this.notes = notes;
    }
}
