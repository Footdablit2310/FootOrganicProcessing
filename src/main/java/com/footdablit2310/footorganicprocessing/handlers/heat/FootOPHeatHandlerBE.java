package com.footdablit2310.footorganicprocessing.handlers.heat;

import com.footdablit2310.footlib.api.common.nbt.BasicNbtUtil;
import com.footdablit2310.footlib.api.common.nbt.FluidNbtAdvUtil;
import com.footdablit2310.footlib.api.common.nbt.ItemNbtAdvUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public abstract class FootOPHeatHandlerBE extends BlockEntity {

    // ------------------------------------------------------------
    // Heat system
    // ------------------------------------------------------------
    protected double heat = 0.0;          // Current heat level
    protected double maxHeat = 2000.0;    // Safety limit
    protected double heatLoss = 0.5;      // Heat lost per tick
    protected double heatGain = 0.0;      // Set by PTF each tick

    // ------------------------------------------------------------
    // Processing
    // ------------------------------------------------------------
    protected float progress = 0;
    protected float maxProgress = 200;    // Base time at heat = 1.0

    // ------------------------------------------------------------
    // IO
    // ------------------------------------------------------------
    protected final ItemStackHandler items;
    protected final FluidTank fluids;

    public FootOPHeatHandlerBE(BlockEntityType<?> type, BlockPos pos, BlockState state,
                                        int itemSlots, int fluidCapacity) {
        super(type, pos, state);
        this.items = new ItemStackHandler(itemSlots);
        this.fluids = new FluidTank(fluidCapacity);
    }

    // ------------------------------------------------------------
    // Tick
    // ------------------------------------------------------------
    public static void tick(Level level, BlockPos pos, BlockState state, FootOPHeatHandlerBE be) {
        be.tickServer();
    }

    private void tickServer() {
        if (level == null || level.isClientSide) return;

        // 1) Receive heat from PTF
        heat += heatGain;
        heatGain = 0;

        // 2) Heat decay
        heat -= heatLoss;
        if (heat < 0) heat = 0;

        // 3) Safety clamp
        if (heat > maxHeat) {
            onOverheat();
            heat = maxHeat;
        }

        // 4) Multiblock validation (optional)
        if (!validateStructure()) {
            progress = 0;
            return;
        }

        // 5) Recipe check
        if (!hasValidRecipe()) {
            progress = 0;
            return;
        }

        // 6) Heat threshold
        if (heat < getRequiredHeat()) {
            progress = 0;
            return;
        }

        // 7) Speed scaling
        float speed = getHeatSpeedMultiplier();

        progress += speed;

        if (progress >= maxProgress) {
            progress = 0;
            processRecipe();
        }
    }

    // ------------------------------------------------------------
    // Heat scaling
    // ------------------------------------------------------------
    protected float getHeatSpeedMultiplier() {
        // Example curve:
        // heat = 200 → 1x
        // heat = 400 → 2x
        // heat = 800 → 4x
        return (float) (heat / getRequiredHeat());
    }

    protected abstract double getRequiredHeat();

    // ------------------------------------------------------------
    // Recipe hooks
    // ------------------------------------------------------------
    protected abstract boolean hasValidRecipe();
    protected abstract void processRecipe();

    // ------------------------------------------------------------
    // Multiblock hook
    // ------------------------------------------------------------
    protected boolean validateStructure() {
        return true; // override if needed
    }

    // ------------------------------------------------------------
    // Overheat hook
    // ------------------------------------------------------------
    protected void onOverheat() {
        // Default: do nothing
        // Override for explosions, damage, etc.
    }

    // ------------------------------------------------------------
    // NBT
    // ------------------------------------------------------------
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);

        // --- Primitives via FootLib ---
        BasicNbtUtil.writeDouble(tag, "Heat", heat);
        BasicNbtUtil.writeFloat(tag, "Progress", progress);

        // --- Items via FootLib ---
        ItemNbtAdvUtil.writeHandler(tag, "Items", items, provider);

        // --- Fluids via FootLib ---
        FluidNbtAdvUtil.writeTank(tag, "Fluids", fluids, provider);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);

        // --- Primitives via FootLib ---
        heat = BasicNbtUtil.readDouble(tag, "Heat");
        progress = BasicNbtUtil.readFloat(tag, "Progress");

        // --- Items via FootLib ---
        ItemNbtAdvUtil.readHandler(tag, "Items", items, provider);

        // --- Fluids via FootLib ---
        FluidNbtAdvUtil.readTank(tag, "Fluids", fluids, provider);
    }




    // ------------------------------------------------------------
    // Heat input from PTF
    // ------------------------------------------------------------
    public void addHeat(double amount) {
        this.heatGain += amount;
    }

    public double getHeat() {
        return heat;
    }
}
