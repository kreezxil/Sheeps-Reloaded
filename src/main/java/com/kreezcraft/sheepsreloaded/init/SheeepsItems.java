package com.kreezcraft.sheepsreloaded.init;

import com.kreezcraft.sheepsreloaded.Sheeeps;
import com.kreezcraft.sheepsreloaded.Reference;
import com.kreezcraft.sheepsreloaded.items.fleece.*;
import com.kreezcraft.sheepsreloaded.items.residue.*;
import com.kreezcraft.sheepsreloaded.items.spawnEgg.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Dan on 2/25/2016.
 */
public class SheeepsItems {

    /* Fleece - Vanilla */
    public static Item iron_fleece;
    public static Item diamond_fleece;
    public static Item coal_fleece;
    public static Item emerald_fleece;
    public static Item gold_fleece;
    public static Item glowstone_fleece;
    public static Item redstone_fleece;
    public static Item lapis_fleece;

    /* Fleece - Mod */
    public static Item copper_fleece;
    public static Item tin_fleece;
    public static Item nickel_fleece;
    public static Item lead_fleece;
    public static Item silver_fleece;
    public static Item platinum_fleece;
    public static Item ardite_fleece;
    public static Item cobalt_fleece;

    /* Residue - Vanilla */
    public static Item iron_residue;
    public static Item diamond_residue;
    public static Item coal_residue;
    public static Item emerald_residue;
    public static Item gold_residue;
    public static Item glowstone_residue;
    public static Item redstone_residue;
    public static Item lapis_residue;

    /* Residue - Mod */
    public static Item copper_residue;
    public static Item tin_residue;
    public static Item nickel_residue;
    public static Item lead_residue;
    public static Item silver_residue;
    public static Item platinum_residue;
    public static Item ardite_residue;
    public static Item cobalt_residue;

    /* Spawn Eggs - Vanilla */
    public static Item iron_spawn_egg;
    public static Item diamond_spawn_egg;
    public static Item coal_spawn_egg;
    public static Item emerald_spawn_egg;
    public static Item gold_spawn_egg;
    public static Item glowstone_spawn_egg;
    public static Item redstone_spawn_egg;
    public static Item lapis_spawn_egg;

    /* Spawn Eggs - Mod */
    public static Item copper_spawn_egg;
    public static Item tin_spawn_egg;
    public static Item nickel_spawn_egg;
    public static Item lead_spawn_egg;
    public static Item silver_spawn_egg;
    public static Item platinum_spawn_egg;
    public static Item ardite_spawn_egg;
    public static Item cobalt_spawn_egg;

    public static void init(){
        /* Fleece - Vanilla */
        iron_fleece = new IronFleece().setUnlocalizedName("iron_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        diamond_fleece = new DiamondFleece().setUnlocalizedName("diamond_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        coal_fleece = new CoalFleece().setUnlocalizedName("coal_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        emerald_fleece = new EmeraldFleece().setUnlocalizedName("emerald_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        gold_fleece = new GoldFleece().setUnlocalizedName("gold_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        glowstone_fleece = new GlowstoneFleece().setUnlocalizedName("glowstone_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        redstone_fleece = new RedstoneFleece().setUnlocalizedName("redstone_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        lapis_fleece = new LapisFleece().setUnlocalizedName("lapis_fleece").setCreativeTab(Sheeeps.tabSheeeps);

        /* Fleece - Mod */
        copper_fleece = new CopperFleece().setUnlocalizedName("copper_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        tin_fleece = new TinFleece().setUnlocalizedName("tin_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        nickel_fleece = new NickelFleece().setUnlocalizedName("nickel_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        lead_fleece = new LeadFleece().setUnlocalizedName("lead_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        silver_fleece = new SilverFleece().setUnlocalizedName("silver_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        platinum_fleece = new PlatinumFleece().setUnlocalizedName("platinum_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        ardite_fleece = new ArditeFleece().setUnlocalizedName("ardite_fleece").setCreativeTab(Sheeeps.tabSheeeps);
        cobalt_fleece = new CobaltFleece().setUnlocalizedName("cobalt_fleece").setCreativeTab(Sheeeps.tabSheeeps);

        /* Residue - Vanilla */
        iron_residue = new IronResidue().setUnlocalizedName("iron_residue").setCreativeTab(Sheeeps.tabSheeeps);
        diamond_residue = new DiamondResidue().setUnlocalizedName("diamond_residue").setCreativeTab(Sheeeps.tabSheeeps);
        coal_residue = new CoalResidue().setUnlocalizedName("coal_residue").setCreativeTab(Sheeeps.tabSheeeps);
        emerald_residue = new EmeraldResidue().setUnlocalizedName("emerald_residue").setCreativeTab(Sheeeps.tabSheeeps);
        gold_residue = new GoldResidue().setUnlocalizedName("gold_residue").setCreativeTab(Sheeeps.tabSheeeps);
        glowstone_residue = new GlowstoneResidue().setUnlocalizedName("glowstone_residue").setCreativeTab(Sheeeps.tabSheeeps);
        redstone_residue = new RedstoneResidue().setUnlocalizedName("redstone_residue").setCreativeTab(Sheeeps.tabSheeeps);
        lapis_residue = new LapisResidue().setUnlocalizedName("lapis_residue").setCreativeTab(Sheeeps.tabSheeeps);

        /* Residue - Mod */
        copper_residue = new CopperResidue().setUnlocalizedName("copper_residue").setCreativeTab(Sheeeps.tabSheeeps);
        tin_residue = new TinResidue().setUnlocalizedName("tin_residue").setCreativeTab(Sheeeps.tabSheeeps);
        nickel_residue = new NickelResidue().setUnlocalizedName("nickel_residue").setCreativeTab(Sheeeps.tabSheeeps);
        lead_residue = new LeadResidue().setUnlocalizedName("lead_residue").setCreativeTab(Sheeeps.tabSheeeps);
        silver_residue = new SilverResidue().setUnlocalizedName("silver_residue").setCreativeTab(Sheeeps.tabSheeeps);
        platinum_residue = new PlatinumResidue().setUnlocalizedName("platinum_residue").setCreativeTab(Sheeeps.tabSheeeps);
        ardite_residue = new ArditeResidue().setUnlocalizedName("ardite_residue").setCreativeTab(Sheeeps.tabSheeeps);
        cobalt_residue = new CobaltResidue().setUnlocalizedName("cobalt_residue").setCreativeTab(Sheeeps.tabSheeeps);

        /* Spawn Eggs - Vanilla */
        iron_spawn_egg = new IronSpawnEgg().setUnlocalizedName("iron_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        diamond_spawn_egg = new DiamondSpawnEgg().setUnlocalizedName("diamond_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        coal_spawn_egg = new CoalSpawnEgg().setUnlocalizedName("coal_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        emerald_spawn_egg = new EmeraldSpawnEgg().setUnlocalizedName("emerald_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        gold_spawn_egg = new GoldSpawnEgg().setUnlocalizedName("gold_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        glowstone_spawn_egg = new GlowstoneSpawnEgg().setUnlocalizedName("glowstone_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        redstone_spawn_egg = new RedstoneSpawnEgg().setUnlocalizedName("redstone_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        lapis_spawn_egg = new LapisSpawnEgg().setUnlocalizedName("lapis_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);

        /* Spawn Eggs - Mod */
        copper_spawn_egg = new CopperSpawnEgg().setUnlocalizedName("copper_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        tin_spawn_egg = new TinSpawnEgg().setUnlocalizedName("tin_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        nickel_spawn_egg = new NickelSpawnEgg().setUnlocalizedName("nickel_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        lead_spawn_egg = new LeadSpawnEgg().setUnlocalizedName("lead_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        silver_spawn_egg = new SilverSpawnEgg().setUnlocalizedName("silver_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        platinum_spawn_egg = new PlatinumSpawnEgg().setUnlocalizedName("platinum_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        ardite_spawn_egg = new ArditeSpawnEgg().setUnlocalizedName("ardite_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
        cobalt_spawn_egg = new CobaltSpawnEgg().setUnlocalizedName("cobalt_spawn_egg").setCreativeTab(Sheeeps.tabSheeeps);
    }

    public static void register(){
        /* Fleece - Vanilla */
        GameRegistry.registerItem(iron_fleece, iron_fleece.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(diamond_fleece, diamond_fleece.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(coal_fleece, coal_fleece.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(emerald_fleece, emerald_fleece.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(gold_fleece, gold_fleece.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(glowstone_fleece, glowstone_fleece.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(redstone_fleece, redstone_fleece.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(lapis_fleece, lapis_fleece.getUnlocalizedName().substring(5));

        /* Residue - Vanilla */
        GameRegistry.registerItem(iron_residue, iron_residue.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(diamond_residue, diamond_residue.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(coal_residue, coal_residue.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(emerald_residue, emerald_residue.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(gold_residue, gold_residue.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(glowstone_residue, glowstone_residue.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(redstone_residue, redstone_residue.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(lapis_residue, lapis_residue.getUnlocalizedName().substring(5));

        /* Spawn Eggs - Vanilla */
        GameRegistry.registerItem(iron_spawn_egg, iron_spawn_egg.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(diamond_spawn_egg, diamond_spawn_egg.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(coal_spawn_egg, coal_spawn_egg.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(emerald_spawn_egg, emerald_spawn_egg.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(gold_spawn_egg, gold_spawn_egg.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(glowstone_spawn_egg, glowstone_spawn_egg.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(redstone_spawn_egg, redstone_spawn_egg.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(lapis_spawn_egg, lapis_spawn_egg.getUnlocalizedName().substring(5));

    }

    public static void modRegister(){
        /* Register Items */
        if(OreDictionary.getOres("ingotCopper").size() > 0) {
            GameRegistry.registerItem(copper_fleece, copper_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(copper_residue, copper_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(copper_spawn_egg, copper_spawn_egg.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotTin").size() > 0) {
            GameRegistry.registerItem(tin_fleece, tin_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(tin_residue, tin_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(tin_spawn_egg, tin_spawn_egg.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotNickel").size() > 0) {
            GameRegistry.registerItem(nickel_fleece, nickel_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(nickel_residue, nickel_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(nickel_spawn_egg, nickel_spawn_egg.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotLead").size() > 0) {
            GameRegistry.registerItem(lead_fleece, lead_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(lead_residue, lead_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(lead_spawn_egg, lead_spawn_egg.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotSilver").size() > 0) {
            GameRegistry.registerItem(silver_fleece, silver_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(silver_residue, silver_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(silver_spawn_egg, silver_spawn_egg.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotPlatinum").size() > 0) {
            GameRegistry.registerItem(platinum_fleece, platinum_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(platinum_residue, platinum_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(platinum_spawn_egg, platinum_spawn_egg.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotArdite").size() > 0) {
            GameRegistry.registerItem(ardite_fleece, ardite_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(ardite_residue, ardite_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(ardite_spawn_egg, ardite_spawn_egg.getUnlocalizedName().substring(5));
        }
        if(OreDictionary.getOres("ingotCobalt").size() > 0) {
            GameRegistry.registerItem(cobalt_fleece, cobalt_fleece.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(cobalt_residue, cobalt_residue.getUnlocalizedName().substring(5));
            GameRegistry.registerItem(cobalt_spawn_egg, cobalt_spawn_egg.getUnlocalizedName().substring(5));
        }
    }

    public static void registerRenders(){
        /* Fleece - Vanilla */
        registerRender(iron_fleece);
        registerRender(diamond_fleece);
        registerRender(coal_fleece);
        registerRender(emerald_fleece);
        registerRender(gold_fleece);
        registerRender(glowstone_fleece);
        registerRender(redstone_fleece);
        registerRender(lapis_fleece);

        /* Residue - Vanilla */
        registerRender(iron_residue);
        registerRender(diamond_residue);
        registerRender(coal_residue);
        registerRender(emerald_residue);
        registerRender(gold_residue);
        registerRender(glowstone_residue);
        registerRender(redstone_residue);
        registerRender(lapis_residue);

        /* Spawn Eggs - Vanilla */
        registerRender(iron_spawn_egg);
        registerRender(diamond_spawn_egg);
        registerRender(coal_spawn_egg);
        registerRender(emerald_spawn_egg);
        registerRender(gold_spawn_egg);
        registerRender(glowstone_spawn_egg);
        registerRender(redstone_spawn_egg);
        registerRender(lapis_spawn_egg);
    }

    public static void modRegisterRenders() {
        if(OreDictionary.getOres("ingotCopper").size() > 0) {
            registerRender(copper_fleece);
            registerRender(copper_residue);
            registerRender(copper_spawn_egg);
        }
        if(OreDictionary.getOres("ingotTin").size() > 0) {
            registerRender(tin_fleece);
            registerRender(tin_residue);
            registerRender(tin_spawn_egg);
        }
        if(OreDictionary.getOres("ingotNickel").size() > 0) {
            registerRender(nickel_fleece);
            registerRender(nickel_residue);
            registerRender(nickel_spawn_egg);
        }
        if(OreDictionary.getOres("ingotLead").size() > 0) {
            registerRender(lead_fleece);
            registerRender(lead_residue);
            registerRender(lead_spawn_egg);
        }
        if(OreDictionary.getOres("ingotSilver").size() > 0) {
            registerRender(silver_fleece);
            registerRender(silver_residue);
            registerRender(silver_spawn_egg);
        }
        if(OreDictionary.getOres("ingotPlatinum").size() > 0) {
            registerRender(platinum_fleece);
            registerRender(platinum_residue);
            registerRender(platinum_spawn_egg);
        }
        if(OreDictionary.getOres("ingotArdite").size() > 0) {
            registerRender(ardite_fleece);
            registerRender(ardite_residue);
            registerRender(ardite_spawn_egg);
        }
        if(OreDictionary.getOres("ingotCobalt").size() > 0) {
            registerRender(cobalt_fleece);
            registerRender(cobalt_residue);
            registerRender(cobalt_spawn_egg);
        }
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
