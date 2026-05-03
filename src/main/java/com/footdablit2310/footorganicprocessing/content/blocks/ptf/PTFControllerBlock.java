package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footlib.api.common.redstone.FootLibRedstoneConfigurable;
import com.footdablit2310.footlib.api.common.redstone.FootLibRedstoneMode;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

public class PTFControllerBlock extends Block implements EntityBlock {

    public static final EnumProperty<BlazeBurnerBlock.HeatLevel> HEAT_LEVEL =
            EnumProperty.create("blaze", BlazeBurnerBlock.HeatLevel.class);

    public PTFControllerBlock(Properties props) {
        super(props);
        registerDefaultState(defaultBlockState()
                .setValue(HEAT_LEVEL, BlazeBurnerBlock.HeatLevel.NONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HEAT_LEVEL);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PTFControllerBlockEntity(ModBlockEntities.PTF_CONTROLLER.get(), pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> type
    ) {
        return type == ModBlockEntities.PTF_CONTROLLER.get()
                ? (lvl, pos, st, be) -> PTFControllerBlockEntity.serverTick(lvl, pos, st, (PTFControllerBlockEntity) be)
                : null;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        if (level.isClientSide)
            return ItemInteractionResult.SUCCESS;

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof FootLibRedstoneConfigurable configurable && stack.isEmpty()) {
            FootLibRedstoneMode next = switch (configurable.footlib$getRedstoneMode()) {
                case IGNORE -> FootLibRedstoneMode.HIGH;
                case HIGH -> FootLibRedstoneMode.LOW;
                case LOW -> FootLibRedstoneMode.PULSE;
                case PULSE -> FootLibRedstoneMode.IGNORE;
            };
            configurable.footlib$setRedstoneMode(next);
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
