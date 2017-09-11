package com.kreezcraft.sheepsreloaded.init;

import com.kreezcraft.sheepsreloaded.Sheeeps;
import com.kreezcraft.sheepsreloaded.Reference;
import com.kreezcraft.sheepsreloaded.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Dan on 2/25/2016.
 */
public class SheeepsBlocks {
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
        iron_wool = new IronWool(Material.cloth).setUnlocalizedName("iron_wool").setCreativeTab(Sheeeps.tabSheeeps);
        diamond_wool = new DiamondWool(Material.cloth).setUnlocalizedName("diamond_wool").setCreativeTab(Sheeeps.tabSheeeps);
        coal_wool = new CoalWool(Material.cloth).setUnlocalizedName("coal_wool").setCreativeTab(Sheeeps.tabSheeeps);
        emerald_wool = new EmeraldWool(Material.cloth).setUnlocalizedName("emerald_wool").setCreativeTab(Sheeeps.tabSheeeps);
        gold_wool = new GoldWool(Material.cloth).setUnlocalizedName("gold_wool").setCreativeTab(Sheeeps.tabSheeeps);
        glowstone_wool = new GlowstoneWool(Material.cloth).setUnlocalizedName("glowstone_wool").setCreativeTab(Sheeeps.tabSheeeps);
        redstone_wool = new RedstoneWool(Material.cloth).setUnlocalizedName("redstone_wool").setCreativeTab(Sheeeps.tabSheeeps);
        lapis_wool = new LapisWool(Material.cloth).setUnlocalizedName("lapis_wool").setCreativeTab(Sheeeps.tabSheeeps);

        // Mod Ores
        copper_wool = new CopperWool(Material.cloth).setUnlocalizedName("copper_wool").setCreativeTab(Sheeeps.tabSheeeps);
        tin_wool = new TinWool(Material.cloth).setUnlocalizedName("tin_wool").setCreativeTab(Sheeeps.tabSheeeps);
        nickel_wool = new NickelWool(Material.cloth).setUnlocalizedName("nickel_wool").setCreativeTab(Sheeeps.tabSheeeps);
        lead_wool = new LeadWool(Material.cloth).setUnlocalizedName("lead_wool").setCreativeTab(Sheeeps.tabSheeeps);
        silver_wool = new SilverWool(Material.cloth).setUnlocalizedName("silver_wool").setCreativeTab(Sheeeps.tabSheeeps);
        platinum_wool = new PlatinumWool(Material.cloth).setUnlocalizedName("platinum_wool").setCreativeTab(Sheeeps.tabSheeeps);
        ardite_wool = new ArditeWool(Material.cloth).setUnlocalizedName("ardite_wool").setCreativeTab(Sheeeps.tabSheeeps);
        cobalt_wool = new CobaltWool(Material.cloth).setUnlocalizedName("cobalt_wool").setCreativeTab(Sheeeps.tabSheeeps);

        washer = new Washer(Material.wood).setUnlocalizedName("washer").setCreativeTab(Sheeeps.tabSheeeps);
        separator = new Separator().setUnlocalizedName("separator").setCreativeTab(Sheeeps.tabSheeeps);

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
