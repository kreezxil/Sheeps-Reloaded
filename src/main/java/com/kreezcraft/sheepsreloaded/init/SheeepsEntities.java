package com.kreezcraft.sheepsreloaded.init;

import com.kreezcraft.sheepsreloaded.Reference;
import com.kreezcraft.sheepsreloaded.configuration.ConfigurationReference;
import com.kreezcraft.sheepsreloaded.configuration.SheepConfig;
import com.kreezcraft.sheepsreloaded.entities.SheeepsEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

/**
 * Created by Dan on 2/28/2016.
 */
public class SheeepsEntities {

    private static final Map<Integer, SheeepsEntity> sheeeps = new HashMap<Integer, SheeepsEntity>();
    private static int modEntityID = 0;

    public static void register(SheeepsEntity entity){
        sheeeps.put(entity.getId(), entity);
    }

    public static SheeepsEntity getByType(int type){
        return sheeeps.get(type);
    }

    public static Collection<SheeepsEntity> getItems(){
        return sheeeps.values();
    }

    public static void registerRenders(){
        // not used
    }

    public static void registerSheeep(){

        List<SheepConfig> configuredSheep = ConfigurationReference.getConfiguredSheep();

        // Vanilla Ore Sheep
        SheepConfig coalConfig = configuredSheep.get(0);
        if(!coalConfig.getSheepDisabled()) {
            SheeepsEntity coalOreSheeep = new SheeepsEntity(0, "Coal Ore Sheeep", new ItemStack(SheeepsItems.coal_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/coal_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/coal_ore_sheep_fur.png"),
                    coalConfig.getMaxSpawnHeight(),
                    coalConfig.getMinSpawnHeight(),
                    coalConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(coalOreSheeep);
        }

        SheepConfig ironConfig = configuredSheep.get(1);
        if(!ironConfig.getSheepDisabled()) {
            SheeepsEntity ironOreSheeep = new SheeepsEntity(1, "Iron Ore Sheeep", new ItemStack(SheeepsItems.iron_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/iron_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/iron_ore_sheep_fur.png"),
                    ironConfig.getMaxSpawnHeight(),
                    ironConfig.getMinSpawnHeight(),
                    ironConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(ironOreSheeep);
        }

        SheepConfig goldConfig = configuredSheep.get(2);
        if(!goldConfig.getSheepDisabled()) {
            SheeepsEntity goldOreSheeep = new SheeepsEntity(2, "Gold Ore Sheeep", new ItemStack(SheeepsItems.gold_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/gold_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/gold_ore_sheep_fur.png"),
                    goldConfig.getMaxSpawnHeight(),
                    goldConfig.getMinSpawnHeight(),
                    goldConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(goldOreSheeep);
        }

        SheepConfig redstoneConfig = configuredSheep.get(3);
        if(!redstoneConfig.getSheepDisabled()) {
            SheeepsEntity redstoneOreSheeep = new SheeepsEntity(3, "Redstone Ore Sheeep", new ItemStack(SheeepsItems.redstone_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/redstone_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/redstone_ore_sheep_fur.png"),
                    redstoneConfig.getMaxSpawnHeight(),
                    redstoneConfig.getMinSpawnHeight(),
                    redstoneConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(redstoneOreSheeep);
        }

        SheepConfig lapisConfig = configuredSheep.get(4);
        if(!lapisConfig.getSheepDisabled()) {
            SheeepsEntity lapisOreSheeep = new SheeepsEntity(4, "Lapis Ore Sheeep", new ItemStack(SheeepsItems.lapis_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/lapis_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/lapis_ore_sheep_fur.png"),
                    lapisConfig.getMaxSpawnHeight(),
                    lapisConfig.getMinSpawnHeight(),
                    lapisConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(lapisOreSheeep);
        }

        SheepConfig glowstoneConfig = configuredSheep.get(5);
        if(!glowstoneConfig.getSheepDisabled()) {
            SheeepsEntity glowstoneOreSheeep = new SheeepsEntity(5, "Glowstone Ore Sheeep", new ItemStack(SheeepsItems.glowstone_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/glowstone_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/glowstone_ore_sheep_fur.png"),
                    glowstoneConfig.getMaxSpawnHeight(),
                    glowstoneConfig.getMinSpawnHeight(),
                    glowstoneConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.hell}, null);
            SheeepsEntities.register(glowstoneOreSheeep);
        }

        SheepConfig diamondConfig = configuredSheep.get(6);
        if(!diamondConfig.getSheepDisabled()) {
            SheeepsEntity diamondOreSheeep = new SheeepsEntity(6, "Diamond Ore Sheeep", new ItemStack(SheeepsItems.diamond_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/diamond_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/diamond_ore_sheep_fur.png"),
                    diamondConfig.getMaxSpawnHeight(),
                    diamondConfig.getMinSpawnHeight(),
                    diamondConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(diamondOreSheeep);
        }

        SheepConfig emeraldConfig = configuredSheep.get(7);
        if(!emeraldConfig.getSheepDisabled()) {
            SheeepsEntity emeraldOreSheeep = new SheeepsEntity(7, "Emerald Ore Sheeep", new ItemStack(SheeepsItems.emerald_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/emerald_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/emerald_ore_sheep_fur.png"),
                    emeraldConfig.getMaxSpawnHeight(),
                    emeraldConfig.getMinSpawnHeight(),
                    emeraldConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus},
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(emeraldOreSheeep);
        }
    }

    public static void registerModSheeep(){
        List<SheepConfig> configuredSheep = ConfigurationReference.getConfiguredSheep();

        // Mod Ore Sheep
        SheepConfig copperConfig = configuredSheep.get(8);
        if(!copperConfig.getSheepDisabled() && OreDictionary.getOres("ingotCopper").size() > 0) {
            SheeepsEntity copperOreSheeep = new SheeepsEntity(8, "Copper Ore Sheeep", new ItemStack(SheeepsItems.copper_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/copper_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/copper_ore_sheep_fur.png"),
                    copperConfig.getMaxSpawnHeight(),
                    copperConfig.getMinSpawnHeight(),
                    copperConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(copperOreSheeep);
        }

        SheepConfig tinConfig = configuredSheep.get(9);
        if(!tinConfig.getSheepDisabled() && OreDictionary.getOres("ingotTin").size() > 0) {
            SheeepsEntity tinOreSheeep = new SheeepsEntity(9, "Tin Ore Sheeep", new ItemStack(SheeepsItems.tin_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/tin_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/tin_ore_sheep_fur.png"),
                    tinConfig.getMaxSpawnHeight(),
                    tinConfig.getMinSpawnHeight(),
                    tinConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(tinOreSheeep);
        }

        SheepConfig nickelConfig = configuredSheep.get(10);
        if(!nickelConfig.getSheepDisabled() && OreDictionary.getOres("ingotNickel").size() > 0) {
            SheeepsEntity nickelOreSheeep = new SheeepsEntity(10, "Nickel Ore Sheeep", new ItemStack(SheeepsItems.nickel_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/nickel_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/nickel_ore_sheep_fur.png"),
                    nickelConfig.getMaxSpawnHeight(),
                    nickelConfig.getMinSpawnHeight(),
                    nickelConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(nickelOreSheeep);
        }

        SheepConfig leadConfig = configuredSheep.get(11);
        if(!leadConfig.getSheepDisabled() && OreDictionary.getOres("ingotLead").size() > 0) {
            SheeepsEntity leadOreSheeep = new SheeepsEntity(11, "Lead Ore Sheeep", new ItemStack(SheeepsItems.lead_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/lead_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/lead_ore_sheep_fur.png"),
                    leadConfig.getMaxSpawnHeight(),
                    leadConfig.getMinSpawnHeight(),
                    leadConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(leadOreSheeep);
        }

        SheepConfig silverConfig = configuredSheep.get(12);
        if(!silverConfig.getSheepDisabled() && OreDictionary.getOres("ingotSilver").size() > 0) {
            SheeepsEntity silverOreSheeep = new SheeepsEntity(12, "Silver Ore Sheeep", new ItemStack(SheeepsItems.silver_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/silver_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/silver_ore_sheep_fur.png"),
                    silverConfig.getMaxSpawnHeight(),
                    silverConfig.getMinSpawnHeight(),
                    silverConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(silverOreSheeep);
        }

        SheepConfig platinumConfig = configuredSheep.get(13);
        if(!platinumConfig.getSheepDisabled() && OreDictionary.getOres("ingotPlatinum").size() > 0) {
            SheeepsEntity platinumOreSheeep = new SheeepsEntity(13, "Platinum Ore Sheeep", new ItemStack(SheeepsItems.platinum_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/platinum_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/platinum_ore_sheep_fur.png"),
                    platinumConfig.getMaxSpawnHeight(),
                    platinumConfig.getMinSpawnHeight(),
                    platinumConfig.getRarity(),
                    null,
                    new BiomeGenBase[]{BiomeGenBase.hell});
            SheeepsEntities.register(platinumOreSheeep);
        }

        SheepConfig arditeConfig = configuredSheep.get(14);
        if(!arditeConfig.getSheepDisabled() && OreDictionary.getOres("ingotArdite").size() > 0) {
            SheeepsEntity arditeOreSheeep = new SheeepsEntity(14, "Ardite Ore Sheeep", new ItemStack(SheeepsItems.ardite_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/ardite_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/ardite_ore_sheep_fur.png"),
                    arditeConfig.getMaxSpawnHeight(),
                    arditeConfig.getMinSpawnHeight(),
                    arditeConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.hell},
                    null);
            SheeepsEntities.register(arditeOreSheeep);
        }

        SheepConfig cobaltConfig = configuredSheep.get(15);
        if(!cobaltConfig.getSheepDisabled() && OreDictionary.getOres("ingotCobalt").size() > 0) {
            SheeepsEntity cobaltOreSheeep = new SheeepsEntity(15, "Cobalt Ore Sheeep", new ItemStack(SheeepsItems.cobalt_fleece, 1), new ResourceLocation(Reference.MODID + ":textures/entity/cobalt_ore_sheep_sheared.png"), new ResourceLocation(Reference.MODID + ":textures/entity/cobalt_ore_sheep_fur.png"),
                    cobaltConfig.getMaxSpawnHeight(),
                    cobaltConfig.getMinSpawnHeight(),
                    cobaltConfig.getRarity(),
                    new BiomeGenBase[]{BiomeGenBase.hell},
                    null
            );
            SheeepsEntities.register(cobaltOreSheeep);
        }
    }

    public static List<SheeepsEntity> getPossibleSheeeps(BiomeGenBase biome, BlockPos pos){
        List<SheeepsEntity> result = new ArrayList<SheeepsEntity>();

        int y = pos.getY();

        for(SheeepsEntity sheeep : SheeepsEntities.getItems()){
            BiomeGenBase[] spawnBiomes = sheeep.getSpawnBiomes();
            BiomeGenBase[] excludedBiomes = sheeep.getExcludedBiomes();

            if(sheeep.getMaxSpawnHeight() >= y && sheeep.getMinSpawnHeight() <= y){
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

                // Add sheeep to valid selections if valid
                if(validSpawn){
                    if(Math.random() + sheeep.getRarity() >= 1.0F) {
                        result.add(sheeep);
                    }
                }
            }
        }

        return result;
    }
}
