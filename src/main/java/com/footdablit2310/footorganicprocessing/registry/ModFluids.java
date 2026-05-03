package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModFluids {

    // NeoForge registry for FluidType
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, FootOrganicProcessing.MOD_ID);

    // Vanilla registry for actual fluids
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, FootOrganicProcessing.MOD_ID);

    // ============================================================
    // SYNGAS
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> SYNGAS_TYPE =
            FLUID_TYPES.register("syngas",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(-100)
                            .viscosity(1)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SYNGAS =
            FLUIDS.register("syngas",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.SYNGAS_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> SYNGAS_FLOWING =
            FLUIDS.register("syngas_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.SYNGAS_PROPS));

    // ============================================================
    // BIO OIL
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> BIO_OIL_TYPE =
            FLUID_TYPES.register("bio_oil",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(900)
                            .viscosity(1500)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> BIO_OIL =
            FLUIDS.register("bio_oil",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.BIO_OIL_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> BIO_OIL_FLOWING =
            FLUIDS.register("bio_oil_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.BIO_OIL_PROPS));

    // ============================================================
    // AROMATICS
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> AROMATICS_TYPE =
            FLUID_TYPES.register("aromatics",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(800)
                            .viscosity(900)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> AROMATICS =
            FLUIDS.register("aromatics",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.AROMATICS_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> AROMATICS_FLOWING =
            FLUIDS.register("aromatics_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.AROMATICS_PROPS));

    // ============================================================
    // LIGHT HYDROCARBONS
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> LIGHT_HC_TYPE =
            FLUID_TYPES.register("light_hydrocarbons",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(-50)
                            .viscosity(5)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> LIGHT_HC =
            FLUIDS.register("light_hydrocarbons",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.LIGHT_HC_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> LIGHT_HC_FLOWING =
            FLUIDS.register("light_hydrocarbons_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.LIGHT_HC_PROPS));

    // ============================================================
    // HYDROCARBONS
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> HYDROCARBONS_TYPE =
            FLUID_TYPES.register("hydrocarbons",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(700)
                            .viscosity(600)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> HYDROCARBONS =
            FLUIDS.register("hydrocarbons",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.HYDROCARBONS_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> HYDROCARBONS_FLOWING =
            FLUIDS.register("hydrocarbons_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.HYDROCARBONS_PROPS));

    // ============================================================
    // CRACKED GAS
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> CRACKED_GAS_TYPE =
            FLUID_TYPES.register("cracked_gas",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(-80)
                            .viscosity(3)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> CRACKED_GAS =
            FLUIDS.register("cracked_gas",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.CRACKED_GAS_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> CRACKED_GAS_FLOWING =
            FLUIDS.register("cracked_gas_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.CRACKED_GAS_PROPS));

    // ============================================================
    // CLEAN OIL
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> CLEAN_OIL_TYPE =
            FLUID_TYPES.register("clean_oil",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(850)
                            .viscosity(1000)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> CLEAN_OIL =
            FLUIDS.register("clean_oil",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.CLEAN_OIL_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> CLEAN_OIL_FLOWING =
            FLUIDS.register("clean_oil_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.CLEAN_OIL_PROPS));

    // ============================================================
    // TAR
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> TAR_TYPE =
            FLUID_TYPES.register("tar",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(1200)
                            .viscosity(4000)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> TAR =
            FLUIDS.register("tar",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.TAR_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> TAR_FLOWING =
            FLUIDS.register("tar_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.TAR_PROPS));

    // ============================================================
    // METHANOL
    // ============================================================
    public static final DeferredHolder<FluidType, FluidType> METHANOL_TYPE =
            FLUID_TYPES.register("methanol",
                    () -> new FluidType(FluidType.Properties.create()
                            .density(790)
                            .viscosity(400)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> METHANOL =
            FLUIDS.register("methanol",
                    () -> new BaseFlowingFluid.Source(ModFluidProperties.METHANOL_PROPS));

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> METHANOL_FLOWING =
            FLUIDS.register("methanol_flowing",
                    () -> new BaseFlowingFluid.Flowing(ModFluidProperties.METHANOL_PROPS));

    private ModFluids() {}
}
