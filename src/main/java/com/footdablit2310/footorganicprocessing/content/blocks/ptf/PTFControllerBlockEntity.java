package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.registry.ModItems;
import com.footdablit2310.footorganicprocessing.content.items.ptf.CoilItem;
import com.footdablit2310.footlib.api.common.NbtUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;

public class PTFControllerBlockEntity extends BlockEntity {

    private static final int MAX_FE = 1_000_000;
    private static final int FE_PER_TICK = 40;

    private final EnergyStorage energy = new EnergyStorage(MAX_FE);

    private final ItemStackHandler items = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    public PTFControllerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // -------------------------------------------------------------------------
    // Tick Logic
    // -------------------------------------------------------------------------
    public static void tick(Level level, BlockPos pos, BlockState state, PTFControllerBlockEntity be) {
        if (level.isClientSide) return;

        ItemStack coil = be.items.getStackInSlot(0);
        if (coil.isEmpty() || !(coil.getItem() instanceof CoilItem coilItem)) {
            return;
        }

        if (be.energy.getEnergyStored() < FE_PER_TICK) {
            return;
        }

        be.energy.extractEnergy(FE_PER_TICK, false);

        int heatOutput = coilItem.getHeatOutputC();
        int coilRes = coilItem.getHeatResistanceC();

        if (heatOutput > coilRes) {
            be.meltdownCoil(coil);
            be.setChanged();
            return;
        }

        be.applyCoilWear(level, coil, coilItem);

        be.setChanged();
    }

    private void meltdownCoil(ItemStack coil) {
        ItemStack worn = coil.copy();
        worn.setDamageValue(worn.getMaxDamage());
        items.setStackInSlot(1, worn);
        items.setStackInSlot(0, ItemStack.EMPTY);
    }

    private void applyCoilWear(Level level, ItemStack coil, CoilItem coilItem) {
        double wearChance = coilItem.getWearChancePerTick();
        if (level.random.nextDouble() < wearChance) {
            coil.hurtAndBreak(1, null, null);
            if (coil.getDamageValue() >= coil.getMaxDamage()) {
                meltdownCoil(coil);
            }
        }
    }

    public int getHeatTier() {
        ItemStack coil = items.getStackInSlot(0);
        if (coil.isEmpty() || !(coil.getItem() instanceof CoilItem)) return 0;

        if (coil.is(ModItems.COIL_T1_H.get())) return 1;
        if (coil.is(ModItems.COIL_T2_SH.get())) return 2;
        if (coil.is(ModItems.COIL_T3_UH.get())) return 3;
        if (coil.is(ModItems.COIL_T3R_UH_R.get())) return 3;

        return 0;
    }

    // -------------------------------------------------------------------------
    // Serialization (NeoForge 21.1)
    // -------------------------------------------------------------------------
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);

        NbtUtil.putItemHandler(tag, "Items", items, provider);
        NbtUtil.putEnergy(tag, "Energy", energy);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);

        NbtUtil.getItemHandler(tag, "Items", items, provider);
        NbtUtil.getEnergy(tag, "Energy", energy);
    }

    // -------------------------------------------------------------------------
    // Capabilities (NeoForge 21.1)
    // -------------------------------------------------------------------------
    public ItemStackHandler getItemHandler() { return items; }
    public EnergyStorage getEnergyStorage() { return energy; }

}
