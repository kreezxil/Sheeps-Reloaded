package com.kreezcraft.sheepsreloaded.entities;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Dan on 2/28/2016.
 */
public class SheepsEntity {
    private final int id;
    private final String entityName;
    private ItemStack dropItem;
    private final ResourceLocation shearedTexture;
    private final ResourceLocation furTexture;
    private int maxSpawnHeight;
    private int minSpawnHeight;
    private float rarity;
    private BiomeGenBase[] spawnBiomes;
    private BiomeGenBase[] excludedBiomes;

    public SheepsEntity(int id, String entityName, ItemStack dropItem, ResourceLocation shearedTexture, ResourceLocation furTexture, int maxSpawnHeight, int minSpawnHeight, float rarity, BiomeGenBase[] spawnBiomes, BiomeGenBase[] excludedBiomes){
        this.id = id;
        this.entityName = entityName;
        this.dropItem = dropItem;
        this.shearedTexture = shearedTexture;
        this.furTexture = furTexture;
        this.maxSpawnHeight = maxSpawnHeight;
        this.minSpawnHeight = minSpawnHeight;
        this.rarity = rarity;

        if(spawnBiomes != null) {
            this.spawnBiomes = spawnBiomes;
        }

        if(excludedBiomes != null) {
            this.excludedBiomes = excludedBiomes;
        }
    }

    public int getId(){
        return id;
    }

    public String getEntityName(){
        return entityName;
    }

    public ItemStack getDropItem(){
        return dropItem;
    }

    public ResourceLocation getShearedTexture(){
        return shearedTexture;
    }

    public ResourceLocation getFurTexture(){
        return furTexture;
    }

    public int getMaxSpawnHeight(){
        return maxSpawnHeight;
    }

    public int getMinSpawnHeight(){
        return minSpawnHeight;
    }

    public float getRarity(){
        return rarity;
    }

    public BiomeGenBase[] getSpawnBiomes(){
        return spawnBiomes;
    }

    public BiomeGenBase[] getExcludedBiomes() { return excludedBiomes; }

}
