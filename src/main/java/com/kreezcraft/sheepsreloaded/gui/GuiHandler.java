package com.kreezcraft.sheepsreloaded.gui;

import com.kreezcraft.sheepsreloaded.inventory.ContainerSeparator;
import com.kreezcraft.sheepsreloaded.tileentities.TileEntitySeparator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Dan on 3/3/2016.
 */
public class GuiHandler implements IGuiHandler {
    public enum GuiIDs {
        SEPARATOR;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        switch(GuiIDs.values()[ID]){
            case SEPARATOR:
                return new ContainerSeparator(player.inventory, (TileEntitySeparator)world.getTileEntity(new BlockPos(x, y, z)));
        }
        throw new IllegalArgumentException("No gui with this id " + ID);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        switch(GuiIDs.values()[ID]){
            case SEPARATOR:
                return new GuiSeparator(player.inventory, "separator", (TileEntitySeparator)world.getTileEntity(new BlockPos(x, y, z)));
        }
        throw new IllegalArgumentException("No gui with id " + ID);
    }
}
