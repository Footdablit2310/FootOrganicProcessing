package com.footdablit2310.footorganicprocessing.mechanical;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public final class TappingLogic {

    public enum TapTier {
        NORMAL(65536),
        HEATED(16384),
        SUPERHEATED(4096),
        ULTRAHEATED(1024);

        public final int chance;

        TapTier(int chance) {
            this.chance = chance;
        }
    }

    private TappingLogic() {}

    public static ItemStack tryTap(RandomSource random, TapTier tier) {
        if (random.nextInt(tier.chance) == 0) {
            return new ItemStack(Items.BLAZE_ROD);
        }
        return ItemStack.EMPTY;
    }
}