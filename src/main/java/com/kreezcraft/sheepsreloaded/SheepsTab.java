package com.kreezcraft.sheepsreloaded;

import com.kreezcraft.sheepsreloaded.init.SheepsBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Dan on 2/25/2016.
 */
public class SheepsTab extends CreativeTabs {

    public SheepsTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return Item.getItemFromBlock(SheepsBlocks.diamond_wool);
    }
}
