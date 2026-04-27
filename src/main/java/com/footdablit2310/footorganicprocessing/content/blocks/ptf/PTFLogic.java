package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import com.footdablit2310.footlib.api.common.nbt.NbtAdvUtil;

public class PTFLogic {

    private static final int MIN_VERTICAL_RANGE = 2;

    private int tier = 0;
    private int verticalRange = 2;

    private double heatCelsius = 0.0;
    private double fePerTick = 0.0;
    private double wearPerTick = 0.0;

    public void updateTierFromRedstone(int rs) {
        tier = (rs <= 0) ? 0 : Math.min(rs, 6);
    }

    public boolean isActive() {
        return tier > 0;
    }

    public boolean validateMultiblock(Level level, BlockPos pos) {
        return tier > 0;
    }

    public void computeState(Level level, BlockPos pos) {
        switch (tier) {
            case 1 -> { heatCelsius = 750; fePerTick = 128; }
            case 2 -> { heatCelsius = 750; fePerTick = 2048; }
            case 3 -> { heatCelsius = 1500; fePerTick = 32768; }
            case 4 -> { heatCelsius = 1500; fePerTick = 262144; }
            case 5 -> { heatCelsius = 3000; fePerTick = 2097152; }
            case 6 -> { heatCelsius = 3000; fePerTick = 16777216; }
            default -> { heatCelsius = 0; fePerTick = 0; }
        }

        wearPerTick = (heatCelsius / 250.0) * 0.00005;
        verticalRange = Math.max(MIN_VERTICAL_RANGE, verticalRange);
    }

    public void emitHeat(Level level, BlockPos pos) {
        if (!isActive() || heatCelsius <= 0) return;
        // FootLib heat API goes here
    }

    public void clearHeat(Level level, BlockPos pos) {
        // FootLib heat API clear
    }

    public void tickWear(Level level, BlockPos pos) {
        if (!isActive() || heatCelsius <= 0) return;
        // FootLib durability
    }

    public void drainEnergy(Level level, BlockPos pos) {
        if (!isActive() || fePerTick <= 0) return;
        // FootLib energy
    }

    public void save(CompoundTag tag) {
        NbtAdvUtil.putIfNotNull(tag, "Tier", tier, false);
        NbtAdvUtil.putIfNotNull(tag, "VerticalRange", verticalRange, false);
        NbtAdvUtil.putIfNotNull(tag, "HeatC", heatCelsius, false);
        NbtAdvUtil.putIfNotNull(tag, "FEpt", fePerTick, false);
        NbtAdvUtil.putIfNotNull(tag, "Wearpt", wearPerTick, false);
    }

    public void load(CompoundTag tag) {
        tier = tag.getInt("Tier");
        verticalRange = Math.max(MIN_VERTICAL_RANGE, NbtAdvUtil.getInt(tag, "VerticalRange", MIN_VERTICAL_RANGE, false).getA());
        heatCelsius = NbtAdvUtil.getDouble(tag, "HeatC", 0.0, false).getA();
        fePerTick = NbtAdvUtil.getDouble(tag, "FEpt", 0.0, false).getA();
        wearPerTick = NbtAdvUtil.getDouble(tag, "Wearpt", 0.0, false).getA();
    }
}
