package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PTFControllerBlockEntity extends BlockEntity {

    private final PTFLogic logic = new PTFLogic();

    public PTFControllerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PTFControllerBlockEntity be) {
        be.serverTick(level, pos, state);
    }

    private void serverTick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) return;

        int rs = level.getBestNeighborSignal(worldPosition);
        logic.updateTierFromRedstone(rs);

        if (!logic.isActive()) {
            logic.clearHeat(level, pos);
            return;
        }

        if (!logic.validateMultiblock(level, pos)) {
            logic.clearHeat(level, pos);
            return;
        }

        logic.computeState(level, pos);
        logic.emitHeat(level, pos);
        logic.tickWear(level, pos);
        logic.drainEnergy(level, pos);
    }

    public void onRedstoneUpdated() {
        if (level != null && !level.isClientSide) {
            int rs = level.getBestNeighborSignal(worldPosition);
            logic.updateTierFromRedstone(rs);
        }
    }
    
    protected void saveAdditional(CompoundTag tag) {
        logic.save(tag);
    }

    public void load(CompoundTag tag) {
        logic.load(tag);
    }
}
