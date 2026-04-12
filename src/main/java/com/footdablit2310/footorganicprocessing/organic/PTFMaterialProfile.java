package com.footdablit2310.footorganicprocessing.organic;

public record PTFMaterialProfile(
        String inputKey,
        String heatedOutput,
        float heatedYield,
        String superheatedOutput,
        float superheatedYield,
        String notes
) {
    public static PTFMaterialProfile biomass() {
        return new PTFMaterialProfile("biomass", "syngas", 0.5f, "syngas+bio_oil", 1.0f, "Low-grade feedstock");
    }

    public static PTFMaterialProfile resin() {
        return new PTFMaterialProfile("resin", "aromatics", 1.0f, "aromatics+light_hydrocarbons", 1.5f, "Good mid-tier feedstock");
    }

    public static PTFMaterialProfile plastic() {
        return new PTFMaterialProfile("plastic", "hydrocarbons", 1.0f, "hydrocarbons+cracked_gas", 2.0f, "High-energy feedstock");
    }

    public static PTFMaterialProfile stickyResidue() {
        return new PTFMaterialProfile("sticky_residue", "tar", 0.5f, "tar", 1.125f, "Waste product");
    }

    public static PTFMaterialProfile honeycombWax() {
        return new PTFMaterialProfile("honeycomb_or_wax", "clean_oil", 1.5f, "clean_oil+aromatics", 2.5f, "Premium feedstock");
    }

    public static PTFMaterialProfile bioOilBiomass() {
        return new PTFMaterialProfile("bio_oil_plus_biomass", "methanol", 0.5f, "methanol", 1.0f, "Alcohol (non edible)");
    }
}
