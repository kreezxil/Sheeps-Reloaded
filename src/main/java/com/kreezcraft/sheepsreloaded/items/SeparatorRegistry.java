package com.zulucap.sheeeps.items;

import com.google.common.collect.Maps;
import com.zulucap.sheeeps.init.SheeepsBlocks;
import com.zulucap.sheeeps.init.SheeepsItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Map;

/**
 * Created by Dan on 3/4/2016.
 */
public class SeparatorRegistry {
    private static final SeparatorRegistry separatorBase = new SeparatorRegistry();
    private Map<ItemStack, ItemStack> separatingList = Maps.<ItemStack, ItemStack>newHashMap();
    private Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static SeparatorRegistry instance()
    {
        return separatorBase;
    }

    public SeparatorRegistry(){
        /* Vanilla Ores */
        this.addSeparatorRecipeForBlock(SheeepsBlocks.coal_wool, new ItemStack(SheeepsItems.coal_residue), 0.5F);
        this.addSeparatorRecipeForBlock(SheeepsBlocks.iron_wool, new ItemStack(SheeepsItems.iron_residue), 0.7F);
        this.addSeparatorRecipeForBlock(SheeepsBlocks.diamond_wool, new ItemStack(SheeepsItems.diamond_residue), 1.0F);
        this.addSeparatorRecipeForBlock(SheeepsBlocks.emerald_wool, new ItemStack(SheeepsItems.emerald_residue), 1.0F);
        this.addSeparatorRecipeForBlock(SheeepsBlocks.gold_wool, new ItemStack(SheeepsItems.gold_residue), 0.7F);
        this.addSeparatorRecipeForBlock(SheeepsBlocks.glowstone_wool, new ItemStack(SheeepsItems.glowstone_residue), 0.85F);
        this.addSeparatorRecipeForBlock(SheeepsBlocks.redstone_wool, new ItemStack(SheeepsItems.redstone_residue), 0.85F);
        this.addSeparatorRecipeForBlock(SheeepsBlocks.lapis_wool, new ItemStack(SheeepsItems.lapis_residue), 0.9F);
    }

    public void addModSeparatorRecipes(){
        if(OreDictionary.getOres("ingotCopper").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.copper_wool, new ItemStack(SheeepsItems.copper_residue), 0.5F);
        }
        if(OreDictionary.getOres("ingotTin").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.tin_wool, new ItemStack(SheeepsItems.tin_residue), 0.7F);
        }
        if(OreDictionary.getOres("ingotNickel").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.nickel_wool, new ItemStack(SheeepsItems.nickel_residue), 1.0F);
        }
        if(OreDictionary.getOres("ingotLead").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.lead_wool, new ItemStack(SheeepsItems.lead_residue), 1.0F);
        }
        if(OreDictionary.getOres("ingotSilver").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.silver_wool, new ItemStack(SheeepsItems.silver_residue), 0.7F);
        }
        if(OreDictionary.getOres("ingotPlatinum").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.platinum_wool, new ItemStack(SheeepsItems.platinum_residue), 0.85F);
        }
        if(OreDictionary.getOres("ingotArdite").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.ardite_wool, new ItemStack(SheeepsItems.ardite_residue), 0.85F);
        }
        if(OreDictionary.getOres("ingotCobalt").size() > 0) {
            this.addSeparatorRecipeForBlock(SheeepsBlocks.cobalt_wool, new ItemStack(SheeepsItems.cobalt_residue), 0.9F);
        }
    }

    /**
     * Adds a smelting recipe, where the input item is an instance of Block.
     */
    public void addSeparatorRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addSeparating(Item.getItemFromBlock(input), stack, experience);
    }

    /**
     * Adds a smelting recipe using an Item as the input item.
     */
    public void addSeparating(Item input, ItemStack stack, float experience)
    {
        this.addSeparatingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
    public void addSeparatingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getSeparatingResult(input) != null) { net.minecraftforge.fml.common.FMLLog.info("Ignored separating recipe with conflicting input: " + input + " = " + stack); return; }
        this.separatingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSeparatingResult(ItemStack stack)
    {
        for (Map.Entry<ItemStack, ItemStack> entry : this.separatingList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue();
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
