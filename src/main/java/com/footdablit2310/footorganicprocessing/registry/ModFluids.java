package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class ModFluids {
    private static final Registrate REGISTRATE = FootOrganicProcessing.REGISTRATE;

    public static final FluidEntry<BaseFlowingFluid.Flowing> RESIN =
            REGISTRATE.fluid("resin")
                    .lang("Resin")
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> HYDROCARBONS =
            REGISTRATE.fluid("hydrocarbons")
                    .lang("Hydrocarbons")
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> AROMATICS =
            REGISTRATE.fluid("aromatics")
                    .lang("Aromatics")
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> SYNGAS =
            REGISTRATE.fluid("syngas")
                    .lang("Syngas")
                    .register();
    public static final FluidEntry<BaseFlowingFluid.Flowing> BIOOIL =
            REGISTRATE.fluid("bio_oil")
                    .lang("Bio Oil")
                    .register();

    public static void register() {}
}
