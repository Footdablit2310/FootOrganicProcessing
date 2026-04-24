package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footlib.api.shared.foot_organic_processing.ptf.IPTFTier;
import com.footdablit2310.footlib.api.shared.foot_organic_processing.ptf.PTFTierRegistry;
import com.footdablit2310.footorganicprocessing.content.blocks.casing.CasingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public final class PTFStructureHelper {

    private PTFStructureHelper() {}

    /**
     * Detects which PTF tier this multiblock matches.
     * Controller is ONE BLOCK BELOW the multiblock center.
     */
    public static IPTFTier detectTier(Level level, BlockPos controllerPos) {

        // The actual multiblock center is above the controller
        BlockPos center = controllerPos.above();

        // Try all registered tiers from FootLib
        for (IPTFTier tier : PTFTierRegistry.all()) {
            if (matchesTier(level, center, tier)) {
                return tier;
            }
        }

        return null; // no tier matched
    }

    /**
     * Checks if the multiblock at the given center matches the given tier.
     */
    private static boolean matchesTier(Level level, BlockPos center, IPTFTier tier) {

        int grid = tier.gridSize();
        int radius = grid / 2;

        int heatedCount = 0;
        int shCount = 0;
        int uhCount = 0;

        // Scan the grid
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {

                BlockPos pos = center.offset(dx, 0, dz);
                BlockEntity be = level.getBlockEntity(pos);

                // Must be a casing
                if (!(be instanceof CasingBlockEntity casing)) {
                    return false;
                }

                // Must have a coil
                if (!casing.hasCoil()) {
                    return false;
                }

                // Determine coil heat class
                CoilHeatClass heat = classifyCoil(casing);

                switch (heat) {
                    case HEATED -> heatedCount++;
                    case SUPERHEATED -> shCount++;
                    case ULTRAHEATED -> uhCount++;
                    default -> { return false; }
                }
            }
        }

        // Compare counts to tier requirements
        return heatedCount == tier.heatedZones()
                && shCount == tier.superheatedZones()
                && uhCount == tier.ultraheatedZones();
    }

    /**
     * Classifies a coil into HEATED / SUPERHEATED / ULTRAHEATED.
     * Replace with your actual coil items.
     */
    private static CoilHeatClass classifyCoil(CasingBlockEntity casing) {
        // TODO: Replace with your actual coil item checks
        // Example:
        // ItemStack stack = casing.getCoilStack();
        // if (stack.is(ModItems.PTF_COIL_T1.get())) return CoilHeatClass.HEATED;
        // if (stack.is(ModItems.PTF_COIL_T2.get())) return CoilHeatClass.SUPERHEATED;
        // if (stack.is(ModItems.PTF_COIL_T3.get())) return CoilHeatClass.ULTRAHEATED;

        return CoilHeatClass.INVALID;
    }

    private enum CoilHeatClass {
        HEATED,
        SUPERHEATED,
        ULTRAHEATED,
        INVALID
    }
}
