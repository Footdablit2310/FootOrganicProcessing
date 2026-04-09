package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> BIOMASS_T1 = tag("biomass_t1");
        public static final TagKey<Item> BIOMASS_T2 = tag("biomass_t2");
        public static final TagKey<Item> BIOMASS_T3 = tag("biomass_t3");
        public static final TagKey<Item> BIOMASS_T4 = tag("biomass_t4");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(net.minecraft.core.registries.Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(FootOrganicProcessing.MOD_ID, name));
        }
    }
}
