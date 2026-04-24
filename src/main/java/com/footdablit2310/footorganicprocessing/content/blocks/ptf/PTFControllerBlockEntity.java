package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footlib.api.shared.foot_organic_processing.ptf.IPTFTier;
import com.footdablit2310.footorganicprocessing.content.blocks.casing.CasingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.footdablit2310.footorganicprocessing.registry.ModItems;

import net.neoforged.neoforge.energy.EnergyStorage;

public class PTFControllerBlockEntity extends BlockEntity {

    private final EnergyStorage energy = new EnergyStorage(2_000_000); // adjust as needed
    private IPTFTier cachedTier = null;
    private int recheckTimer = 0;

    public PTFControllerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // ------------------------------------------------------------
    // Tick
    // ------------------------------------------------------------

    public static void serverTick(Level level, BlockPos pos, BlockState state, PTFControllerBlockEntity be) {
        be.tickServer();
    }

    private void tickServer() {
        if (level == null || level.isClientSide) {
            return;
        }

        // 1. Structure detection (controller is one block BELOW center)
        if (cachedTier == null || recheckTimer++ >= 20) {
            cachedTier = PTFStructureHelper.detectTier(level, worldPosition);
            recheckTimer = 0;
        }

        if (cachedTier == null) {
            return; // invalid multiblock
        }

        // 2. FE drain
        int feCost = cachedTier.fePerTick();
        if (energy.extractEnergy(feCost, true) < feCost) {
            return; // underpowered
        }
        energy.extractEnergy(feCost, false);

        // 3. Coil wear (delegated to casings)
        applyCoilWear(level, worldPosition, cachedTier);

        // 4. TODO: heat output based on tier + coils
    }

    // ------------------------------------------------------------
    // Coil wear dispatch
    // ------------------------------------------------------------

    private void applyCoilWear(Level level, BlockPos controllerPos, IPTFTier tier) {
        int grid = tier.gridSize();
        int radius = grid / 2;

        // Multiblock center is above the controller
        BlockPos center = controllerPos.above();

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {

                BlockPos pos = center.offset(dx, 0, dz);
                BlockEntity be = level.getBlockEntity(pos);

                if (be instanceof CasingBlockEntity casing && casing.hasCoil()) {

                    ItemStack coilStack = casing.getCoilStack();
                    double rate = getCoilWearRate(coilStack);

                    if (rate > 0.0D) {
                        casing.addCoilWear(rate);

                        if (casing.isCoilBroken()) {
                            casing.removeCoil();
                            // TODO: sound/particles if you want
                        }
                    }
                }
            }
        }
    }

    // ------------------------------------------------------------
    // Coil wear rates (from your spreadsheet)
    // ------------------------------------------------------------

    private double getCoilWearRate(ItemStack stack) {
        // Values from your sheet:
        // T1/H   -> 0.00015%/tick  = 0.0000015D
        // T2/SH  -> 0.0003%/tick   = 0.0000030D
        // T3/UH  -> 0.0006%/tick   = 0.0000060D
        // T3-R   -> 0.00006%/tick  = 0.0000006D

        // TODO: replace with your actual coil items:
        if (stack.is(ModItems.COIL_T1_H.get())) return 0.0000015D;
        if (stack.is(ModItems.COIL_T2_SH.get())) return 0.0000030D;
        if (stack.is(ModItems.COIL_T3_UH.get())) return 0.0000060D;
        if (stack.is(ModItems.COIL_T3R_UH_R.get())) return 0.0000006D;

        return 0.0D;
    }

    // ------------------------------------------------------------
    // Energy access
    // ------------------------------------------------------------

    public EnergyStorage getEnergyStorage() {
        return energy;
    }

    // ------------------------------------------------------------
    // Internal heat class (if you want to reuse later)
    // ------------------------------------------------------------
    @SuppressWarnings("unused")
    private enum CoilHeatClass {
        HEATED,
        SUPERHEATED,
        ULTRAHEATED,
        INVALID
    }
}
