package com.footdablit2310.footorganicprocessing.content.blocks.casing;

import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.footdablit2310.footorganicprocessing.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CasingBlock extends Block implements EntityBlock {

    public CasingBlock(Properties props) {
        super(props);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.CASING.get().create(pos, state);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {

        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof CasingBlockEntity casing)) return InteractionResult.PASS;

        ItemStack held = player.getItemInHand(hand);

        // -------------------------
        // Remove coil (Shift + Right Click)
        // -------------------------
        if (player.isShiftKeyDown()) {
            if (casing.hasCoil()) {
                ItemStack removed = casing.removeCoil();
                player.getInventory().placeItemBackInInventory(removed);
                player.displayClientMessage(Component.literal("Removed coil"), true);
            }
            return InteractionResult.CONSUME;
        }

        // -------------------------
        // Insert coil
        // -------------------------
        if (!casing.hasCoil() && isCoilItem(held)) {
            ItemStack insert = held.copy();
            insert.setCount(1);

            casing.setCoil(insert);
            held.shrink(1);

            player.displayClientMessage(Component.literal("Inserted coil"), true);
            return InteractionResult.CONSUME;
        }

        return InteractionResult.SUCCESS;
    }

    private boolean isCoilItem(ItemStack stack) {
        return stack.is(ModItems.COIL_T1_H.get()) ||
               stack.is(ModItems.COIL_T2_SH.get()) ||
               stack.is(ModItems.COIL_T3_UH.get()) ||
               stack.is(ModItems.COIL_T3R_UH_R.get());
    }
}
