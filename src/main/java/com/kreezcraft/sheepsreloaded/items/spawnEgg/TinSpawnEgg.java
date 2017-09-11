package com.kreezcraft.sheepsreloaded.items.spawnEgg;

import com.kreezcraft.sheepsreloaded.entities.EntityOreSheep;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Dan on 2/26/2016.
 */
public class TinSpawnEgg extends BaseOreSpawnEgg {

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote) {
            EntityOreSheep entityToSpawn = (EntityOreSheep) EntityList.createEntityByName("sheeeps.OreSheeep", worldIn);
            entityToSpawn.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
            entityToSpawn.setSheeepType(9);
            worldIn.spawnEntityInWorld(entityToSpawn);
            return true;
        }

        return false;
    }
}
