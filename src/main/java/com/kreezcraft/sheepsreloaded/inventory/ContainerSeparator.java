package com.kreezcraft.sheepsreloaded.inventory;

import com.kreezcraft.sheepsreloaded.tileentities.TileEntitySeparator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Dan on 3/3/2016.
 */
public class ContainerSeparator extends SheepsContainerBase {
    private final TileEntitySeparator te;
    private int [] cachedFields;
    public ContainerSeparator(InventoryPlayer playerInventory, TileEntitySeparator te){
        addSlotToContainer(new SlotFuel(te, 0, 8, 53));                                     // Fuel Slot
        addSlotToContainer(new SlotOreWool(te, 1, 54, 35));                                  // Input Slot
        addSlotToContainer(new SlotOutput(te, 2, 111, 22));                                   // Output Slot Wool
        addSlotToContainer(new SlotOutput(te, 3, 111, 48));                                   // Output Slot Residue

        addPlayerSlots(playerInventory, 8, 84);
        this.te = te;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return te.isUseableByPlayer(player);
    }

    @Override
    public void detectAndSendChanges(){
        super.detectAndSendChanges();

        boolean allFieldsHaveChanged = false;
        boolean fieldHasChanged [] = new boolean[te.getFieldCount()];
        if (cachedFields == null) {
            cachedFields = new int[te.getFieldCount()];
            allFieldsHaveChanged = true;
        }
        for (int i = 0; i < cachedFields.length; ++i) {
            if (allFieldsHaveChanged || cachedFields[i] != te.getField(i)) {
                cachedFields[i] = te.getField(i);
                fieldHasChanged[i] = true;
            }
        }

        // go through the list of crafters (players using this container) and update them if necessary
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            for (int fieldID = 0; fieldID < te.getFieldCount(); ++fieldID) {
                if (fieldHasChanged[fieldID]) {
                    // Note that although sendProgressBarUpdate takes 2 ints on a server these are truncated to shorts
                    icrafting.sendProgressBarUpdate(this, fieldID, cachedFields[fieldID]);
                }
            }
        }
        // do stuff here?
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value){
        super.updateProgressBar(id, value);

        te.setField(id, value);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex){
        ItemStack itemStack = null;
        Slot slot = (Slot)inventorySlots.get(slotIndex);

        if(slot != null && slot.getHasStack()){
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if(slotIndex < 4){
                if(!mergeItemStack(itemStack1, 4, 40, true)){
                    return null;
                }
            } else {
                for(int i = 0; i < 4; i++) {
                    Slot shiftedInSlot = (Slot) inventorySlots.get(i);
                    if(!shiftedInSlot.getHasStack() && shiftedInSlot.isItemValid(itemStack1)) mergeItemStack(itemStack1, i, i+1, false);
                }
            }

            if(itemStack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if(itemStack1.stackSize == itemStack.stackSize){
                return null;
            }

            slot.onPickupFromSlot(player, itemStack1);
        }

        return itemStack;
    }
}
