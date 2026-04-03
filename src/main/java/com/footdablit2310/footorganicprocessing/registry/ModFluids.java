package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class ModFluids {
    private static final CreateRegistrate REG = FootOrganicProcessing.REGISTRATE;

    public static final FluidEntry<BaseFlowingFluid.Flowing> RESIN =
            REG.standardFluid("resin")
                    .lang("Resin")
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> HYDROCARBONS =
            REG.standardFluid("hydrocarbons")
                    .lang("Hydrocarbons")
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> AROMATICS =
            REG.standardFluid("aromatics")
                    .lang("Aromatics")
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> SYNGAS =
            REG.standardFluid("syngas")
                    .lang("Syngas")
                    .register();

    public static void register() {}
}
