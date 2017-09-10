package com.zulucap.sheeeps.blocks;

import net.minecraft.block.material.Material;

/**
 * Created by Dan on 2/25/2016.
 */
public class RedstoneWool extends BaseOreWool{
    public RedstoneWool(Material materialIn) {
        super(materialIn);

        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setStepSound(soundTypeCloth);
        this.setLightLevel(0.1F);
    }

}
