package com.kreezcraft.sheepsreloaded.init;

import com.kreezcraft.sheepsreloaded.Reference;
import com.kreezcraft.sheepsreloaded.configuration.ConfigurationReference;
import com.kreezcraft.sheepsreloaded.configuration.SheepConfig;
import com.kreezcraft.sheepsreloaded.entities.SheepsEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

/**
 * Created by Dan on 2/28/2016.
 */
public class SheepsEntities {

    private static final Map<Integer, SheepsEntity> sheeps = new HashMap<Integer, SheepsEntity>();
    private static int modEntityID = 0;

    public static void register(SheepsEntity entity){
        sheeps.put(entity.getId(), entity);
    }

    public static SheepsEntity getByType(int type){
        return sheeps.get(type);
    }

    public static Collection<SheepsEntity> getItems(){
        return sheeps.values();
    }

    public static void registerRenders(){
        // not used
    }

    public static void registerSheep(){

        List<SheepConfig> configuredSheep = ConfigurationReference.getConfiguredSheep();

        // Vanilla Ore Sheep
        SheepConfig coalConfig = configuredSheep.get(0);
        if(!coalConfig.getSheepDisabled()) {
            SheepsEntity coalOreSheep = new SheepsEntity(0, "Coal Ore Sheep", new ItemStack(SheepsItems.coal_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/coal_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/coal_ore_sheep_fur.png"),
                    coalConfig.getMaxSpawnHeight(),
                    coalConfig.getMinSpawnHeight(),
                    coalConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(coalOreSheep);
        }

        SheepConfig ironConfig = configuredSheep.get(1);
        if(!ironConfig.getSheepDisabled()) {
            SheepsEntity ironOreSheep = new SheepsEntity(1, "Iron Ore Sheep", new ItemStack(SheepsItems.iron_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/iron_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/iron_ore_sheep_fur.png"),
                    ironConfig.getMaxSpawnHeight(),
                    ironConfig.getMinSpawnHeight(),
                    ironConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(ironOreSheep);
        }

        SheepConfig goldConfig = configuredSheep.get(2);
        if(!goldConfig.getSheepDisabled()) {
            SheepsEntity goldOreSheep = new SheepsEntity(2, "Gold Ore Sheep", new ItemStack(SheepsItems.gold_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/gold_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/gold_ore_sheep_fur.png"),
                    goldConfig.getMaxSpawnHeight(),
                    goldConfig.getMinSpawnHeight(),
                    goldConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(goldOreSheep);
        }

        SheepConfig redstoneConfig = configuredSheep.get(3);
        if(!redstoneConfig.getSheepDisabled()) {
            SheepsEntity redstoneOreSheep = new SheepsEntity(3, "Redstone Ore Sheep", new ItemStack(SheepsItems.redstone_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/redstone_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/redstone_ore_sheep_fur.png"),
                    redstoneConfig.getMaxSpawnHeight(),
                    redstoneConfig.getMinSpawnHeight(),
                    redstoneConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(redstoneOreSheep);
        }

        SheepConfig lapisConfig = configuredSheep.get(4);
        if(!lapisConfig.getSheepDisabled()) {
            SheepsEntity lapisOreSheep = new SheepsEntity(4, "Lapis Ore Sheep", new ItemStack(SheepsItems.lapis_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/lapis_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/lapis_ore_sheep_fur.png"),
                    lapisConfig.getMaxSpawnHeight(),
                    lapisConfig.getMinSpawnHeight(),
                    lapisConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(lapisOreSheep);
        }

        SheepConfig glowstoneConfig = configuredSheep.get(5);
        if(!glowstoneConfig.getSheepDisabled()) {
            SheepsEntity glowstoneOreSheep = new SheepsEntity(5, "Glowstone Ore Sheep", new ItemStack(SheepsItems.glowstone_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/glowstone_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/glowstone_ore_sheep_fur.png"),
                    glowstoneConfig.getMaxSpawnHeight(),
                    glowstoneConfig.getMinSpawnHeight(),
                    glowstoneConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.hell}, null);
            SheepsEntities.register(glowstoneOreSheep);
        }

        SheepConfig diamondConfig = configuredSheep.get(6);
        if(!diamondConfig.getSheepDisabled()) {
            SheepsEntity diamondOreSheep = new SheepsEntity(6, "Diamond Ore Sheep", new ItemStack(SheepsItems.diamond_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/diamond_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/diamond_ore_sheep_fur.png"),
                    diamondConfig.getMaxSpawnHeight(),
                    diamondConfig.getMinSpawnHeight(),
                    diamondConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(diamondOreSheep);
        }

        SheepConfig emeraldConfig = configuredSheep.get(7);
        if(!emeraldConfig.getSheepDisabled()) {
            SheepsEntity emeraldOreSheep = new SheepsEntity(7, "Emerald Ore Sheep", new ItemStack(SheepsItems.emerald_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/emerald_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/emerald_ore_sheep_fur.png"),
                    emeraldConfig.getMaxSpawnHeight(),
                    emeraldConfig.getMinSpawnHeight(),
                    emeraldConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus},
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(emeraldOreSheep);
        }
    }

    public static void registerModSheep(){
        List<SheepConfig> configuredSheep = ConfigurationReference.getConfiguredSheep();

        // Mod Ore Sheep
        SheepConfig copperConfig = configuredSheep.get(8);
        if(!copperConfig.getSheepDisabled() && OreDictionary.getOres("ingotCopper").size() > 0) {
            SheepsEntity copperOreSheep = new SheepsEntity(8, "Copper Ore Sheep", new ItemStack(SheepsItems.copper_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/copper_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/copper_ore_sheep_fur.png"),
                    copperConfig.getMaxSpawnHeight(),
                    copperConfig.getMinSpawnHeight(),
                    copperConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(copperOreSheep);
        }

        SheepConfig tinConfig = configuredSheep.get(9);
        if(!tinConfig.getSheepDisabled() && OreDictionary.getOres("ingotTin").size() > 0) {
            SheepsEntity tinOreSheep = new SheepsEntity(9, "Tin Ore Sheep", new ItemStack(SheepsItems.tin_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/tin_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/tin_ore_sheep_fur.png"),
                    tinConfig.getMaxSpawnHeight(),
                    tinConfig.getMinSpawnHeight(),
                    tinConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(tinOreSheep);
        }

        SheepConfig nickelConfig = configuredSheep.get(10);
        if(!nickelConfig.getSheepDisabled() && OreDictionary.getOres("ingotNickel").size() > 0) {
            SheepsEntity nickelOreSheep = new SheepsEntity(10, "Nickel Ore Sheep", new ItemStack(SheepsItems.nickel_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/nickel_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/nickel_ore_sheep_fur.png"),
                    nickelConfig.getMaxSpawnHeight(),
                    nickelConfig.getMinSpawnHeight(),
                    nickelConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(nickelOreSheep);
        }

        SheepConfig leadConfig = configuredSheep.get(11);
        if(!leadConfig.getSheepDisabled() && OreDictionary.getOres("ingotLead").size() > 0) {
            SheepsEntity leadOreSheep = new SheepsEntity(11, "Lead Ore Sheep", new ItemStack(SheepsItems.lead_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/lead_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/lead_ore_sheep_fur.png"),
                    leadConfig.getMaxSpawnHeight(),
                    leadConfig.getMinSpawnHeight(),
                    leadConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(leadOreSheep);
        }

        SheepConfig silverConfig = configuredSheep.get(12);
        if(!silverConfig.getSheepDisabled() && OreDictionary.getOres("ingotSilver").size() > 0) {
            SheepsEntity silverOreSheep = new SheepsEntity(12, "Silver Ore Sheep", new ItemStack(SheepsItems.silver_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/silver_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/silver_ore_sheep_fur.png"),
                    silverConfig.getMaxSpawnHeight(),
                    silverConfig.getMinSpawnHeight(),
                    silverConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(silverOreSheep);
        }

        SheepConfig platinumConfig = configuredSheep.get(13);
        if(!platinumConfig.getSheepDisabled() && OreDictionary.getOres("ingotPlatinum").size() > 0) {
            SheepsEntity platinumOreSheep = new SheepsEntity(13, "Platinum Ore Sheep", new ItemStack(SheepsItems.platinum_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/platinum_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/platinum_ore_sheep_fur.png"),
                    platinumConfig.getMaxSpawnHeight(),
                    platinumConfig.getMinSpawnHeight(),
                    platinumConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheepsEntities.register(platinumOreSheep);
        }

        SheepConfig arditeConfig = configuredSheep.get(14);
        if(!arditeConfig.getSheepDisabled() && OreDictionary.getOres("ingotArdite").size() > 0) {
            SheepsEntity arditeOreSheep = new SheepsEntity(14, "Ardite Ore Sheep", new ItemStack(SheepsItems.ardite_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/ardite_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/ardite_ore_sheep_fur.png"),
                    arditeConfig.getMaxSpawnHeight(),
                    arditeConfig.getMinSpawnHeight(),
                    arditeConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.hell},
                    null);
            SheepsEntities.register(arditeOreSheep);
        }

        SheepConfig cobaltConfig = configuredSheep.get(15);
        if(!cobaltConfig.getSheepDisabled() && OreDictionary.getOres("ingotCobalt").size() > 0) {
            SheepsEntity cobaltOreSheep = new SheepsEntity(15, "Cobalt Ore Sheep", new ItemStack(SheepsItems.cobalt_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/cobalt_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/cobalt_ore_sheep_fur.png"),
                    cobaltConfig.getMaxSpawnHeight(),
                    cobaltConfig.getMinSpawnHeight(),
                    cobaltConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.hell},
                    null
            );
            SheepsEntities.register(cobaltOreSheep);
        }
    }

    public static List<SheepsEntity> getPossibleSheeps(BiomeGenBase biome, BlockPos pos){
        List<SheepsEntity> result = new ArrayList<SheepsEntity>();

        int y = pos.getY();

        for(SheepsEntity sheep : SheepsEntities.getItems()){
            BiomeGenBase[] spawnBiomes = sheep.getSpawnBiomes();
            BiomeGenBase[] excludedBiomes = sheep.getExcludedBiomes();

            if(sheep.getMaxSpawnHeight() >= y && sheep.getMinSpawnHeight() <= y){
                boolean validSpawn = false;

                // Check for valid biomes
                // Default to True is not explicitly defined
                if(spawnBiomes != null && spawnBiomes.length > 0){
                    for(BiomeGenBase spawnBiome : spawnBiomes){
                        if(spawnBiome == biome) validSpawn = true;
                    }
                } else {
                    validSpawn = true;
                }

                // Check for excluded biomes
                if(excludedBiomes != null && excludedBiomes.length > 0){
                    for(BiomeGenBase excludedBiome : excludedBiomes){
                        if(excludedBiome == biome) validSpawn = false;
                    }
                }

                // Add sheep to valid selections if valid
                if(validSpawn){
                    if(Math.random() + sheep.getRarity() >= 1.0F) {
                        result.add(sheep);
                    }
                }
            }
        }

        return result;
    }
}
