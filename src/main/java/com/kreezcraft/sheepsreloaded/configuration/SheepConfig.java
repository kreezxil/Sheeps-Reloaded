package com.zulucap.sheeeps.configuration;

/**
 * Created by Dan on 3/10/2016.
 */
public class SheepConfig {
    private boolean sheepDisabled;
    private int minSpawnHeight;
    private int maxSpawnHeight;
    private Float rarity;

    public void setSheepDisabled(boolean configDisabled){
        sheepDisabled = configDisabled;
    }

    public boolean getSheepDisabled(){
        return sheepDisabled;
    }

    public void setMinSpawnHeight(int configMinSpawnHeight){
        minSpawnHeight = configMinSpawnHeight;
    }

    public int getMinSpawnHeight(){
        return minSpawnHeight;
    }

    public void setMaxSpawnHeight(int configMaxSpawnHeight){
        maxSpawnHeight = configMaxSpawnHeight;
    }

    public int getMaxSpawnHeight(){
        return maxSpawnHeight;
    }

    public void setRarity(float configRarity){
        rarity = configRarity;
    }

    public float getRarity(){
        return rarity;
    }
}
