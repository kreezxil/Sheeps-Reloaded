package com.kreezcraft.sheepsreloaded.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Dan on 3/3/2016.
 */
public class SlotOutput extends Slot {

    public SlotOutput(IInventory inventoryIn, int index, int x, int y) {
        super(inventoryIn, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        return inventory.isItemValidForSlot(getSlotIndex(), stack);
    }
}
