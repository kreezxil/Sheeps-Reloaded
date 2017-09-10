package com.zulucap.sheeeps.configuration;

import net.minecraft.world.biome.BiomeGenBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dan on 3/9/2016.
 */
public class ConfigurationReference {
    private static int sheepDensity;
    private static int sheepRarity;
    private static List<SheepConfig> sheepConfigs = new ArrayList<SheepConfig>();

    public static int getSheepDensity(){
        return sheepDensity;
    }

    public static void setSheepDensity(int configSheepDensity){
        sheepDensity = configSheepDensity;
    }

    public static int getSheepRarity(){
        return sheepRarity;
    }

    public static void setSheepRarity(int configSheepRarity){
        sheepRarity = configSheepRarity;
    }

    public static List<SheepConfig> getConfiguredSheep(){
        return sheepConfigs;
    }

    public static void registerSheep(SheepConfig sheep){
        sheepConfigs.add(sheep);
    }

}
