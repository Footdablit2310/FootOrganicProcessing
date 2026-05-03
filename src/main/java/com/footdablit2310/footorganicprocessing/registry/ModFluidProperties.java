// ModFluidProperties.java
package com.footdablit2310.footorganicprocessing.registry;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public final class ModFluidProperties {

    public static final BaseFlowingFluid.Properties SYNGAS_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.SYNGAS_TYPE,
                    ModFluids.SYNGAS,
                    ModFluids.SYNGAS_FLOWING
            );

    public static final BaseFlowingFluid.Properties BIO_OIL_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.BIO_OIL_TYPE,
                    ModFluids.BIO_OIL,
                    ModFluids.BIO_OIL_FLOWING
            );

    public static final BaseFlowingFluid.Properties AROMATICS_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.AROMATICS_TYPE,
                    ModFluids.AROMATICS,
                    ModFluids.AROMATICS_FLOWING
            );

    public static final BaseFlowingFluid.Properties LIGHT_HC_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.LIGHT_HC_TYPE,
                    ModFluids.LIGHT_HC,
                    ModFluids.LIGHT_HC_FLOWING
            );

    public static final BaseFlowingFluid.Properties HYDROCARBONS_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.HYDROCARBONS_TYPE,
                    ModFluids.HYDROCARBONS,
                    ModFluids.HYDROCARBONS_FLOWING
            );

    public static final BaseFlowingFluid.Properties CRACKED_GAS_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.CRACKED_GAS_TYPE,
                    ModFluids.CRACKED_GAS,
                    ModFluids.CRACKED_GAS_FLOWING
            );

    public static final BaseFlowingFluid.Properties CLEAN_OIL_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.CLEAN_OIL_TYPE,
                    ModFluids.CLEAN_OIL,
                    ModFluids.CLEAN_OIL_FLOWING
            );

    public static final BaseFlowingFluid.Properties TAR_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.TAR_TYPE,
                    ModFluids.TAR,
                    ModFluids.TAR_FLOWING
            );

    public static final BaseFlowingFluid.Properties METHANOL_PROPS =
            new BaseFlowingFluid.Properties(
                    ModFluids.METHANOL_TYPE,
                    ModFluids.METHANOL,
                    ModFluids.METHANOL_FLOWING
            );

    private ModFluidProperties() {}
}
