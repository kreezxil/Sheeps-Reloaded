package com.zulucap.sheeeps.events;

import com.zulucap.sheeeps.configuration.ConfigurationReference;
import com.zulucap.sheeeps.entities.EntityOreSheep;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

/**
 * Created by Dan on 3/6/2016.
 */
public class EventHandlerCommon {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onLivingSpawn(LivingSpawnEvent e){
        Entity dude = e.entity;
    }

    // Confirm to configured spawn density
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn e){
        Entity dude = e.entity;

        if(dude instanceof EntityOreSheep){
            List<EntityOreSheep> loadedSurfaceSheeeps = e.world.getEntitiesWithinAABB(EntityOreSheep.class, new AxisAlignedBB(e.entity.getPosition().getX() + 128, 64, e.entity.getPosition().getZ() + 128, e.entity.getPosition().getX() - 128, 255, e.entity.getPosition().getZ() - 128));
            List<EntityOreSheep> loadedCaveSheeeps = e.world.getEntitiesWithinAABB(EntityOreSheep.class, new AxisAlignedBB(e.entity.getPosition().getX() + 128, 0, e.entity.getPosition().getZ() + 128, e.entity.getPosition().getX() - 128, 64, e.entity.getPosition().getZ() - 128));

            if(e.entity.getPosition().getY() >= 64) {
                if (loadedSurfaceSheeeps.size() > ConfigurationReference.getSheepDensity())
                    e.setResult(Event.Result.DENY);
            } else {
                if (loadedCaveSheeeps.size() > ConfigurationReference.getSheepDensity())
                    e.setResult(Event.Result.DENY);
            }
        }

    }

}
