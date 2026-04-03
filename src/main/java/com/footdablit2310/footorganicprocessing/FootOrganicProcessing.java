package com.footdablit2310.footorganicprocessing;

import com.footdablit2310.footorganicprocessing.registry.*;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.neoforged.fml.common.Mod;

@Mod(FootOrganicProcessing.MOD_ID)
public class FootOrganicProcessing {
    public static final String MOD_ID = "footorganicprocessing";

    public static final CreateRegistrate REGISTRATE =
            CreateRegistrate.create(MOD_ID);

    public FootOrganicProcessing() {
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModBlockEntities.register();
        ModRecipeTypes.register();
        ModCreativeTabs.register();
    }
}
