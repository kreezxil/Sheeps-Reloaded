package com.kreezcraft.sheepsreloaded.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

/**
 * Created by Dan on 3/5/2016.
 */
public class SheeepsRecipes {

    public static void init(){}

    public static void register(){
        //addWoolRecipes();     // Possible Easy mode?
        addMachineRecipes();
        addFurnaceRecipes();
    }

    public static void addWoolRecipes(){
        //Iron Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.iron_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.iron_fleece
        });

        //Diamond Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.diamond_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.diamond_fleece
        });

        //Coal Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.coal_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.coal_fleece
        });

        //Emerald Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.emerald_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.emerald_fleece
        });

        //Gold Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.gold_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.gold_fleece
        });

        //Glowstone Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.glowstone_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.glowstone_fleece
        });

        //Redstone Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.redstone_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.redstone_fleece
        });

        //Lapis Wool
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.lapis_wool), new Object[]{
                "FF",
                "FF",
                    'F', SheeepsItems.lapis_fleece
        });
    }

    public static void addMachineRecipes(){
        // Separator
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.separator), new Object[]{
                "CCC",
                "CFC",
                "SIS",
                'C', Blocks.cobblestone,
                'F', Blocks.furnace,
                'S', Blocks.stone_slab,
                'I', Items.iron_ingot
        });

        // Washer
        GameRegistry.addRecipe(new ItemStack(SheeepsBlocks.washer), new Object[]{
                "PBP",
                "PLP",
                "S.S",
                'P', Blocks.planks,
                'B', Items.bucket,
                'L', Blocks.wooden_slab,
                'S', Items.stick
        });
    }

    public static void addFurnaceRecipes(){
        // Use coal fleece as fuel
        IFuelHandler coalFleeceFuelHandler = new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel) {
                final int BURN_TIME_SECONDS = 20;
                final int TICKS_PER_SECOND = 20;
                if (fuel != null && fuel.getItem() == SheeepsItems.coal_fleece) {
                    return BURN_TIME_SECONDS * TICKS_PER_SECOND;
                } else {
                    return 0;
                }
            }
        };
        GameRegistry.registerFuelHandler(coalFleeceFuelHandler);

        final float WOOL_SMELT_XP = 0.0F;   // negative XP would probably cause a problem :)

        // Vanilla Ores
        GameRegistry.addSmelting(SheeepsItems.iron_residue, new ItemStack(Items.iron_ingot, 1), WOOL_SMELT_XP);
        GameRegistry.addSmelting(SheeepsItems.diamond_residue, new ItemStack(Items.diamond, 1), WOOL_SMELT_XP);
        GameRegistry.addSmelting(SheeepsItems.coal_residue, new ItemStack(Items.coal, 4), WOOL_SMELT_XP);
        GameRegistry.addSmelting(SheeepsItems.emerald_residue, new ItemStack(Items.emerald, 1), WOOL_SMELT_XP);
        GameRegistry.addSmelting(SheeepsItems.gold_residue, new ItemStack(Items.gold_ingot, 1), WOOL_SMELT_XP);
        GameRegistry.addSmelting(SheeepsItems.glowstone_residue, new ItemStack(Items.glowstone_dust, 4), WOOL_SMELT_XP);
        GameRegistry.addSmelting(SheeepsItems.redstone_residue, new ItemStack(Items.redstone, 4), WOOL_SMELT_XP);
        GameRegistry.addSmelting(SheeepsItems.lapis_residue, new ItemStack(Items.dye, 8, 4), WOOL_SMELT_XP);
    }

    public static void addModFurnaceRecipes(){

        final float WOOL_SMELT_XP = 0.0F;   // negative XP would probably cause a problem :)

        List<ItemStack> copperOres = OreDictionary.getOres("ingotCopper");
        List<ItemStack> tinOres = OreDictionary.getOres("ingotTin");
        List<ItemStack> nickelOres = OreDictionary.getOres("ingotNickel");
        List<ItemStack> leadOres = OreDictionary.getOres("ingotLead");
        List<ItemStack> silverOres = OreDictionary.getOres("ingotSilver");
        List<ItemStack> platinumOres = OreDictionary.getOres("ingotPlatinum");
        List<ItemStack> arditeOres = OreDictionary.getOres("ingotArdite");
        List<ItemStack> cobaltOres = OreDictionary.getOres("ingotCobalt");

        if(copperOres.size() > 0) {
            ItemStack copperOre = copperOres.get(0);
            copperOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.copper_residue, copperOre, WOOL_SMELT_XP);
        }
        if(tinOres.size() > 0) {
            ItemStack tinOre = tinOres.get(0);
            tinOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.tin_residue, tinOre, WOOL_SMELT_XP);
        }
        if(nickelOres.size() > 0) {
            ItemStack nickelOre = nickelOres.get(0);
            nickelOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.nickel_residue, nickelOre, WOOL_SMELT_XP);
        }
        if(leadOres.size() > 0) {
            ItemStack leadOre = leadOres.get(0);
            leadOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.lead_residue, leadOre, WOOL_SMELT_XP);
        }
        if(silverOres.size() > 0) {
            ItemStack silverOre = silverOres.get(0);
            silverOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.silver_residue, silverOre, WOOL_SMELT_XP);
        }
        if(platinumOres.size() > 0) {
            ItemStack platinumOre = platinumOres.get(0);
            platinumOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.platinum_residue, platinumOre, WOOL_SMELT_XP);
        }
        if(arditeOres.size() > 0) {
            ItemStack arditeOre = arditeOres.get(0);
            arditeOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.ardite_residue, arditeOre, WOOL_SMELT_XP);
        }
        if(cobaltOres.size() > 0) {
            ItemStack cobaltOre = cobaltOres.get(0);
            cobaltOre.stackSize = 1;

            GameRegistry.addSmelting(SheeepsItems.cobalt_residue, cobaltOre, WOOL_SMELT_XP);
        }
    }
}
