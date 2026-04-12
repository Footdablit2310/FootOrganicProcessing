package com.footdablit2310.footorganicprocessing.content.blocks.ptf;

import com.footdablit2310.footlib.api.common.heat.HeatAccess;
import com.footdablit2310.footlib.api.common.heat.HeatSource;
import com.footdablit2310.footlib.api.common.heat.HeatTier;
import com.footdablit2310.footorganicprocessing.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PTFBlockEntity extends BlockEntity implements HeatSource {

    private PTFTier tier = PTFTier.TIER_1;
    private boolean structureValid = false;
    private double coilWear = 0.0D;

    public PTFBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PTF_BE.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, PTFBlockEntity be) {
        if (level.isClientSide) return;

        // Validate structure every second
        if (level.getGameTime() % 20 == 0) {
            be.structureValid = PTFStructureHelper.validateStructure(level, pos);
            if (be.structureValid) {
                be.tier = PTFStructureHelper.detectTier(level, pos);
            }
        }

        if (!be.structureValid) return;

        // FE consumption
        if (!be.consumeFE(be.tier.feCost())) return;

        // Coil wear
        be.applyCoilWear();

        // Provide heat
        HeatAccess.provideHeat(level, pos, be.outputTier());
    }

    private boolean consumeFE(int amount) {
        // TODO: integrate with your FE system
        return true;
    }

    private void applyCoilWear() {
        // TODO: real wear logic
        coilWear += 0.000001D;
    }

    public PTFTier getTier() {
        return tier;
    }

    public boolean isStructureValid() {
        return structureValid;
    }

    @Override
    public HeatTier outputTier() {
        return structureValid ? tier.outputTier() : HeatTier.NONE;
    }

    @Override
    public int heatOutput() {
        return outputTier().heat();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Tier", tier.tier());
        tag.putBoolean("StructureValid", structureValid);
        tag.putDouble("CoilWear", coilWear);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        int t = tag.getInt("Tier");
        PTFTier loaded = PTFTier.byTier(t);
        if (loaded != null) tier = loaded;
        structureValid = tag.getBoolean("StructureValid");
        coilWear = tag.getDouble("CoilWear");
    }
}
