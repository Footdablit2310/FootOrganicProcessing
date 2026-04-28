package com.footdablit2310.footorganicprocessing.registry.ptf;

import com.footdablit2310.footlib.api.registry.helpers.multiblock.MultiBlockDefinition;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record PTFDefinition(
        ResourceLocation id,
        PTFTier tier,
        PTFHeatLevel heatLevel,
        MultiBlockDefinition structure,
        PTFMaterialProfile materials,
        List<PTFRecipe> recipes
) {}
