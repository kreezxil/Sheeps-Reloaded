package com.kreezcraft.sheepsreloaded.items.spawnEgg;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Dan on 2/26/2016.
 */
public class  BaseOreSpawnEgg extends Item {

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote) {
            Entity entityToSpawn = EntityList.createEntityByName("Sheep", worldIn);
            entityToSpawn.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
            worldIn.spawnEntityInWorld(entityToSpawn);

            return true;
        }

        return false;
    }
}
