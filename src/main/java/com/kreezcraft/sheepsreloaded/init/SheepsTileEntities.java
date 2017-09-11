package com.kreezcraft.sheepsreloaded.init;

import com.kreezcraft.sheepsreloaded.tileentities.TileEntitySeparator;
import com.kreezcraft.sheepsreloaded.utility.Names;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Dan on 3/2/2016.
 */
public class SheepsTileEntities
{
    public static void init() {
        GameRegistry.registerTileEntity(TileEntitySeparator.class, Names.TileEntities.SEPARATOR);
    }
}
