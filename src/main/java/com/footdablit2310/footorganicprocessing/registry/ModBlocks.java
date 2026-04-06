package com.footdablit2310.footorganicprocessing.registry;

import com.footdablit2310.footorganicprocessing.FootOrganicProcessing;
import com.footdablit2310.footorganicprocessing.content.blocks.ptf.*;
import com.footdablit2310.footorganicprocessing.content.blocks.squeezer.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.createBlocks(FootOrganicProcessing.MOD_ID);

    public static final DeferredRegister<Item> BLOCK_ITEMS =
            DeferredRegister.createItems(FootOrganicProcessing.MOD_ID);

    // -------------------------
    //  PTF CONTROLLER
    // -------------------------
    public static final DeferredHolder<Block, Block> PTF_CONTROLLER =
            BLOCKS.register("ptf_controller",
                    () -> new PTFControllerBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .strength(4.0F, 6.0F)
                            .requiresCorrectToolForDrops()
                    ));

    public static final DeferredHolder<Item, Item> PTF_CONTROLLER_ITEM =
            BLOCK_ITEMS.register("ptf_controller",
                    () -> new BlockItem(PTF_CONTROLLER.get(), new Item.Properties()));

    // -------------------------
    //  SQUEEZER
    // -------------------------
    public static final DeferredHolder<Block, Block> SQUEEZER =
            BLOCKS.register("squeezer",
                    () -> new SqueezerBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(3.0F)
                    ));

    public static final DeferredHolder<Item, Item> SQUEEZER_ITEM =
            BLOCK_ITEMS.register("squeezer",
                    () -> new BlockItem(SQUEEZER.get(), new Item.Properties()));

    // -------------------------
    //  ULTRA STURDY BLOCK
    // -------------------------
    public static final DeferredHolder<Block, Block> ULTRA_STURDY_BLOCK =
            BLOCKS.register("ultra_sturdy_block",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLACK)
                            .strength(10.0F, 1200.0F)
                            .requiresCorrectToolForDrops()
                    ));

    public static final DeferredHolder<Item, Item> ULTRA_STURDY_BLOCK_ITEM =
            BLOCK_ITEMS.register("ultra_sturdy_block",
                    () -> new BlockItem(ULTRA_STURDY_BLOCK.get(), new Item.Properties()));

    // -------------------------
    //  CASINGS (T1, T2, T3)
    // -------------------------
    public static final DeferredHolder<Block, Block> CASING_T1 =
            BLOCKS.register("casing_t1",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_LIGHT_GRAY)
                            .strength(3.0F)
                    ));

    public static final DeferredHolder<Item, Item> CASING_T1_ITEM =
            BLOCK_ITEMS.register("casing_t1",
                    () -> new BlockItem(CASING_T1.get(), new Item.Properties()));

    public static final DeferredHolder<Block, Block> CASING_T2 =
            BLOCKS.register("casing_t2",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_GRAY)
                            .strength(4.0F)
                    ));

    public static final DeferredHolder<Item, Item> CASING_T2_ITEM =
            BLOCK_ITEMS.register("casing_t2",
                    () -> new BlockItem(CASING_T2.get(), new Item.Properties()));

    public static final DeferredHolder<Block, Block> CASING_T3 =
            BLOCKS.register("casing_t3",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLACK)
                            .strength(6.0F)
                    ));

    public static final DeferredHolder<Item, Item> CASING_T3_ITEM =
            BLOCK_ITEMS.register("casing_t3",
                    () -> new BlockItem(CASING_T3.get(), new Item.Properties()));
}
