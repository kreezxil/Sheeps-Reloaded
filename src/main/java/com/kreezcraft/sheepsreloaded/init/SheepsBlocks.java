package com.kreezcraft.sheepsreloaded.init;

import com.kreezcraft.sheepsreloaded.Reference;
import com.kreezcraft.sheepsreloaded.SheepsReloaded;
import com.kreezcraft.sheepsreloaded.SheepsTab;
import com.kreezcraft.sheepsreloaded.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Dan on 2/25/2016.
 */
public class SheepsBlocks {
    // Vanilla Ores
    public static Block iron_wool;
    public static Block diamond_wool;
    public static Block coal_wool;
    public static Block emerald_wool;
    public static Block gold_wool;
    public static Block glowstone_wool;
    public static Block redstone_wool;
    public static Block lapis_wool;

    // Mod Ores
    public static Block copper_wool;
    public static Block tin_wool;
    public static Block nickel_wool;
    public static Block lead_wool;
    public static Block silver_wool;
    public static Block platinum_wool;
    public static Block ardite_wool;
    public static Block cobalt_wool;

    public static Block washer;
    public static Block separator;
    public static Block separator_on_1;
    public static Block separator_on_2;

    public static void init(){
        // Vanilla Ores
        iron_wool = new OreWool("iron_wool");
        diamond_wool = new OreWool("diamond_wool");
        coal_wool = new OreWool("coal_wool");
        emerald_wool = new OreWool("emerald_wool");
        gold_wool = new OreWool("gold_wool");
        glowstone_wool = new OreWool("glowstone_wool").setLightLevel(15f);
        redstone_wool = new OreWool("redstone_wool").setLightLevel(7f);
        lapis_wool = new OreWool("lapis_wool");

        // Mod Ores
        copper_wool = new OreWool("copper_wool");
        tin_wool = new OreWool("tin_wool");
        nickel_wool = new OreWool("nickel_wool");
        lead_wool = new OreWool("lead_wool");
        silver_wool = new OreWool("silver_wool");
        platinum_wool = new OreWool("platinum_wool");
        ardite_wool = new OreWool("ardite_wool");
        cobalt_wool = new OreWool("cobalt_wool");

        washer = new Washer(Material.wood).setUnlocalizedName("washer").setCreativeTab(Sheeps.tabSheeps);
        separator = new Separator().setUnlocalizedName("separator").setCreativeTab(Sheeps.tabSheeps);

        separator_on_1 = new Separator().setUnlocalizedName("separator_on_1");
        separator_on_2 = new Separator().setUnlocalizedName("separator_on_2");
    }

    public static void register(){
        // Vanilla Ores
        GameRegistry.registerBlock(iron_wool, iron_wool.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(diamond_wool, diamond_wool.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(coal_wool, coal_wool.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(emerald_wool, emerald_wool.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(gold_wool, gold_wool.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(glowstone_wool, glowstone_wool.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(redstone_wool, redstone_wool.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(lapis_wool, lapis_wool.getUnlocalizedName().substring(5));

        GameRegistry.registerBlock(washer, washer.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(separator, separator.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(separator_on_1, separator_on_1.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(separator_on_2, separator_on_2.getUnlocalizedName().substring(5));

    }

    public static void modRegister(){
        // Register Ores & Renders
        // If they have been added to the ore dictionary
        if(OreDictionary.getOres("ingotCopper").size() > 0) {
            GameRegistry.registerBlock(copper_wool, copper_wool.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotTin").size() > 0) {
            GameRegistry.registerBlock(tin_wool, tin_wool.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotNickel").size() > 0) {
            GameRegistry.registerBlock(nickel_wool, nickel_wool.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotLead").size() > 0) {
            GameRegistry.registerBlock(lead_wool, lead_wool.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotSilver").size() > 0) {
            GameRegistry.registerBlock(silver_wool, silver_wool.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotPlatinum").size() > 0) {
            GameRegistry.registerBlock(platinum_wool, platinum_wool.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotArdite").size() > 0) {
            GameRegistry.registerBlock(ardite_wool, ardite_wool.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotCobalt").size() > 0) {
            GameRegistry.registerBlock(cobalt_wool, cobalt_wool.getUnlocalizedName().substring(5));
        }
    }

    public static void registerRenders(){
        // Vanilla Ores
        registerRender(iron_wool);
        registerRender(diamond_wool);
        registerRender(coal_wool);
        registerRender(emerald_wool);
        registerRender(gold_wool);
        registerRender(glowstone_wool);
        registerRender(redstone_wool);
        registerRender(lapis_wool);

        registerRender(washer);
        registerRender(separator);
        registerRender(separator_on_1);
        registerRender(separator_on_2);
    }

    public static void modRegisterRenders(){
        // Register Ores & Renders
        // If they have been added to the ore dictionary
        if(OreDictionary.getOres("ingotCopper").size() > 0) {
            registerRender(copper_wool);
        }
        if(OreDictionary.getOres("ingotTin").size() > 0) {
            registerRender(tin_wool);
        }
        if(OreDictionary.getOres("ingotNickel").size() > 0) {
            registerRender(nickel_wool);
        }
        if(OreDictionary.getOres("ingotLead").size() > 0) {
            registerRender(lead_wool);
        }
        if(OreDictionary.getOres("ingotSilver").size() > 0) {
            registerRender(silver_wool);
        }
        if(OreDictionary.getOres("ingotPlatinum").size() > 0) {
            registerRender(platinum_wool);
        }
        if(OreDictionary.getOres("ingotArdite").size() > 0) {
            registerRender(ardite_wool);
        }
        if(OreDictionary.getOres("ingotCobalt").size() > 0) {
            registerRender(cobalt_wool);
        }
    }

    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
