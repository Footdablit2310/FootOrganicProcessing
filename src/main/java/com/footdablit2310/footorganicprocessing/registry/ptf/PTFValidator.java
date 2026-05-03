package com.footdablit2310.footorganicprocessing.registry.ptf;

import com.footdablit2310.footlib.api.common.multiblock.MultiblockCheckerAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public final class PTFValidator {

    public static PTFValidationResult validate(ServerLevel level, BlockPos origin, PTFDefinition def) {

        if (def == null) {
            return PTFValidationResult.fail(origin, "PTF definition is null");
        }

        var structure = def.structure();
        if (structure == null) {
            return PTFValidationResult.fail(origin, "PTF has no structure definition");
        }

        var result = MultiblockCheckerAPI.check(level, origin, structure.blocks());

        if (result.valid()) {
            return PTFValidationResult.success(origin);
        }

        return PTFValidationResult.fail(origin, result.message());
    }
}
