package com.zulucap.sheeeps;

/**
 * Created by Dan on 2/25/2016.
 */

import com.zulucap.sheeeps.configuration.ConfigurationHandler;
import com.zulucap.sheeeps.configuration.ConfigurationReference;
import com.zulucap.sheeeps.entities.EntityOreSheep;
import com.zulucap.sheeeps.events.EventHandlerCommon;
import com.zulucap.sheeeps.gui.GuiHandler;
import com.zulucap.sheeeps.gui.GuiHandlerRegistry;
import com.zulucap.sheeeps.init.*;
import com.zulucap.sheeeps.network.DescriptionHandler;
import com.zulucap.sheeeps.network.NetworkHandler;
import com.zulucap.sheeeps.proxy.CommonProxy;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;


@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Sheeeps {
    @Instance
    public static Sheeeps instance = new Sheeeps();

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final SheeepsTab tabSheeeps = new SheeepsTab("tabSheeeps");

    @EventHandler
    public void preInit(FMLPreInitializationEvent e){

        ConfigurationHandler.init(e.getSuggestedConfigurationFile());

        SheeepsBlocks.init();
        SheeepsBlocks.register();

        SheeepsItems.init();
        SheeepsItems.register();

        SheeepsTileEntities.init();

        int modEntityID = 0;
        EntityRegistry.registerModEntity(EntityOreSheep.class, "OreSheeep", ++modEntityID , Sheeeps.instance, 80, 3, false);

        proxy.preInit();

        NetworkHandler.init();
        DescriptionHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(Sheeeps.instance, GuiHandlerRegistry.getInstance());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandler(), GuiHandler.GuiIDs.SEPARATOR.ordinal());
    }

    @EventHandler
    public void init(FMLInitializationEvent e){

        proxy.init();

        SheeepsRecipes.register();
        addWorldGen();

        proxy.registerRenders();

        // Subscribe Events
        EventHandlerCommon handler = new EventHandlerCommon();
        MinecraftForge.EVENT_BUS.register(handler);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit();
    }

    public void addWorldGen(){
        // entity spawning
        EntityRegistry.addSpawn(EntityOreSheep.class, ConfigurationReference.getSheepRarity(), 1, 1, EnumCreatureType.MONSTER,
                BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.forest,
                BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains,
                BiomeGenBase.iceMountains, BiomeGenBase.forestHills, BiomeGenBase.taigaHills,
                BiomeGenBase.extremeHillsEdge, BiomeGenBase.jungle, BiomeGenBase.jungleHills,
                BiomeGenBase.jungleEdge, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
                BiomeGenBase.roofedForest, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills,
                BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.extremeHillsPlus,
                BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.hell
        );
    }

}
