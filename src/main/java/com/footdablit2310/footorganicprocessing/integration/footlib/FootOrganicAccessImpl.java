package com.footdablit2310.footorganicprocessing.integration.footlib;

import com.footdablit2310.footlib.api.shared.foot_organic_processing.IFootOrganicAccess;
import com.footdablit2310.footlib.api.shared.foot_organic_processing.IPTFTierAccess;

public class FootOrganicAccessImpl implements IFootOrganicAccess {

    private final IPTFTierAccess ptfTiers;

    public FootOrganicAccessImpl(IPTFTierAccess ptfTiers) {
        this.ptfTiers = ptfTiers;
    }

    @Override
    public IPTFTierAccess ptfTiers() {
        return ptfTiers;
    }
}
