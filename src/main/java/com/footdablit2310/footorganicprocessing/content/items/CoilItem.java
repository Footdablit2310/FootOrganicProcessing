package com.footdablit2310.footorganicprocessing.content.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomData;


public class CoilItem extends Item {

    private final int tier;
    private final int heatOutput;
    private final int heatResist;
    private final double wearRate;

    private static final String TAG_ACTIVE = "active";

    public CoilItem(Properties props, int tier, int heatOutput, int heatResist, double wearRate) {
        super(props);
        this.tier = tier;
        this.heatOutput = heatOutput;
        this.heatResist = heatResist;
        this.wearRate = wearRate;
    }

    // --- Custom Data API helpers ---
    private CompoundTag getOrCreateCustomTag(ItemStack stack) {
        var data = stack.get(DataComponents.CUSTOM_DATA);
        if (data != null) {
            return data.copyTag();
        }

        CompoundTag tag = new CompoundTag();
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        return tag;
    }

    private void saveCustomTag(ItemStack stack, CompoundTag tag) {
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }

    // --- ACTIVE FLAG ---
    public boolean isActive(ItemStack stack) {
        CompoundTag tag = getOrCreateCustomTag(stack);
        return tag.getBoolean(TAG_ACTIVE);
    }

    public void setActive(ItemStack stack, boolean value) {
        CompoundTag tag = getOrCreateCustomTag(stack);
        tag.putBoolean(TAG_ACTIVE, value);
        saveCustomTag(stack, tag);
    }

    // --- Static coil properties ---
    public int getTier() { return tier; }
    public int getHeatOutput() { return heatOutput; }
    public int getHeatResistance() { return heatResist; }
    public double getWearRate() { return wearRate; }
}
