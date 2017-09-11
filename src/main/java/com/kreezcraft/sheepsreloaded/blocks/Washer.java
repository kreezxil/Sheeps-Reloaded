package com.kreezcraft.sheepsreloaded.blocks;

import com.kreezcraft.sheepsreloaded.init.SheepsBlocks;
import com.kreezcraft.sheepsreloaded.items.fleece.BaseOreFleece;
import com.kreezcraft.sheepsreloaded.items.WasherRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

/**
 * Created by Dan on 2/29/2016.
 */
public class Washer extends Block /*extends BlockContainer*/ {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);

    public Washer(Material materialIn) {

        super(materialIn, MapColor.woodColor);

        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
        this.setHardness(3.5F);
        this.setResistance(3.5F);
        this.setStepSound(soundTypeWood);
        this.setHarvestLevel("axe",0);
    }

    /**
     * Add all collision boxes of this Block to the list that intersect with the given mask.
     */
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        float f = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBoundsForItemRender();
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = playerIn.inventory.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                int i = ((Integer)state.getValue(LEVEL)).intValue();
                Item item = itemstack.getItem();

                if (item == Items.water_bucket)
                {
                    if (i < 3)
                    {
                        if (!playerIn.capabilities.isCreativeMode)
                        {
                            playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, new ItemStack(Items.bucket));
                        }

                        playerIn.triggerAchievement(StatList.field_181725_I);
                        this.setWaterLevel(worldIn, pos, state, 3);
                    }

                    return true;
                } else if(item instanceof BaseOreFleece && i == 3){
                    if(!worldIn.isRemote) {
                        float spawnX = pos.getX();
                        float spawnY = pos.getY() + 1;
                        float spawnZ = pos.getZ();

                        ItemStack droppedItemStack = WasherRegistry.instance().getWashingResult(new ItemStack(item));
                        droppedItemStack.stackSize = 1;
                        EntityItem droppedItem = new EntityItem(worldIn,spawnX,spawnY,spawnZ, droppedItemStack);

                        float mult = 0.05F;
                        droppedItem.motionX = (-0.5F + worldIn.rand.nextFloat()) * mult;
                        droppedItem.motionX = (4 + worldIn.rand.nextFloat()) * mult;
                        droppedItem.motionX = (-0.5F + worldIn.rand.nextFloat()) * mult;

                        playerIn.inventory.consumeInventoryItem(playerIn.getHeldItem().getItem());
                        worldIn.spawnEntityInWorld(droppedItem);
                        setWaterLevel(worldIn, pos, state, 0);
                    }
                }
            }
        }

        return false;
    }

    public void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, int level)
    {
        worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp_int(level, 0, 3))), 2);
        worldIn.updateComparatorOutputLevel(pos, this);
    }

    /**
     * Called similar to random ticks, but only when it is raining.
     */
    public void fillWithRain(World worldIn, BlockPos pos)
    {
        if (worldIn.rand.nextInt(20) == 1)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);

            if (((Integer)iblockstate.getValue(LEVEL)).intValue() < 3)
            {
                worldIn.setBlockState(pos, iblockstate.cycleProperty(LEVEL), 2);
            }
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(SheepsBlocks.washer);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(SheepsBlocks.washer);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(LEVEL)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LEVEL});
    }

    /*
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
    */
}
