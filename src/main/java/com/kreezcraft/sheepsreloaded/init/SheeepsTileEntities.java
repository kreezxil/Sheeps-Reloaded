package com.zulucap.sheeeps.init;

import com.zulucap.sheeeps.tileentities.TileEntitySeparator;
import com.zulucap.sheeeps.utility.Names;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Dan on 3/2/2016.
 */
public class SheeepsTileEntities
{
    public static void init() {
        GameRegistry.registerTileEntity(TileEntitySeparator.class, Names.TileEntities.SEPARATOR);
    }
}
