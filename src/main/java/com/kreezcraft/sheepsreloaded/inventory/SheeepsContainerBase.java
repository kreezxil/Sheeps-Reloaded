package com.kreezcraft.sheepsreloaded.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by Dan on 3/3/2016.
 */
public class SheeepsContainerBase extends Container {

    protected void addPlayerSlots(InventoryPlayer playerInventory, int x, int y){
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, x + j * 18, y + i * 18));
            }
        }

        for(int i=0; i<9; ++i){
            addSlotToContainer(new Slot(playerInventory, i, x + i * 18, y + 58));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }
}
