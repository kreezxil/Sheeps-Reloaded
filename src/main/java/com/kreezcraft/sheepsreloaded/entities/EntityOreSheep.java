package com.kreezcraft.sheepsreloaded.entities;

import com.kreezcraft.sheepsreloaded.init.SheeepsEntities;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.List;

/**
 * Created by Dan on 2/28/2016.
 */
public class EntityOreSheep extends EntitySheep {

    public static final int TYPE_ID = 19;
    public static final String TYPE_NBT = "Type";

    public EntityOreSheep(World worldIn) {
        super(worldIn);
    }

    public ResourceLocation getShearedTexture(){
        SheeepsEntity sheeep = getSheeep();
        return sheeep.getShearedTexture();
    }

    public ResourceLocation getFurTexture(){
        SheeepsEntity sheeep = getSheeep();
        return sheeep.getFurTexture();
    }

    private static class GroupData implements IEntityLivingData {
        private final int type;

        public GroupData(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    public void setSheeepType(int type){
        this.dataWatcher.updateObject(TYPE_ID, type);
    }

    private SheeepsEntity getSheeep(){
        return SheeepsEntities.getByType(getSheeepType());
    }

    private int getSheeepType() {
        return this.dataWatcher.getWatchableObjectInt(TYPE_ID);
    }

    @Override
    protected void entityInit(){
        super.entityInit();
        this.dataWatcher.addObject(TYPE_ID, 0);
    }

    /*
        World Gen Sheeep
     */
    @Override
    public boolean getCanSpawnHere() {
        /**
         * Checks if the entity's current position is a valid location to spawn this entity.
         */
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor_double(this.posZ);
        BlockPos blockpos = new BlockPos(i, j, k);
        //return this.worldObj.getBlockState(blockpos.down()).getBlock() == this.spawnableBlock;

        return true;
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingData){
        livingData = super.onInitialSpawn(difficulty, livingData);

        if (livingData instanceof GroupData) {
            GroupData groupData = (GroupData) livingData;
            setSheeepType(groupData.getType());
        } else {
            BiomeGenBase biome = worldObj.getBiomeGenForCoords(getPosition());
            BlockPos pos = getPosition();

            List<SheeepsEntity> possibleSheeeps = SheeepsEntities.getPossibleSheeeps(biome, pos);
            // Get Random sheep
            if(possibleSheeeps.size() == 0){
                possibleSheeeps.add(SheeepsEntities.getByType(2));
            }

            SheeepsEntity sheeep = possibleSheeeps.get(rand.nextInt(possibleSheeeps.size()));

            int type = sheeep.getId();
            setSheeepType(type);
            livingData = new GroupData(type);
        }

        if (rand.nextInt(5) == 0) {
            setGrowingAge(-24000);
        }

        return livingData;
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompund) {
        super.writeToNBT(tagCompund);
        tagCompund.setInteger(TYPE_NBT, getSheeepType());
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompund) {
        super.readFromNBT(tagCompund);
        setSheeepType(tagCompund.getInteger(TYPE_NBT));
    }

    @Override
    public String getName(){
        if(this.hasCustomName()) {
            return getCustomNameTag();
        }

        SheeepsEntity sheeep = getSheeep();
        //return StatCollector.translateToLocal("entity." + sheeep.getEntityName() + ".name");
        return sheeep.getEntityName();
    }

    /**
     * Drop 0-2 items of this living's type
     */
    @Override
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        if (!this.getSheared())
        {
            int i = this.rand.nextInt(2) + 1;
            ItemStack fleece = getFleeceDropItem();
            fleece.stackSize = i;

            this.entityDropItem(fleece, 0.0F);
        }

        int i = this.rand.nextInt(2) + 1 + this.rand.nextInt(1 + p_70628_2_);

        for (int j = 0; j < i; ++j)
        {
            if (this.isBurning())
            {
                this.dropItem(Items.cooked_mutton, 1);
            }
            else
            {
                this.dropItem(Items.mutton, 1);
            }
        }
    }

    @Override
    protected Item getDropItem(){
        SheeepsEntity sheeep = getSheeep();
        return sheeep.getDropItem().getItem();
    }

    protected ItemStack getFleeceDropItem()
    {
        SheeepsEntity sheeep = getSheeep();
        ItemStack dropItem = sheeep.getDropItem();
        dropItem.stackSize = 1;
        return dropItem;
        //return Item.getItemFromBlock(Blocks.wool);
    }

    @SuppressWarnings("unused")
    public boolean interact(EntityPlayer player)
    {
        /*
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.shears && !this.getSheared() && !this.isChild()) //Forge: Moved to onSheared
        {
            if (!this.worldObj.isRemote)
            {
                this.setSheared(true);
                int i = 1 + this.rand.nextInt(3);

                for (int j = 0; j < i; ++j)
                {
                    EntityItem entityitem = this.entityDropItem(getFleeceDropItem(), 1.0F);
                    entityitem.motionY += (double)(this.rand.nextFloat() * 0.05F);
                    entityitem.motionX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
                    entityitem.motionZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
                }
            }

            itemstack.damageItem(1, player);
            this.playSound("mob.sheep.shear", 1.0F, 1.0F);
        }
        */
        return super.interact(player);
    }

    @Override
    public EntitySheep createChild(EntityAgeable ageable)
    {
        EntitySheep entitysheep = (EntitySheep)ageable;
        EntitySheep entitysheep1 = new EntitySheep(this.worldObj);
        //entitysheep1.setFleeceColor(this.getDyeColorMixFromParents(this, entitysheep));
        return entitysheep1;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        this.setSheared(true);
        int i = 1 + this.rand.nextInt(2);

        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        for (int j = 0; j < i; ++j)
            ret.add(getFleeceDropItem());

        this.playSound("mob.sheep.shear", 1.0F, 1.0F);
        return ret;
    }
}
