package com.footdablit2310.footorganicprocessing.content.blocks.centrifuge;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;

public class CentrifugeBlock extends KineticBlock implements IBE<CentrifugeBlockEntity> {

    public CentrifugeBlock(Properties properties) {
        super(properties);
    }

    // ------------------------------------------------------------
    // Rotation axis (required by KineticBlock)
    // ------------------------------------------------------------
    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    // ------------------------------------------------------------
    // IBE (Create BlockEntity helper)
    // ------------------------------------------------------------
    @Override
    public Class<CentrifugeBlockEntity> getBlockEntityClass() {
        return CentrifugeBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends CentrifugeBlockEntity> getBlockEntityType() {
        return ModBlockEntities.CENTRIFUGE.get();
    }

    // ------------------------------------------------------------
    // BlockEntity creation
    // ------------------------------------------------------------
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CentrifugeBlockEntity(ModBlockEntities.CENTRIFUGE.get(), pos, state);
    }

    // ------------------------------------------------------------
    // NO getTicker override in Create 0.6.x
    // Create automatically wires CentrifugeBlockEntity::tick
    // ------------------------------------------------------------
}
