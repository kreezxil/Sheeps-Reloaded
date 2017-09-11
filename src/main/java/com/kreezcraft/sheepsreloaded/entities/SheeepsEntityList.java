package com.kreezcraft.sheepsreloaded.entities;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SheeepsEntityList
{
    private static final Logger logger = LogManager.getLogger();
    public static final Map< String, Class <? extends Entity>> stringToClassMapping = Maps. < String, Class <? extends Entity >> newHashMap();
    public static final Map < Class <? extends Entity > , String > classToStringMapping = Maps. < Class <? extends Entity > , String > newHashMap();
    public static final Map < Integer, Class <? extends Entity >> idToClassMapping = Maps. < Integer, Class <? extends Entity >> newHashMap();
    private static final Map < Class <? extends Entity > , Integer > classToIDMapping = Maps. < Class <? extends Entity > , Integer > newHashMap();
    private static final Map<String, Integer> stringToIDMapping = Maps.<String, Integer>newHashMap();
    public static final Map<Integer, SheeepsEntityList.EntityEggInfo> entityEggs = Maps.<Integer, SheeepsEntityList.EntityEggInfo>newLinkedHashMap();

    /**
     * adds a mapping between Entity classes and both a string representation and an ID
     */
    public static void addMapping(Class <? extends Entity > entityClass, String entityName, int id)
    {
        if (id < 0 || id > 255) throw new IllegalArgumentException("Attempted to register a entity with invalid ID: " + id + " Name: " + entityName + " Class: " + entityClass);
        if (stringToClassMapping.containsKey(entityName))
        {
            throw new IllegalArgumentException("ID is already registered: " + entityName);
        }
        else if (idToClassMapping.containsKey(Integer.valueOf(id)))
        {
            throw new IllegalArgumentException("ID is already registered: " + id);
        }
        else if (id == 0)
        {
            throw new IllegalArgumentException("Cannot register to reserved id: " + id);
        }
        else if (entityClass == null)
        {
            throw new IllegalArgumentException("Cannot register null clazz for id: " + id);
        }
        else
        {
            stringToClassMapping.put(entityName, entityClass);
            classToStringMapping.put(entityClass, entityName);
            idToClassMapping.put(Integer.valueOf(id), entityClass);
            classToIDMapping.put(entityClass, Integer.valueOf(id));
            stringToIDMapping.put(entityName, Integer.valueOf(id));
        }
    }

    /**
     * Adds a entity mapping with egg info.
     */
    public static void addMapping(Class <? extends Entity > entityClass, String entityName, int entityID, int baseColor, int spotColor)
    {
        addMapping(entityClass, entityName, entityID);
    }

    /**
     * Create a new instance of an entity in the world by using the entity name.
     */
    public static Entity createEntityByName(String entityName, World worldIn)
    {
        Entity entity = null;

        try
        {
            Class <? extends Entity > oclass = (Class)stringToClassMapping.get(entityName);

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {worldIn});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return entity;
    }

    /**
     * create a new instance of an entity from NBT store
     */
    public static Entity createEntityFromNBT(NBTTagCompound nbt, World worldIn)
    {
        Entity entity = null;

        if ("Minecart".equals(nbt.getString("id")))
        {
            nbt.setString("id", EntityMinecart.EnumMinecartType.byNetworkID(nbt.getInteger("Type")).getName());
            nbt.removeTag("Type");
        }

        Class <? extends Entity > oclass = null;
        try
        {
            oclass = stringToClassMapping.get(nbt.getString("id"));

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {worldIn});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        if (entity != null)
        {
            try
            {
                entity.readFromNBT(nbt);
            }
            catch (Exception e)
            {
                net.minecraftforge.fml.common.FMLLog.log(org.apache.logging.log4j.Level.ERROR, e,
                        "An Entity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author",
                        nbt.getString("id"), oclass.getName());
                entity = null;
            }
        }
        else
        {
            logger.warn("Skipping Entity with id " + nbt.getString("id"));
        }

        return entity;
    }

    /**
     * Create a new instance of an entity in the world by using an entity ID.
     */
    public static Entity createEntityByID(int entityID, World worldIn)
    {
        Entity entity = null;

        try
        {
            Class <? extends Entity > oclass = getClassFromID(entityID);

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {worldIn});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        if (entity == null)
        {
            logger.warn("Skipping Entity with id " + entityID);
        }

        return entity;
    }

    /**
     * gets the entityID of a specific entity
     */
    public static int getEntityID(Entity entityIn)
    {
        Integer integer = (Integer)classToIDMapping.get(entityIn.getClass());
        return integer == null ? 0 : integer.intValue();
    }

    public static Class <? extends Entity > getClassFromID(int entityID)
    {
        return (Class)idToClassMapping.get(Integer.valueOf(entityID));
    }

    /**
     * Gets the string representation of a specific entity.
     */
    public static String getEntityString(Entity entityIn)
    {
        return (String)classToStringMapping.get(entityIn.getClass());
    }

    /**
     * Finds the class using IDtoClassMapping and classToStringMapping
     */
    public static String getStringFromID(int entityID)
    {
        return (String)classToStringMapping.get(getClassFromID(entityID));
    }

    /**
     * Returns the ID assigned to it's string representation
     */
    @SideOnly(Side.CLIENT)
    public static int getIDFromString(String entityName)
    {
        Integer integer = (Integer)stringToIDMapping.get(entityName);
        return integer == null ? 90 : integer.intValue();
    }

    public static void func_151514_a()
    {
    }

    public static List<String> getEntityNameList()
    {
        Set<String> set = stringToClassMapping.keySet();
        List<String> list = Lists.<String>newArrayList();

        for (String s : set)
        {
            Class <? extends Entity > oclass = (Class)stringToClassMapping.get(s);

            if ((oclass.getModifiers() & 1024) != 1024)
            {
                list.add(s);
            }
        }

        list.add("LightningBolt");
        return list;
    }

    public static boolean isStringEntityName(Entity entityIn, String entityName)
    {
        String s = getEntityString(entityIn);

        if (s == null && entityIn instanceof EntityPlayer)
        {
            s = "Player";
        }
        else if (s == null && entityIn instanceof EntityLightningBolt)
        {
            s = "LightningBolt";
        }

        return entityName.equals(s);
    }

    public static boolean isStringValidEntityName(String entityName)
    {
        return "Player".equals(entityName) || getEntityNameList().contains(entityName);
    }

    public static class EntityEggInfo
    {
        /** The entityID of the spawned mob */
        @Deprecated // This is not always a valid number in the global ID list.
        public final int spawnedID;
        public final String name;
        /** Base color of the egg */
        public final int primaryColor;
        /** Color of the egg spots */
        public final int secondaryColor;
        public final StatBase field_151512_d;
        public final StatBase field_151513_e;

        public EntityEggInfo(String name, int primaryColor, int secondaryColor)
        {
            this.spawnedID = -1;
            this.name = name;
            this.primaryColor = primaryColor;
            this.secondaryColor = secondaryColor;
            this.field_151512_d = (new StatBase("stat.killEntity."     + name, new net.minecraft.util.ChatComponentTranslation("stat.entityKill",     new net.minecraft.util.ChatComponentTranslation("entity." + name + ".name")))).registerStat();
            this.field_151513_e = (new StatBase("stat.entityKilledBy." + name, new net.minecraft.util.ChatComponentTranslation("stat.entityKilledBy", new net.minecraft.util.ChatComponentTranslation("entity." + name + ".name")))).registerStat();
        }
    }
}