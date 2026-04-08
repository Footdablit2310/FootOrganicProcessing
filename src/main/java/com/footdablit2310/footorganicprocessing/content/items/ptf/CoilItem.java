package com.footdablit2310.footorganicprocessing.content.items.ptf;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CoilItem extends Item {

    private final int heatOutputC;          // 750 / 1500 / 3000
    private final int heatResistanceC;      // 1500 / 2250 / 3000 / 12000
    private final double wearChancePerTick; // 0.0000015 etc.

    public CoilItem(Properties props,
                    int durability,
                    int heatOutputC,
                    int heatResistanceC,
                    double wearChancePerTick) {

        super(props.durability(durability));
        this.heatOutputC = heatOutputC;
        this.heatResistanceC = heatResistanceC;
        this.wearChancePerTick = wearChancePerTick;
    }

    // -------------------------------------------------------------------------
    // Getters used by PTFControllerBlockEntity
    // -------------------------------------------------------------------------

    /** Heat output in °C (750 / 1500 / 3000). */
    public int getHeatOutputC() {
        return heatOutputC;
    }

    /** Maximum heat the coil can tolerate before instant destruction. */
    public int getHeatResistanceC() {
        return heatResistanceC;
    }

    /** Probability per tick that the coil takes 1 durability damage. */
    public double getWearChancePerTick() {
        return wearChancePerTick;
    }

    // Optional helper if you want to check worn state
    public boolean isWorn(ItemStack stack) {
        return stack.getDamageValue() >= stack.getMaxDamage();
    }
}
