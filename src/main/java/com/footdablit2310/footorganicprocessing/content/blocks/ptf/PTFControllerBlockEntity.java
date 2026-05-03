package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.content.items.CoilItem;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class PTFControllerBlockEntity extends BlockEntity {

    private int currentHeat = 0;
    private int maxAllowedHeat = 0;
    private boolean validStructure = false;
    private int currentTier = 0;

    public PTFControllerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public PTFControllerBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.PTF_CONTROLLER.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, PTFControllerBlockEntity be) {
        if (level.isClientSide) return;

        long time = level.getGameTime();

        if (time % 20 == 0) {
            be.revalidate();
        }

        if (be.validStructure && time % 20 == 0) {
            be.applyCoilWear();
        }
    }

    private void revalidate() {
        if (level == null) return;

        int rs = level.getBestNeighborSignal(worldPosition);
        currentTier = Mth.clamp(rs, 1, 6);

        List<PTFCasingBlockEntity> casings = findCasingsForTier(currentTier);

        if (casings.isEmpty()) {
            validStructure = false;
            currentHeat = 0;
            maxAllowedHeat = 0;
            return;
        }

        if (!validateLayout(casings, currentTier)) {
            validStructure = false;
            currentHeat = 0;
            maxAllowedHeat = 0;
            return;
        }

        computeHeatAndResistance(casings);

        if (currentHeat > maxAllowedHeat) {
            validStructure = false;
            currentHeat = 0;
            return;
        }

        validStructure = true;
    }

    private List<PTFCasingBlockEntity> findCasingsForTier(int tier) {
        List<PTFCasingBlockEntity> result = new ArrayList<>();
        if (level == null) return result;

        int grid = switch (tier) {
            case 1 -> 1;
            case 2, 3 -> 3;
            case 4 -> 5;
            case 5 -> 9;
            case 6 -> 13;
            default -> 1;
        };

        int radius = grid / 2;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                BlockPos p = worldPosition.offset(dx, 0, dz);
                BlockEntity be = level.getBlockEntity(p);
                if (be instanceof PTFCasingBlockEntity casing) {
                    result.add(casing);
                }
            }
        }

        return result;
    }

    private boolean validateLayout(List<PTFCasingBlockEntity> casings, int tier) {
        if (level == null) return false;

        int grid = switch (tier) {
            case 1 -> 1;
            case 2, 3 -> 3;
            case 4 -> 5;
            case 5 -> 9;
            case 6 -> 13;
            default -> 1;
        };

        int expected = grid * grid;
        if (casings.size() != expected) return false;

        int radius = grid / 2;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                BlockPos p = worldPosition.offset(dx, 0, dz);
                if (!(level.getBlockEntity(p) instanceof PTFCasingBlockEntity)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void computeHeatAndResistance(List<PTFCasingBlockEntity> casings) {
        int totalHeat = 0;
        int minResistance = Integer.MAX_VALUE;

        for (PTFCasingBlockEntity casing : casings) {
            CoilItem coil = casing.getCoilData();
            if (coil == null) continue;

            totalHeat += coil.getHeatOutput();
            minResistance = Math.min(minResistance, coil.getHeatResistance());
        }

        if (minResistance == Integer.MAX_VALUE) {
            totalHeat = 0;
            minResistance = 0;
        }

        currentHeat = totalHeat;
        maxAllowedHeat = minResistance;
    }

    private void applyCoilWear() {
        // Wear is handled inside casing tick
    }
}
