package com.footdablit2310.footorganicprocessing.content.blocks.casing;

import com.footdablit2310.footlib.api.common.ItemNbtUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CasingBlockEntity extends BlockEntity {

    private ItemStack coil = ItemStack.EMPTY;
    private double coilWear = 0.0D; // 0.0 = new, 1.0 = broken

    public CasingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // ------------------------------------------------------------
    // Coil access
    // ------------------------------------------------------------

    public boolean hasCoil() {
        return !coil.isEmpty();
    }

    public ItemStack getCoilStack() {
        return coil;
    }

    public void setCoil(ItemStack stack) {
        this.coil = stack.copy();
        this.coilWear = 0.0D;
        setChanged();
    }

    public ItemStack removeCoil() {
        ItemStack removed = coil.copy();
        coil = ItemStack.EMPTY;
        coilWear = 0.0D;
        setChanged();
        return removed;
    }

    // ------------------------------------------------------------
    // Wear logic (driven by PTF controller)
    // ------------------------------------------------------------

    public void addCoilWear(double amount) {
        if (coil.isEmpty() || amount <= 0.0D) {
            return;
        }
        coilWear += amount;
        if (coilWear > 1.0D) {
            coilWear = 1.0D;
        }
        setChanged();
    }

    public boolean isCoilBroken() {
        return coilWear >= 1.0D;
    }

    public double getCoilWear() {
        return coilWear;
    }

    // ------------------------------------------------------------
    // NBT
    // ------------------------------------------------------------

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        ItemNbtUtil.writeOptionalItem(tag, "Coil", coil, provider);
        tag.putDouble("CoilWear", coilWear);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        coil = ItemNbtUtil.readOptionalItem(tag, "Coil", provider);
        coilWear = tag.contains("CoilWear") ? tag.getDouble("CoilWear") : 0.0D;
    }
}
