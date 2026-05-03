package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.content.items.CoilItem;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class PTFCasingBlockEntity extends BlockEntity {

    private final int casingTier;

    private final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private boolean failed = false;
    private boolean active = false;

    public PTFCasingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        if (state.getBlock() instanceof PTFCasingBlock block) {
            this.casingTier = block.getCasingTier();
        } else {
            this.casingTier = 1;
        }
    }

    public PTFCasingBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.PTF_CASING.get(), pos, state);
    }

    // Capability provider uses this
    public ItemStackHandler getInventory() {
        return inventory;
    }

    // Inventory logic
    public ItemStack getCoilStack() {
        return inventory.getStackInSlot(0);
    }

    public boolean hasCoil() {
        return !inventory.getStackInSlot(0).isEmpty();
    }

    public boolean insertCoil(ItemStack stack) {
        if (!(stack.getItem() instanceof CoilItem)) return false;
        if (hasCoil()) return false;

        inventory.setStackInSlot(0, stack.copyWithCount(1));
        failed = false;
        setChanged();
        return true;
    }

    public ItemStack removeCoil() {
        ItemStack out = inventory.getStackInSlot(0);
        inventory.setStackInSlot(0, ItemStack.EMPTY);
        failed = false;
        setChanged();
        return out;
    }

    public CoilItem getCoilData() {
        ItemStack stack = inventory.getStackInSlot(0);
        if (stack.getItem() instanceof CoilItem c) return c;
        return null;
    }

    // Heat + resistance
    public int getHeatOutput() {
        ItemStack stack = inventory.getStackInSlot(0);
        return stack.getItem() instanceof CoilItem c ? c.getHeatOutput() : 0;
    }

    public int getCoilHeatResistance() {
        ItemStack stack = inventory.getStackInSlot(0);
        return stack.getItem() instanceof CoilItem c ? c.getHeatResistance() : 0;
    }

    public int getCasingHeatResistance() {
        return switch (casingTier) {
            case 1 -> 1500;
            case 2 -> 2250;
            case 3 -> 12000;
            default -> 0;
        };
    }

    // Wear
    private double getFailureChancePerTick() {
        ItemStack stack = inventory.getStackInSlot(0);
        return stack.getItem() instanceof CoilItem c ? c.getWearRate() : 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PTFCasingBlockEntity be) {
        if (level.isClientSide) return;
        if (!be.hasCoil() || be.failed) return;

        be.applyWear();
    }

    private void applyWear() {
        double chance = getFailureChancePerTick();
        if (chance > 0 && level.random.nextDouble() < chance) {
            failed = true;
            setChanged();
        }
    }

    public boolean isFailed() {
        return failed;
    }

    public void setActive(boolean value) {
        this.active = value;
        setChanged();
    }

    public boolean isActive() {
        return active;
    }
}
