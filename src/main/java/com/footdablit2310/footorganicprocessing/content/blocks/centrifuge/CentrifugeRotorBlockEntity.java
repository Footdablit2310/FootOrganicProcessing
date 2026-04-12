package com.footdablit2310.footorganicprocessing.content.blocks.centrifuge;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.footdablit2310.footorganicprocessing.registry.ModBlocks;
import com.footdablit2310.footlib.api.common.multiblock.MultiblockPattern;
import com.footdablit2310.footlib.api.common.multiblock.MultiblockMatcher;
import com.footdablit2310.footlib.api.common.heat.HeatAccess;
import com.footdablit2310.footlib.api.common.heat.HeatTier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CentrifugeRotorBlockEntity extends BlockEntity {

    private static MultiblockPattern PATTERN;

    private boolean formed;
    private HeatTier heatTier = HeatTier.NONE;
    private int processTime;
    private int processTimeTotal;

    // ✔ Registrate-compatible constructor
    public CentrifugeRotorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // ✔ Convenience constructor for your block
    public CentrifugeRotorBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.CENTRIFUGE_ROTOR.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, CentrifugeRotorBlockEntity be) {
        if (level.isClientSide) return;

        if (!be.formed) {
            be.formed = ensureFormed(level, pos);
            if (!be.formed) return;
        }

        be.heatTier = HeatAccess.getHeatTier(level, pos);
        if (be.heatTier == HeatTier.NONE) return;

        if (be.processTime < be.processTimeTotal) {
            be.processTime++;
            if (be.processTime >= be.processTimeTotal) {
                be.finishProcess();
            }
        } else {
            be.tryStartProcess();
        }
    }

    private static boolean ensureFormed(Level level, BlockPos corePos) {
        if (PATTERN == null) {
            PATTERN = MultiblockPattern.builder()
                    .layer("CCC", "CHC", "CCC")
                    .layer("CCC", "CRC", "CCC")
                    .layer("CCC", "CIC", "CCC")
                    .key('C', ModBlocks.CENTRIFUGE_CASING.get())
                    .key('R', ModBlocks.CENTRIFUGE_ROTOR.get())
                    .key('I', ModBlocks.CENTRIFUGE_INPUT_HATCH.get())
                    .key('H', ModBlocks.CENTRIFUGE_HEAT_PORT.get())
                    .build();
        }
        return MultiblockMatcher.matches(level, corePos, PATTERN);
    }

    private void tryStartProcess() {
        // TODO
    }

    private void finishProcess() {
        // TODO
        processTime = 0;
    }
}
