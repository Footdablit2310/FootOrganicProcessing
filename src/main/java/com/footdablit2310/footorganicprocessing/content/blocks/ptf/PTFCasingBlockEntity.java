package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footorganicprocessing.content.items.CoilItem;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import com.footdablit2310.footorganicprocessing.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PTFCasingBlockEntity extends BlockEntity {

    private final int casingTier;
    private ItemStack coil = ItemStack.EMPTY;

    @SuppressWarnings("unused")
    private int wear = 0;       // 0 = OK, 1 = FAILED
    private boolean failed = false;

    // ✔ REQUIRED BY REGISTRATE
    public PTFCasingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        if (state.getBlock() instanceof PTFCasingBlock block) {
            this.casingTier = block.getCasingTier();
        } else {
            this.casingTier = 1;
        }
    }

    // ✔ CONVENIENCE CONSTRUCTOR (used by newBlockEntity)
    public PTFCasingBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.PTF_CASING.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PTFCasingBlockEntity be) {
        if (level.isClientSide)
            return;

        if (be.coil.isEmpty() || be.failed)
            return;

        be.applyWear();
    }

    // Coil acceptance
    public boolean isCoilItem(ItemStack stack) {
        return stack.is(ModItems.COIL_T1_H.get()) ||
               stack.is(ModItems.COIL_T2_SH.get()) ||
               stack.is(ModItems.COIL_T3_UH.get()) ||
               stack.is(ModItems.COIL_T3R_UHR.get());
    }

    public boolean insertCoil(ItemStack stack) {
        if (!coil.isEmpty())
            return false;

        coil = stack.copyWithCount(1);
        wear = 0;
        failed = false;

        setChanged();
        return true;
    }

    public ItemStack removeCoil() {
        ItemStack out = coil;
        coil = ItemStack.EMPTY;
        wear = 0;
        failed = false;

        setChanged();
        return out;
    }

    public int getCoilTier() {
    return coil.getItem() instanceof CoilItem c ? c.getTier() : 0;
    }


    public int getCasingTier() {
        return casingTier;
    }

    public int getHeatOutput() {
    return coil.getItem() instanceof CoilItem c ? c.getHeatOutput() : 0;
    }

    public int getHeatResistance() {
        return switch (casingTier) {
            case 1 -> 1500;
            case 2 -> 2250;
            case 3 -> 12000;
            default -> 0;
        };
    }

    private double getFailureChancePerTick() {
    return coil.getItem() instanceof CoilItem c ? c.getWearRate() : 0;
    }


    private void applyWear() {
        if (coil.isEmpty() || failed)
            return;

        double chance = getFailureChancePerTick();
        if (chance > 0 && level.random.nextDouble() < chance) {
            wear = 1;
            failed = true;
            setChanged();
        }
    }

    public boolean isFailed() {
        return failed;
    }
    public int getCoilHeatResistance() {
        return switch (getCoilTier()) {
            case 1 -> 1500;
            case 2 -> 2250;
            case 3 -> 3000;
            case 4 -> 12000;
            default -> 0;
        };
    }
    private boolean active;

    public void setActive(boolean value) {
        this.active = value;
        setChanged();
    }

    public boolean isActive() {
        return active;
    }
    public void setCoilActive(boolean value) {
        if (coil.getItem() instanceof CoilItem c) {
            c.setActive(coil, value);
            setChanged();
        }
    }

    public boolean isCoilActive() {
        if (!(coil.getItem() instanceof CoilItem c)) return false;
        return c.isActive(coil);
    }



}
