package com.zulucap.sheeeps.items;

import com.google.common.collect.Maps;
import com.zulucap.sheeeps.init.SheeepsBlocks;
import com.zulucap.sheeeps.init.SheeepsItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Map;

/**
 * Created by Dan on 3/7/2016.
 */
public class WasherRegistry {

    private static final WasherRegistry washerBase = new WasherRegistry();
    private Map<ItemStack, ItemStack> washingList = Maps.<ItemStack, ItemStack>newHashMap();

    public static WasherRegistry instance()
    {
        return washerBase;
    }

    public WasherRegistry(){
        /* Vanilla Ores */
        this.addWasherRecipeForItem(SheeepsItems.coal_fleece, new ItemStack(SheeepsBlocks.coal_wool));
        this.addWasherRecipeForItem(SheeepsItems.iron_fleece, new ItemStack(SheeepsBlocks.iron_wool));
        this.addWasherRecipeForItem(SheeepsItems.diamond_fleece, new ItemStack(SheeepsBlocks.diamond_wool));
        this.addWasherRecipeForItem(SheeepsItems.emerald_fleece, new ItemStack(SheeepsBlocks.emerald_wool));
        this.addWasherRecipeForItem(SheeepsItems.gold_fleece, new ItemStack(SheeepsBlocks.gold_wool));
        this.addWasherRecipeForItem(SheeepsItems.glowstone_fleece, new ItemStack(SheeepsBlocks.glowstone_wool));
        this.addWasherRecipeForItem(SheeepsItems.redstone_fleece, new ItemStack(SheeepsBlocks.redstone_wool));
        this.addWasherRecipeForItem(SheeepsItems.lapis_fleece, new ItemStack(SheeepsBlocks.lapis_wool));
    }

    public void addModWasherRecipes(){
        if(OreDictionary.getOres("ingotCopper").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.copper_fleece, new ItemStack(SheeepsBlocks.copper_wool));
        }
        if(OreDictionary.getOres("ingotTin").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.tin_fleece, new ItemStack(SheeepsBlocks.tin_wool));
        }
        if(OreDictionary.getOres("ingotNickel").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.nickel_fleece, new ItemStack(SheeepsBlocks.nickel_wool));
        }
        if(OreDictionary.getOres("ingotLead").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.lead_fleece, new ItemStack(SheeepsBlocks.lead_wool));
        }
        if(OreDictionary.getOres("ingotSilver").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.silver_fleece, new ItemStack(SheeepsBlocks.silver_wool));
        }
        if(OreDictionary.getOres("ingotPlatinum").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.platinum_fleece, new ItemStack(SheeepsBlocks.platinum_wool));
        }
        if(OreDictionary.getOres("ingotArdite").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.ardite_fleece, new ItemStack(SheeepsBlocks.ardite_wool));
        }
        if(OreDictionary.getOres("ingotCobalt").size() > 0) {
            this.addWasherRecipeForItem(SheeepsItems.cobalt_fleece, new ItemStack(SheeepsBlocks.cobalt_wool));
        }
    }
    /**
     * Adds a smelting recipe, where the input item is an instance of Block.
     */
    public void addWasherRecipeForItem(Item input, ItemStack stack)
    {
        this.addWashing(input, stack);
    }

    /**
     * Adds a smelting recipe using an Item as the input item.
     */
    public void addWashing(Item input, ItemStack stack)
    {
        this.addWashingRecipe(new ItemStack(input, 1, 32767), stack);
    }

    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
    public void addWashingRecipe(ItemStack input, ItemStack stack)
    {
        if (getWashingResult(input) != null) { net.minecraftforge.fml.common.FMLLog.info("Ignored washing recipe with conflicting input: " + input + " = " + stack); return; }
        this.washingList.put(input, stack);
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getWashingResult(ItemStack stack)
    {
        for (Map.Entry<ItemStack, ItemStack> entry : this.washingList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue().copy();
            }
        }

        return null;
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }
}
