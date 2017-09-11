package com.kreezcraft.sheepsreloaded.inventory;

import com.kreezcraft.sheepsreloaded.tileentities.TileEntitySeparator;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Dan on 3/4/2016.
 */
public class SlotFuel extends Slot {

    public SlotFuel(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack){
        return TileEntitySeparator.getItemBurnTime(stack) > 0;
    }
}
