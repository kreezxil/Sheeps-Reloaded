package com.zulucap.sheeeps.network;

import com.zulucap.sheeeps.Reference;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * Created by Dan on 3/2/2016.
 */
public class NetworkHandler {
    private static SimpleNetworkWrapper INSTANCE;

    public static void init(){
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);

        // Register messages
        // ex. INSTANCE.registerMessage(MessageClass.class, MessageClass.class, 0, Side.SERVER);
    }

    public static void sendToServer(IMessage message){
        INSTANCE.sendToServer(message);
    }

    public static void sendTo(IMessage message, EntityPlayerMP player){
        INSTANCE.sendTo(message, player);
    }

    public static void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point){
        INSTANCE.sendToAllAround(message, point);
    }

    public static void sendToAllAround(MessageXYZ message, World world){
        INSTANCE.sendToAllAround(message, new NetworkRegistry.TargetPoint(world.provider.getDimensionId(), message.x, message.y, message.z, 64D));
    }

    public static void sendToAll(IMessage message){
        INSTANCE.sendToAll(message);
    }

    public static void sendToDimension(IMessage message, int dimensionId){
        INSTANCE.sendToDimension(message, dimensionId);
    }
}
