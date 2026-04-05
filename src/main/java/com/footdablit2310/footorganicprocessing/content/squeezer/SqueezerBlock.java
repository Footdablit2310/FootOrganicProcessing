package com.footdablit2310.footorganicprocessing.content.squeezer;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

public class SqueezerBlock extends KineticBlock implements EntityBlock {

    public SqueezerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.X; // horizontal clamp
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SqueezerBlockEntity(pos, state);
    }
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof SqueezerBlockEntity sbe) {
            return new SimpleMenuProvider(
                (id, inv, player) -> new SqueezerMenu(id, inv, sbe),
                Component.literal("Squeezer")
            );
        }
        return null;
    }
}
