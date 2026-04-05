package com.footdablit2310.footorganicprocessing.content.squeezer;

import com.simibubi.create.foundation.gui.menu.AbstractSimiContainerScreen;
import com.simibubi.create.foundation.gui.widget.ScrollInput;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

public class SqueezerScreen extends AbstractSimiContainerScreen<SqueezerMenu> {

    private ScrollInput modeSlider;

    public SqueezerScreen(SqueezerMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }

    @Override
    protected void init() {
        super.init();

        SqueezerBlockEntity be = menu.getBlockEntity();

        modeSlider = new ScrollInput(leftPos + 20, topPos + 20, 100, 20)
            .withRange(0, 2)
            .titled(Component.literal("Mode"))
            .calling(value -> {
                be.setMode(value == 0
                    ? SqueezerBlockEntity.SqueezerMode.SQUEEZING
                    : SqueezerBlockEntity.SqueezerMode.COMPRESSING);
                // networking later; for now this is client‑side only
            })
            .setState(be.getMode() == SqueezerBlockEntity.SqueezerMode.SQUEEZING ? 0 : 1);

        addRenderableWidget(modeSlider);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        // draw background later; empty is fine for now
    }
}
