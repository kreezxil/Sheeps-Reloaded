package com.kreezcraft.sheepsreloaded.proxy;

import com.kreezcraft.sheepsreloaded.init.SheeepsBlocks;
import com.kreezcraft.sheepsreloaded.init.SheeepsEntities;
import com.kreezcraft.sheepsreloaded.init.SheeepsItems;
import com.kreezcraft.sheepsreloaded.init.SheeepsRecipes;
import com.kreezcraft.sheepsreloaded.items.SeparatorRegistry;
import com.kreezcraft.sheepsreloaded.items.WasherRegistry;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Dan on 2/25/2016.
 */
public abstract class CommonProxy{
    public void preInit(){
        SheeepsEntities.registerSheeep();
    }

    public void init(){

    }

    public void postInit(){
        SheeepsItems.modRegister();
        SheeepsBlocks.modRegister();
        SheeepsEntities.registerModSheeep();
        WasherRegistry.instance().addModWasherRecipes();
        SeparatorRegistry.instance().addModSeparatorRecipes();
        SheeepsRecipes.addModFurnaceRecipes();
    }

    public abstract EntityPlayer getClientPlayer();

    public abstract void registerRenders();
}
