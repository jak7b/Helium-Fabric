package net.kuko.mechest.Init;

import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class BlockInit implements BlockRegistryContainer {

    public static final Block CLEAR_GLASS = new Block(
            AbstractBlock.Settings.copy(Blocks.GLASS) // Start from glass defaults
                    .nonOpaque() // Simplify transparency
                    .allowsSpawning((state, world,
                                     pos, type) -> false) // Prevent mob spawns
    );


    @NoBlockItem // available since 0.3.13+1.18; Adds no Item to the Block
    public static final Block DEBUG_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.STONE));

    @Override
    public BlockItem createBlockItem(Block block, String identifier) {
        return new BlockItem(block, new Item.Settings());
    }


}

