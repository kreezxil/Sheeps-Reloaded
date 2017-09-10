package com.zulucap.sheeeps;

import com.zulucap.sheeeps.init.SheeepsBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Dan on 2/25/2016.
 */
public class SheeepsTab extends CreativeTabs {

    public SheeepsTab(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(SheeepsBlocks.diamond_wool);
    }
}
