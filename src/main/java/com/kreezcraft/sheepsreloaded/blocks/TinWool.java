package com.kreezcraft.sheepsreloaded.blocks;

import net.minecraft.block.material.Material;

/**
 * Created by Dan on 2/25/2016.
 */
public class TinWool extends BaseOreWool{
    public TinWool(Material materialIn) {
        super(materialIn);

        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setStepSound(soundTypeCloth);
    }
}
