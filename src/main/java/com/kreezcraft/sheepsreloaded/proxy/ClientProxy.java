package com.kreezcraft.sheepsreloaded.proxy;

import com.kreezcraft.sheepsreloaded.entities.EntityOreSheep;
import com.kreezcraft.sheepsreloaded.entities.models.ModelOreSheep;
import com.kreezcraft.sheepsreloaded.entities.renderers.RenderOreSheep;
import com.kreezcraft.sheepsreloaded.init.SheepsBlocks;
import com.kreezcraft.sheepsreloaded.init.SheepsItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Dan on 2/25/2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();

        RenderManager rm = Minecraft.getMinecraft().getRenderManager();
        rm.entityRenderMap.put(EntityOreSheep.class, new RenderOreSheep(rm, new ModelOreSheep(), 0.5F));
    }

    @Override
    public void postInit() {
        super.postInit();
        SheepsBlocks.modRegisterRenders();
        SheepsItems.modRegisterRenders();
    }

    @Override
    public EntityPlayer getClientPlayer(){
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public void registerRenders(){
        SheepsItems.registerRenders();
        SheepsBlocks.registerRenders();
    }
}
