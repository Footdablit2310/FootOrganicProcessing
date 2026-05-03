package com.footdablit2310.footorganicprocessing.registry.ptf;

import net.minecraft.core.BlockPos;

public record PTFValidationResult(
        boolean valid,
        BlockPos origin,
        String message
) {
    public static PTFValidationResult success(BlockPos pos) {
        return new PTFValidationResult(true, pos, "OK");
    }

    public static PTFValidationResult fail(BlockPos pos, String msg) {
        return new PTFValidationResult(false, pos, msg);
    }
}
