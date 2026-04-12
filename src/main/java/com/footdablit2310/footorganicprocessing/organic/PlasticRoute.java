package com.footdablit2310.footorganicprocessing.organic;

public enum PlasticRoute {
    STARCH("Starch Plastic", "Heated Basin", 8.0f),
    SHELLAC("Shellac Plastic", "Heated Basin", 2.0f),
    PETRO("Petro Plastic", "Superheated Basin / Polymerizer", 1.0f);

    public final String displayName;
    public final String method;
    public final float effectiveCost;

    PlasticRoute(String displayName, String method, float effectiveCost) {
        this.displayName = displayName;
        this.method = method;
        this.effectiveCost = effectiveCost;
    }
}
