package com.zulucap.sheeeps.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Dan on 3/9/2016.
 */
public class ConfigurationHandler {
    private static Configuration configuration;

    public static void init(File configFile){
        configuration = new Configuration(configFile);

        try{
            // Load the config file
            configuration.load();

            // Read in properties
            ConfigurationReference.setSheepDensity(configuration.get(Configuration.CATEGORY_GENERAL, "sheepDensity", 20, "Sets the spawn density for Sheeeps").getInt(20));
            ConfigurationReference.setSheepRarity(configuration.get(Configuration.CATEGORY_GENERAL, "sheepRarity", 5, "Sets the rarity for Sheeeps. High numbers means they will spawn more often").getInt(5));

            // Create new sheep, push to config reference sheep array

            // Vanilla Ore Sheeep
            configSheep("Coal Sheep", false, 40, 255, 10);
            configSheep("Iron Sheep", false, 40, 80, 8);
            configSheep("Gold Sheep", false, 0, 40, 6);
            configSheep("Redstone Sheep", false, 0, 40, 6);
            configSheep("Lapis Sheep", false, 0, 40, 4);
            configSheep("Glowstone Sheep", false, 0, 128, 10);
            configSheep("Diamond Sheep", false, 0, 25, 3);
            configSheep("Emerald Sheep", false, 0, 25, 4);

            // Mod Ore Sheeep
            configSheep("Copper Sheep", false, 20, 80, 7);
            configSheep("Tin Sheep", false, 20, 60, 7);
            configSheep("Nickel Sheep", false, 0, 40, 5);
            configSheep("Lead Sheep", false, 0, 40, 5);
            configSheep("Silver Sheep", false, 0, 25, 3);
            configSheep("Platinum Sheep", false, 0, 25, 2);
            configSheep("Ardite Sheep", false, 0, 64, 4);
            configSheep("Cobalt Sheep", false, 0, 64, 4);

        } catch (Exception e){
            // Log exception
            System.out.println("There was an exception: " + e.toString());
        } finally {
            // Save configuration
            configuration.save();
        }
    }

    private static void configSheep(String name, boolean disabled, int minY, int maxY, int rarity){
        SheepConfig sheep = new SheepConfig();

        sheep.setSheepDisabled(configuration.get("Config " + name, "Disabled", disabled, "Toggles the ability to spawn naturally").getBoolean());
        sheep.setMinSpawnHeight(configuration.get("Config " + name, "Min Spawn Height", minY, "Sets the minimum height this sheep will spawn").getInt());
        sheep.setMaxSpawnHeight(configuration.get("Config " + name, "Max Spawn Height", maxY, "Sets the maximum height this sheep will spawn").getInt());
        sheep.setRarity(configuration.get("Config " + name, "Rarity", rarity, "Sets the chance that this sheep has to be available to spawn. (0-10)").getInt()/10.0F);

        ConfigurationReference.registerSheep(sheep);
    }
}
