package com.kreezcraft.sheepsreloaded.proxy;

import com.kreezcraft.sheepsreloaded.init.SheepsBlocks;
import com.kreezcraft.sheepsreloaded.init.SheepsEntities;
import com.kreezcraft.sheepsreloaded.init.SheepsItems;
import com.kreezcraft.sheepsreloaded.init.SheepsRecipes;
import com.kreezcraft.sheepsreloaded.items.SeparatorRegistry;
import com.kreezcraft.sheepsreloaded.items.WasherRegistry;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Dan on 2/25/2016.
 */
public abstract class CommonProxy{
    public void preInit(){
        SheepsEntities.registerSheep();
    }

    public void init(){

    }

    public void postInit(){
        SheepsItems.modRegister();
        SheepsBlocks.modRegister();
        SheepsEntities.registerModSheep();
        WasherRegistry.instance().addModWasherRecipes();
        SeparatorRegistry.instance().addModSeparatorRecipes();
        SheepsRecipes.addModFurnaceRecipes();
    }

    public abstract EntityPlayer getClientPlayer();

    public abstract void registerRenders();
}
