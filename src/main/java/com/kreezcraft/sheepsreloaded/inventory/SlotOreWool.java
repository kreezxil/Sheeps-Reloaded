package com.kreezcraft.sheepsreloaded.inventory;

import com.kreezcraft.sheepsreloaded.blocks.BaseOreWool;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Dan on 3/4/2016.
 */
public class SlotOreWool extends Slot {
    public SlotOreWool(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        return Block.getBlockFromItem(stack.getItem()) instanceof BaseOreWool;
    }
}
