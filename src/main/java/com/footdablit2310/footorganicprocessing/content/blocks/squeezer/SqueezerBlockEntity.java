package com.footdablit2310.footorganicprocessing.content.blocks.squeezer;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.Random;

public class SqueezerBlockEntity extends KineticBlockEntity {

    private static final int SLOT_INPUT  = 0;
    private static final int SLOT_RESIN  = 1;
    private static final int SLOT_STICKS = 2;

    private static final int BASE_TIME = 100; // ticks at speed = 1

    private final ItemStackHandler items = new ItemStackHandler(3);
    private int progress = 0;
    private final Random random = new Random();

    public SqueezerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // ------------------------------------------------------------
    // Tick
    // ------------------------------------------------------------

    public static void tick(Level level, BlockPos pos, BlockState state, SqueezerBlockEntity be) {
        be.tickServer();
    }

    private void tickServer() {
        if (level == null || level.isClientSide) return;

        float speed = Math.abs(getSpeed());
        if (speed <= 0) {
            progress = 0;
            return;
        }

        if (!canProcess()) {
            progress = 0;
            return;
        }

        // Speed scaling: higher speed = faster processing
        progress += speed;

        if (progress >= BASE_TIME) {
            progress = 0;
            doProcess();
        }
    }

    // ------------------------------------------------------------
    // Logic
    // ------------------------------------------------------------

    private boolean canProcess() {
        ItemStack input = items.getStackInSlot(SLOT_INPUT);
        if (!isLog(input)) return false;
        if (input.getCount() < 1) return false;

        // Check output space for sticks
        ItemStack sticksOut = items.getStackInSlot(SLOT_STICKS);
        if (!canMerge(sticksOut, new ItemStack(Items.STICK, 2))) return false;

        // Check output space for resin
        ItemStack resinOut = items.getStackInSlot(SLOT_RESIN);
        Item resinItem = /* ModItems.RESIN.get() */ Items.SLIME_BALL; // placeholder
        if (!canMerge(resinOut, new ItemStack(resinItem, 1))) return false;

        return true;
    }

    private void doProcess() {
        ItemStack input = items.getStackInSlot(SLOT_INPUT);
        if (!isLog(input)) return;

        // Consume 1 log
        input.shrink(1);
        items.setStackInSlot(SLOT_INPUT, input);

        // Always 2 sticks
        mergeIntoSlot(SLOT_STICKS, new ItemStack(Items.STICK, 2));

        // 25% chance resin
        if (random.nextFloat() < 0.25F) {
            Item resinItem = /* ModItems.RESIN.get() */ Items.SLIME_BALL; // placeholder
            mergeIntoSlot(SLOT_RESIN, new ItemStack(resinItem, 1));
        }

        setChanged();
    }

    // ------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------

    private boolean isLog(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.is(Items.OAK_LOG) || stack.is(Items.SPRUCE_LOG) || stack.is(Items.BIRCH_LOG);
    }

    private static boolean canMerge(ItemStack existing, ItemStack incoming) {
        if (incoming.isEmpty()) return true;
        if (existing.isEmpty()) return true;
        if (!ItemStack.isSameItemSameComponents(existing, incoming)) return false;
        int result = existing.getCount() + incoming.getCount();
        return result <= existing.getMaxStackSize();
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
    public enum SqueezerMode {
        SQUEEZING,
        COMPRESSING
    }

    private SqueezerMode mode = SqueezerMode.SQUEEZING;

    public void setMode(SqueezerMode mode) {
        this.mode = mode;
        setChanged();
    }

    public SqueezerMode getMode() {
        return mode;
    }

    // remember to save/load `mode` in NBT if you care about persistence
}
