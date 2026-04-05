package com.footdablit2310.footorganicprocessing.content.squeezer;

import com.footdablit2310.footorganicprocessing.registry.ModMenus;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;

public class SqueezerMenu extends AbstractContainerMenu {

    private final SqueezerBlockEntity be;

    public SqueezerMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, (SqueezerBlockEntity) inv.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public SqueezerMenu(int id, Inventory inv, SqueezerBlockEntity be) {
        super(ModMenus.SQUEEZER_MENU.get(), id);
        this.be = be;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    public SqueezerBlockEntity getBlockEntity() {
        return be;
    }
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }
}
