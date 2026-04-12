package com.footdablit2310.footorganicprocessing.organic;

public enum ResidueUse {
    STICKY_RESIDUE_FUEL("Sticky Residue", "Fuel", 100, "Weak early-game fuel"),
    STICKY_PLUS_RESIN_GLUE("Sticky Residue + Resin", "Spirit Glue", -1, "Early-game glue with failure chance"),
    SPIRIT_GLUE("Spirit Glue", "Adhesive", -1, "0.0005% per tick per glued block chance to unglue");

    public final String item;
    public final String use;
    public final int burnTimeTicks;
    public final String notes;

    ResidueUse(String item, String use, int burnTimeTicks, String notes) {
        this.item = item;
        this.use = use;
        this.burnTimeTicks = burnTimeTicks;
        this.notes = notes;
    }
}
