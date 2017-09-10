package com.zulucap.sheeeps.proxy;

import com.zulucap.sheeeps.entities.EntityOreSheep;
import com.zulucap.sheeeps.entities.models.ModelOreSheep;
import com.zulucap.sheeeps.entities.renderers.RenderOreSheep;
import com.zulucap.sheeeps.init.SheeepsBlocks;
import com.zulucap.sheeeps.init.SheeepsItems;
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
        SheeepsBlocks.modRegisterRenders();
        SheeepsItems.modRegisterRenders();
    }

    @Override
    public EntityPlayer getClientPlayer(){
        return Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public void registerRenders(){
        SheeepsItems.registerRenders();
        SheeepsBlocks.registerRenders();
    }
}
