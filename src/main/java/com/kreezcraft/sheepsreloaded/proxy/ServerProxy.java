package com.zulucap.sheeeps.proxy;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Dan on 3/2/2016.
 */
public class ServerProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }

    @Override
    public void registerRenders() {}
}
