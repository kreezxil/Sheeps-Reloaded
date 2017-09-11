package com.kreezcraft.sheepsreloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Dan on 2/26/2016.
 */
public class BaseOreWool extends Block {
    public BaseOreWool(Material materialIn) {
        super(materialIn);

        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setStepSound(soundTypeCloth);
    }
}
