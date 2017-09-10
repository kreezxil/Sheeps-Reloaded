package com.zulucap.sheeeps.proxy;

import com.zulucap.sheeeps.init.SheeepsBlocks;
import com.zulucap.sheeeps.init.SheeepsEntities;
import com.zulucap.sheeeps.init.SheeepsItems;
import com.zulucap.sheeeps.init.SheeepsRecipes;
import com.zulucap.sheeeps.items.SeparatorRegistry;
import com.zulucap.sheeeps.items.WasherRegistry;
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
