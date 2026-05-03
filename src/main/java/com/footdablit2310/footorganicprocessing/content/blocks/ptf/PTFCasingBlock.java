package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PTFCasingBlock extends Block implements EntityBlock {

    private final int casingTier; // 1, 2, or 3

    public PTFCasingBlock(Properties props, int tier) {
        super(props);
        this.casingTier = tier;
    }

    public int getCasingTier() {
        return casingTier;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PTFCasingBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level, BlockState state, BlockEntityType<T> type
    ) {
        if (type == ModBlockEntities.PTF_CASING.get()) {
            return (lvl, pos, st, be) -> PTFCasingBlockEntity.tick(lvl, pos, st, (PTFCasingBlockEntity) be);
        }
        return null;
    }

    public InteractionResult use(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        if (level.isClientSide)
            return InteractionResult.SUCCESS;

        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof PTFCasingBlockEntity casing))
            return InteractionResult.PASS;

        ItemStack held = player.getItemInHand(hand);

        // Insert coil
        if (!held.isEmpty() && casing.isCoilItem(held)) {
            if (casing.insertCoil(held)) {
                if (!player.isCreative())
                    held.shrink(1);
                return InteractionResult.CONSUME;
            }
        }

        // Remove coil (shift-right-click with empty hand)
        if (held.isEmpty() && player.isShiftKeyDown()) {
            ItemStack removed = casing.removeCoil();
            if (!removed.isEmpty()) {
                player.addItem(removed);
                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
    }
}
