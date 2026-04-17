package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.content.blocks.casing.CasingBlockEntity;
import com.footdablit2310.footorganicprocessing.registry.ModBlocks;
import com.footdablit2310.footorganicprocessing.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;

public class PTFStructureHelper {

    // Casing blocks
    private static final Block CASING_T1 = ModBlocks.CASING_T1.get();
    private static final Block CASING_T2 = ModBlocks.CASING_T2.get();
    private static final Block CASING_T3 = ModBlocks.CASING_T3.get();

    // Coil items
    private static final Item COIL_T1 = ModItems.COIL_T1_H.get();
    private static final Item COIL_T2 = ModItems.COIL_T2_SH.get();
    private static final Item COIL_T3 = ModItems.COIL_T3_UH.get();
    private static final Item COIL_T3R = ModItems.COIL_T3R_UH_R.get();

    public static boolean validateStructure(Level level, BlockPos controllerPos) {
        return detectTier(level, controllerPos) != null;
    }

    public static PTFTier detectTier(Level level, BlockPos controllerPos) {

        for (PTFTier tier : new PTFTier[]{
                PTFTier.TIER_6,
                PTFTier.TIER_5,
                PTFTier.TIER_4,
                PTFTier.TIER_3,
                PTFTier.TIER_2,
                PTFTier.TIER_1
        }) {
            if (matchesTier(level, controllerPos, tier)) {
                return tier;
            }
        }

        return null;
    }

    private static boolean matchesTier(Level level, BlockPos controllerPos, PTFTier tier) {

        int grid = tier.gridSize();
        int radius = grid / 2;

        int heated = 0;
        int superheated = 0;
        int ultraheated = 0;

        int casingTier = 0;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {

                BlockPos pos = controllerPos.offset(dx, 0, dz);
                BlockState state = level.getBlockState(pos);
                Block block = state.getBlock();

                // Only casings matter
                if (!isCasing(block)) continue;

                casingTier = Math.max(casingTier, getCasingTier(block));

                // Check coil inside casing BE
                BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof CasingBlockEntity casingBE) {

                Item coil = casingBE.getCoilItem();

                if (coil == COIL_T1) heated++;
                else if (coil == COIL_T2) superheated++;
                else if (coil == COIL_T3 || coil == COIL_T3R) ultraheated++;
            }
        }

        // Validate coil counts
        if (heated != tier.heatedZones()) return false;
        if (superheated != tier.superheatedZones()) return false;
        if (ultraheated != tier.ultraheatedZones()) return false;

        // Validate casing heat resistance
        if (!casingSupportsTier(tier, casingTier)) return false;

        return true;
        }
    }

    private static boolean isCasing(Block block) {
        return block == CASING_T1 || block == CASING_T2 || block == CASING_T3;
    }

    private static int getCasingTier(Block block) {
        if (block == CASING_T1) return 1;
        if (block == CASING_T2) return 2;
        if (block == CASING_T3) return 3;
        return 0;
    }

    private static boolean casingSupportsTier(PTFTier tier, int casingTier) {
        return switch (tier.outputTier()) {
            case HEATED -> casingTier >= 1;
            case SUPERHEATED -> casingTier >= 2;
            case ULTRAHEATED -> casingTier >= 3;
            default -> false;
        };
    }
}
