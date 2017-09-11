package com.kreezcraft.sheepsreloaded.blocks;

import com.kreezcraft.sheepsreloaded.SheepsReloaded;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by Dan on 2/26/2016.
 */
public class OreWool extends Block {
	
	public static String name;
	
    public OreWool(String name) {
        super(Material.CLOTH);
    	this.name = name;
    	setUnlocalizedName(name);
        setHardness(1.0F);
        setResistance(1.0F);
        setCreativeTab(SheepsReloaded.tabSheeps);
        setSoundType(SoundType.CLOTH);
    }
    
}
