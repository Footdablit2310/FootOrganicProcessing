package com.footdablit2310.footorganicprocessing.content.blocks.centrifuge;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class CentrifugeBlockEntity extends KineticBlockEntity {

    private static final int SLOT_INPUT  = 0;
    private static final int SLOT_WAX    = 1;
    private static final int SLOT_HONEY  = 2;

    private static final int BASE_TIME = 100;

    private final ItemStackHandler items = new ItemStackHandler(3);
    private float progress = 0;
    private boolean validStructure = false;

    public CentrifugeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // ------------------------------------------------------------
    // Tick
    // ------------------------------------------------------------
    public static void tick(Level level, BlockPos pos, BlockState state, CentrifugeBlockEntity be) {
        be.tickServer();
    }

    private void tickServer() {
        if (level == null || level.isClientSide) return;

        // Validate structure every 20 ticks
        if (level.getGameTime() % 20 == 0) {
            validStructure = validateMultiblock(level, worldPosition);
        }

        if (!validStructure) {
            progress = 0;
            return;
        }

        float speed = Math.abs(getSpeed());
        if (speed <= 0) {
            progress = 0;
            return;
        }

        if (!canProcess()) {
            progress = 0;
            return;
        }

        progress += speed;

        if (progress >= BASE_TIME) {
            progress = 0;
            doProcess();
        }
    }

    // ------------------------------------------------------------
    // Multiblock Validation (FINAL LAYOUT)
    // ------------------------------------------------------------
    private boolean validateMultiblock(Level level, BlockPos controllerPos) {

        // ---------------------------
        // Y‑1 (basin layer)
        // ---------------------------
        BlockPos basinLayer = controllerPos;

        BlockPos[] basinOffsets = {
                new BlockPos( 1, 0,  0),
                new BlockPos(-1, 0,  0),
                new BlockPos( 0, 0,  1),
                new BlockPos( 0, 0, -1)
        };

        for (BlockPos off : basinOffsets) {
            BlockState state = level.getBlockState(basinLayer.offset(off));
            if (!state.is(AllBlocks.BASIN.get())) {
                return false;
            }
        }

        // Corners must be EMPTY
        BlockPos[] emptyCorners = {
                new BlockPos( 1, 0,  1),
                new BlockPos(-1, 0,  1),
                new BlockPos( 1, 0, -1),
                new BlockPos(-1, 0, -1)
        };

        for (BlockPos off : emptyCorners) {
            if (!level.isEmptyBlock(basinLayer.offset(off))) {
                return false;
            }
        }

        // ---------------------------
        // Y (middle layer)
        // ---------------------------
        BlockPos midLayer = controllerPos.above();

        // Chutes above basins
        for (BlockPos off : basinOffsets) {
            BlockState state = level.getBlockState(midLayer.offset(off));
            if (!state.is(AllBlocks.CHUTE.get())) {
                return false;
            }
        }

        // Center = glass
        if (!level.getBlockState(midLayer).is(Blocks.GLASS)) {
            return false;
        }

        // Corners empty
        for (BlockPos off : emptyCorners) {
            if (!level.isEmptyBlock(midLayer.offset(off))) {
                return false;
            }
        }

        // ---------------------------
        // Y+1 (top layer)
        // ---------------------------
        BlockPos topLayer = controllerPos.above(2);

        // Center brass block
        if (!level.getBlockState(topLayer).is(AllBlocks.BRASS_BLOCK)) {
            return false;
        }

        // Brass corners
        for (BlockPos off : emptyCorners) {
            if (!level.getBlockState(topLayer.offset(off)).is(AllBlocks.BRASS_BLOCK)) {
                return false;
            }
        }

        // Side chutes
        for (BlockPos off : basinOffsets) {
            if (!level.getBlockState(topLayer.offset(off)).is(AllBlocks.CHUTE.get())) {
                return false;
            }
        }

        // ---------------------------
        // SU input (shaft above center brass block)
        // ---------------------------
        BlockState aboveCenter = level.getBlockState(topLayer.above());
        if (!aboveCenter.is(AllBlocks.SHAFT.get())) {
            return false;
        }

        return true;
    }

    // ------------------------------------------------------------
    // Processing Logic
    // ------------------------------------------------------------
    private boolean canProcess() {
        ItemStack input = items.getStackInSlot(SLOT_INPUT);
        if (!input.is(Items.HONEYCOMB)) return false;

        // Wax output
        ItemStack waxOut = items.getStackInSlot(SLOT_WAX);
        if (!canMerge(waxOut, new ItemStack(Items.HONEYCOMB))) return false;

        // Honey output
        ItemStack honeyOut = items.getStackInSlot(SLOT_HONEY);
        if (!canMerge(honeyOut, new ItemStack(Items.HONEY_BOTTLE))) return false;

        return true;
    }

    private void doProcess() {
        ItemStack input = items.getStackInSlot(SLOT_INPUT);
        if (!input.is(Items.HONEYCOMB)) return;

        input.shrink(1);
        items.setStackInSlot(SLOT_INPUT, input);

        mergeIntoSlot(SLOT_WAX, new ItemStack(Items.HONEYCOMB, 1));
        mergeIntoSlot(SLOT_HONEY, new ItemStack(Items.HONEY_BOTTLE, 1));

        setChanged();
    }

    // ------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------
    private static boolean canMerge(ItemStack existing, ItemStack incoming) {
        if (incoming.isEmpty()) return true;
        if (existing.isEmpty()) return true;
        if (!ItemStack.isSameItemSameComponents(existing, incoming)) return false;
        return existing.getCount() + incoming.getCount() <= existing.getMaxStackSize();
    }

    private void mergeIntoSlot(int slot, ItemStack incoming) {
        if (incoming.isEmpty()) return;
        ItemStack existing = items.getStackInSlot(slot);
        if (existing.isEmpty()) {
            items.setStackInSlot(slot, incoming);
        } else if (ItemStack.isSameItemSameComponents(existing, incoming)) {
            existing.grow(incoming.getCount());
            items.setStackInSlot(slot, existing);
        }
    }

    public ItemStackHandler getItemHandler() {
        return items;
    }
}
