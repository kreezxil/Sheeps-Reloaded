package com.kreezcraft.sheepsreloaded.tileentities;

import com.kreezcraft.sheepsreloaded.blocks.BaseOreWool;
import com.kreezcraft.sheepsreloaded.blocks.Separator;
import com.kreezcraft.sheepsreloaded.items.SeparatorRegistry;
import com.kreezcraft.sheepsreloaded.utility.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.*;
import net.minecraft.world.EnumSkyBlock;

import java.util.Arrays;

/**
 * Created by Dan on 3/2/2016.
 */
public class TileEntitySeparator extends SheeepsTileEntityBase implements ITickable, ISidedInventory {

    private int burnTimeRemaining = 0;
    private int burnTimeInitialValue = 0;
    private short cookTime;
    private static final short COOK_TIME_FOR_COMPLETION = 200;
    private boolean cachedIsBurning = false;
    private int cachedState = 0;

    private int FUEL_SLOT_ID = 0;
    private int WOOL_SLOT_ID = 1;
    private int WOOL_OUTPUT_SLOT_ID = 2;
    private int RESIDUE_OUTPUT_SLOT_ID = 3;

    private static final byte COOK_FIELD_ID = 0;
    private static final byte FIRST_BURN_TIME_REMAINING_FIELD_ID = 1;
    private static final byte FIRST_BURN_TIME_INITIAL_FIELD_ID = 2;

    private String customName;
    private ItemStack[] separatorStacks = new ItemStack[4];

    @Override
    public void update(){

        boolean isBurning = burnFuel();

        if(canSeparate()){
            if(isBurning){
                cookTime ++;
            } else {
                cookTime -= 2;
            }

            if(cookTime < 0) cookTime = 0;

            if(cookTime >= COOK_TIME_FOR_COMPLETION) {
                separateItem();
                cookTime = 0;
            }

        } else {
            cookTime = 0;
            cachedIsBurning = false;
        }

        if(cachedIsBurning != isBurning){
            cachedIsBurning = true;

            worldObj.checkLightFor(EnumSkyBlock.BLOCK, pos);
        }

        if(burnTimeRemaining > 0){
            if (burnTimeRemaining % 5 < 3) {
                    setState(1);
            } else {
                setState(2);
            }

        } else {
            setState(0);
        }
    }

    public void setState(int state){
        if(cachedState != state) {
            cachedState = state;

            Separator separator = (Separator) getBlockType();
            separator.setState(state, worldObj, pos);

            worldObj.checkLightFor(EnumSkyBlock.BLOCK, pos);
        }
    }

    public double fractionOfFuelRemaining(){
        if(burnTimeInitialValue <= 0) return 0;
        double fraction = burnTimeRemaining / (double)burnTimeInitialValue;
        return MathHelper.clamp_double(fraction, 0.0, 1.0);
    }

    public int secondsOfFuelRemaining(){
        if(burnTimeRemaining <= 0) return 0;
        return burnTimeRemaining / 20;
    }

    public double fractionOfCookTimeComplete(){
        double fraction = cookTime / (double)COOK_TIME_FOR_COMPLETION;
        return MathHelper.clamp_double(fraction, 0.0, 1.0);
    }

    // burn fuel
    // if no fuel remaining to burn return false
    public boolean burnFuel(){
        boolean isBurning = false;
        boolean inventoryChanged = false;

        if(burnTimeRemaining > 0){
            --burnTimeRemaining;
            isBurning = true;
        }
        if(burnTimeRemaining == 0){
            if(canSeparate() && getItemBurnTime(separatorStacks[FUEL_SLOT_ID]) > 0){
                burnTimeRemaining = burnTimeInitialValue = getItemBurnTime(separatorStacks[FUEL_SLOT_ID]);
                --separatorStacks[FUEL_SLOT_ID].stackSize;
                isBurning = true;
                inventoryChanged = true;

                if(separatorStacks[FUEL_SLOT_ID].stackSize == 0){
                    separatorStacks[FUEL_SLOT_ID] = null;
                }
            }
        }

        if(inventoryChanged) markDirty();

        return isBurning;
    }

    public boolean isFuelBurning(){
        return separatorStacks[FUEL_SLOT_ID] != null && separatorStacks[FUEL_SLOT_ID].stackSize > 0 && canSeparate();
    }

    public static short getItemBurnTime(ItemStack stack){
        int burntime = TileEntityFurnace.getItemBurnTime(stack);
        return (short) MathHelper.clamp_int(burntime, 0, Short.MAX_VALUE);
    }

    public boolean canSeparate(){
        if( separatorStacks[WOOL_SLOT_ID] != null && separatorStacks[WOOL_SLOT_ID].stackSize > 0){
            if(separatorStacks[WOOL_OUTPUT_SLOT_ID] == null || separatorStacks[WOOL_OUTPUT_SLOT_ID].stackSize < 64){
                if(separatorStacks[RESIDUE_OUTPUT_SLOT_ID] == null){
                    return true;
                } else if(separatorStacks[RESIDUE_OUTPUT_SLOT_ID].stackSize < 64){
                    ItemStack result = getSeparatorResultForItem(separatorStacks[WOOL_SLOT_ID]);
                    if(result.getItem() == separatorStacks[RESIDUE_OUTPUT_SLOT_ID].getItem()){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    public boolean separateItem(){
        ItemStack result = null;

        if(separatorStacks[WOOL_SLOT_ID] != null){
            ItemStack wool = new ItemStack(Blocks.wool, 1);
            result = getSeparatorResultForItem(separatorStacks[WOOL_SLOT_ID]);

            ItemStack outputWoolStack = separatorStacks[WOOL_OUTPUT_SLOT_ID];
            ItemStack outputResidueStack = separatorStacks[RESIDUE_OUTPUT_SLOT_ID];

            if(outputWoolStack == null || outputWoolStack.stackSize < getInventoryStackLimit()){
                if(result != null){
                    if(outputResidueStack == null || outputResidueStack.stackSize < getInventoryStackLimit()){
                        // add residue to residue output
                        if(separatorStacks[RESIDUE_OUTPUT_SLOT_ID] == null){
                            separatorStacks[RESIDUE_OUTPUT_SLOT_ID] = result.copy();
                        } else {
                            separatorStacks[RESIDUE_OUTPUT_SLOT_ID].stackSize += result.stackSize;
                        }
                    }
                }

                // add wool to wool output
                if(separatorStacks[WOOL_OUTPUT_SLOT_ID] == null){
                    separatorStacks[WOOL_OUTPUT_SLOT_ID] = wool.copy();
                } else {
                    separatorStacks[WOOL_OUTPUT_SLOT_ID].stackSize += wool.stackSize;
                }

                --separatorStacks[WOOL_SLOT_ID].stackSize;
                if(separatorStacks[WOOL_SLOT_ID].stackSize == 0){
                    separatorStacks[WOOL_SLOT_ID] = null;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    public ItemStack getSeparatorResultForItem(ItemStack stack){
        if( stack.getItem() == Item.getItemFromBlock(Blocks.wool)){
            return null;
        } else {
            return SeparatorRegistry.instance().getSeparatingResult(stack);
        }
    }

    @Override
    public int getSizeInventory() {
        return separatorStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return separatorStacks[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if(separatorStacks[index] != null){
            ItemStack itemstack;

            if(separatorStacks[index].stackSize <= count) {
                itemstack = separatorStacks[index];
                setInventorySlotContents(index, null);
                markDirty();
                return itemstack;
            } else {
                itemstack = separatorStacks[index].splitStack(count);

                if(separatorStacks[index].stackSize == 0){
                    setInventorySlotContents(index, null);
                }

                markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        separatorStacks[index] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }

        markDirty();
        //worldObj.markBlockForUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ())) != this ? false : player.getDistanceSq(new BlockPos(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D)) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        // Slot 0: Fuel
        // Slot 1: Wool
        // Slot 2: Output Wool
        // Slot 3: Output Residue

        switch(index){
            case 0:
                if(getItemBurnTime(stack) > 0) {
                    return true;
                }
                break;
            case 1:
                if(Block.getBlockFromItem(stack.getItem()) instanceof BaseOreWool) {
                    return true;
                }
                break;
        }

        return false;
    }

    @Override
    public int getField(int id) {
        if (id == COOK_FIELD_ID) {
            return cookTime;
        } else if (id == FIRST_BURN_TIME_REMAINING_FIELD_ID) {
            return burnTimeRemaining;
        } else if (id == FIRST_BURN_TIME_INITIAL_FIELD_ID) {
            return burnTimeInitialValue;
        } else {
            System.err.println("Invalid field ID in TileInventorySmelting.setField:" + id);
        }

        return 0;
    }

    @Override
    public void setField(int id, int value)
    {
        if (id == COOK_FIELD_ID) {
            cookTime = (short)value;
        } else if (id == FIRST_BURN_TIME_REMAINING_FIELD_ID) {
            burnTimeRemaining = value;
        } else if (id == FIRST_BURN_TIME_INITIAL_FIELD_ID) {
            burnTimeInitialValue = value;
        } else {
            System.err.println("Invalid field ID in TileInventorySmelting.setField:" + id);
        }
    }

    @Override
    public int getFieldCount() {
        return 3;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : Names.Blocks.SEPARATOR;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setCustomName(String name){
        this.customName = name;
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
    }


    public int[] getSlotsForFace(EnumFacing side) {
        return new int[0];
    }

    public boolean canInsertItem(int index, ItemStack stack, EnumFacing direction) {
        return isItemValidForSlot(index, stack);
    }

    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return false;
    }

    @Override
    public Packet getDescriptionPacket(){
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        writeToNBT(nbtTagCompound);
        final int METADATA = 0;
        return new S35PacketUpdateTileEntity(this.pos, METADATA, nbtTagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt){
        readFromNBT(pkt.getNbtCompound());
    }

    // This is where you save any data that you don't want to lose when the tile entity unloads
    // In this case, it saves the state of the furnace (burn time etc) and the itemstacks stored in the fuel, input, and output slots
    @Override
    public void writeToNBT(NBTTagCompound parentNBTTagCompound)
    {
        super.writeToNBT(parentNBTTagCompound); // The super call is required to save and load the tiles location

//		// Save the stored item stacks

        // to use an analogy with Java, this code generates an array of hashmaps
        // The itemStack in each slot is converted to an NBTTagCompound, which is effectively a hashmap of key->value pairs such
        //   as slot=1, id=2353, count=1, etc
        // Each of these NBTTagCompound are then inserted into NBTTagList, which is similar to an array.
        NBTTagList dataForAllSlots = new NBTTagList();
        for (int i = 0; i < this.separatorStacks.length; ++i) {
            if (this.separatorStacks[i] != null) {
                NBTTagCompound dataForThisSlot = new NBTTagCompound();
                dataForThisSlot.setByte("Slot", (byte) i);
                this.separatorStacks[i].writeToNBT(dataForThisSlot);
                dataForAllSlots.appendTag(dataForThisSlot);
            }
        }
        // the array of hashmaps is then inserted into the parent hashmap for the container
        parentNBTTagCompound.setTag("Items", dataForAllSlots);

        // Save everything else
        parentNBTTagCompound.setShort("CookTime", cookTime);
        parentNBTTagCompound.setTag("burnTimeRemaining", new NBTTagInt(burnTimeRemaining));
        parentNBTTagCompound.setTag("burnTimeInitial", new NBTTagInt(burnTimeInitialValue));
    }

    // This is where you load the data that you saved in writeToNBT
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound); // The super call is required to save and load the tiles location
        final byte NBT_TYPE_COMPOUND = 10;       // See NBTBase.createNewByType() for a listing
        NBTTagList dataForAllSlots = nbtTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

        Arrays.fill(separatorStacks, null);           // set all slots to empty
        for (int i = 0; i < dataForAllSlots.tagCount(); ++i) {
            NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
            byte slotNumber = dataForOneSlot.getByte("Slot");
            if (slotNumber >= 0 && slotNumber < this.separatorStacks.length) {
                this.separatorStacks[slotNumber] = ItemStack.loadItemStackFromNBT(dataForOneSlot);
            }
        }

        // Load everything else.  Trim the arrays (or pad with 0) to make sure they have the correct number of elements
        cookTime = nbtTagCompound.getShort("CookTime");
        burnTimeRemaining = nbtTagCompound.getInteger("burnTimeRemaining");
        burnTimeInitialValue = nbtTagCompound.getInteger("burnTimeInitial");

    }
}
