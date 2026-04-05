package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.content.squeezer.SqueezerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.Registries;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENUS =
        DeferredRegister.create(Registries.MENU, "footorganicprocessing");

    public static final DeferredHolder<MenuType<?>, MenuType<SqueezerMenu>> SQUEEZER_MENU =
        MENUS.register("squeezer",
            () -> new MenuType<>(
                (IContainerFactory<SqueezerMenu>) SqueezerMenu::new,
                net.minecraft.world.flag.FeatureFlags.VANILLA_SET
            )
        );
}
