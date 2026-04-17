package com.footdablit2310.footorganicprocessing.content.blocks.casing;

import com.footdablit2310.footlib.api.common.ItemNbtUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CasingBlockEntity extends BlockEntity {

    private ItemStack coil = ItemStack.EMPTY;

    public CasingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // -------------------------
    // Coil Access
    // -------------------------

    public boolean hasCoil() {
        return !coil.isEmpty();
    }

    public ItemStack getCoilStack() {
        return coil;
    }

    public Item getCoilItem() {
        return coil.getItem();
    }

    public void setCoil(ItemStack stack) {
        this.coil = stack.copy();
        setChanged();
    }

    public ItemStack removeCoil() {
        ItemStack removed = coil.copy();
        coil = ItemStack.EMPTY;
        setChanged();
        return removed;
    }

    // -------------------------
    // NBT (NeoForge 1.21.1)
    // -------------------------

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        ItemNbtUtil.writeOptionalItem(tag, "Coil", coil, provider);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        coil = ItemNbtUtil.readOptionalItem(tag, "Coil", provider);
    }

}
