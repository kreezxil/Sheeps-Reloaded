package com.zulucap.sheeeps.blocks;

import net.minecraft.block.material.Material;

/**
 * Created by Dan on 2/25/2016.
 */
public class LapisWool extends BaseOreWool{
    public LapisWool(Material materialIn) {
        super(materialIn);

        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setStepSound(soundTypeCloth);
    }
}
