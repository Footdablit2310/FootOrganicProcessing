package com.footdablit2310.footorganicprocessing.api;

public final class FootOrganicAPI {

    private static IFootOrganicAccess access;

    public static void registerAccess(IFootOrganicAccess impl) {
        access = impl;
    }

    public static IFootOrganicAccess get() {
        return access;
    }
}
