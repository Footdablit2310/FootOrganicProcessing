package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PTFControllerBlockEntity extends BlockEntity {

    // --- Core state ---
    private int multiblockTier = 0;          // you set this from redstone or config
    private int failsafeTicks = 0;

    // --- Multiblock cache ---
    private final List<PTFCasingBlockEntity> cachedCasings = new ArrayList<>();
    private boolean structureValid = false;

    public PTFControllerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // --- TICK ---

    public static void serverTick(Level level, BlockPos pos, BlockState state, PTFControllerBlockEntity be) {
        if (level.isClientSide) return;

        // failsafe countdown
        if (be.failsafeTicks > 0) {
            be.failsafeTicks--;
            if (be.failsafeTicks == 0) {
                // allow restart after cooldown
            }
            return;
        }

        // recompute tier if you base it on redstone
        be.updateTierFromRedstone();

        if (!be.validateStructure()) {
            be.shutdown();
            return;
        }

        // at this point structure is valid and casings are active
        // your processing / FE / heat logic goes here
    }

    private void updateTierFromRedstone() {
        if (level == null) return;
        int rs = level.getBestNeighborSignal(worldPosition);
        // example mapping, adjust to your design
        if (rs == 0) multiblockTier = 0;
        else if (rs <= 2) multiblockTier = 1;
        else if (rs <= 4) multiblockTier = 2;
        else if (rs <= 6) multiblockTier = 3;
        else if (rs <= 8) multiblockTier = 4;
        else if (rs <= 12) multiblockTier = 5;
        else multiblockTier = 6;
    }

    private void shutdown() {
        structureValid = false;
        // disable all casings
        for (PTFCasingBlockEntity casing : cachedCasings) {
            casing.setActive(false);
        }
    }

    // --- STRUCTURE VALIDATION ENTRYPOINT ---

    private boolean validateStructure() {
        cachedCasings.clear();
        structureValid = false;

        if (level == null) return false;
        if (multiblockTier <= 0) return false;

        int size = getGridSizeForTier(multiblockTier);
        if (size <= 0) return false;

        int half = size / 2;

        // scan casings in the grid at controller Y
        for (int dx = -half; dx <= half; dx++) {
            for (int dz = -half; dz <= half; dz++) {
                BlockPos p = worldPosition.offset(dx, 0, dz);
                BlockEntity be = level.getBlockEntity(p);

                if (!(be instanceof PTFCasingBlockEntity casing)) {
                    return false; // missing casing
                }

                cachedCasings.add(casing);
            }
        }

        // coils + casings compatibility
        if (!validateCoilsAndCasings()) {
            failsafeTicks = 200; // 10s at 20tps
            return false;
        }

        // vertical conflict rule
        if (!checkVerticalConflicts()) {
            return false;
        }

        structureValid = true;

        // enable all casings when structure is valid
        for (PTFCasingBlockEntity casing : cachedCasings) {
            casing.setActive(true);
        }

        return true;
    }

    // --- HELPERS ---

    private int getGridSizeForTier(int tier) {
        return switch (tier) {
            case 1 -> 1;
            case 2, 3 -> 3;
            case 4 -> 5;
            case 5 -> 9;
            case 6 -> 13;
            default -> 0;
        };
    }

    private boolean validateCoilsAndCasings() {
        for (PTFCasingBlockEntity casing : cachedCasings) {

            if (casing.isFailed())
                return false;

            int coilHeat = casing.getHeatOutput();          // block-specific heat
            int casingRes = casing.getHeatResistance();     // casing heat resistance
            int coilRes = casing.getCoilHeatResistance();   // coil heat resistance

            if (coilHeat <= 0)
                return false; // missing coil

            // coil must not exceed its own resistance
            if (coilHeat > coilRes)
                return false;

            // coil must not exceed casing resistance
            if (coilHeat > casingRes)
                return false;
        }
        return true;
    }

    /**
     * PTFs may only intersect:
     * - at the same Y level (heat can combine)
     * - or outside vertical range (4)
     * Any other vertical overlap within range is invalid.
     */
    private boolean checkVerticalConflicts() {
        if (level == null) return false;

        int range = 4;

        for (int dy = -range; dy <= range; dy++) {
            if (dy == 0) continue;

            BlockPos checkPos = worldPosition.above(dy);
            BlockEntity be = level.getBlockEntity(checkPos);

            if (be instanceof PTFControllerBlockEntity other) {

                if (!other.structureValid)
                    continue;

                // same Y-level → allowed (heat can sum)
                if (dy == 0)
                    continue;

                // outside vertical range → allowed
                if (Math.abs(dy) > range)
                    continue;

                // inside vertical range and different Y → conflict
                return false;
            }
        }

        return true;
    }

    // --- OPTIONAL: heat query API for overlap logic ---

    /**
     * Heat contributed by this PTF at a given block position,
     * based on active casings only.
     */
    public int getHeatAt(BlockPos pos) {
        int total = 0;

        for (PTFCasingBlockEntity casing : cachedCasings) {
            if (!casing.isActive())
                continue;

            // you can refine this with a proper radius instead of manhattan
            int dist = pos.distManhattan(casing.getBlockPos());
            if (dist <= 4) { // example heat radius
                total += casing.getHeatOutput();
            }
        }

        return total;
    }

    // you can later add:
    // - getSummedHeatAt(pos) that iterates nearby controllers on same Y
    // - block heat resistance checks using summed heat
}
