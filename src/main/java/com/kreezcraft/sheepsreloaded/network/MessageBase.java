package com.kreezcraft.sheepsreloaded.network;

import com.kreezcraft.sheepsreloaded.Sheeps;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Dan on 3/2/2016.
 */
public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ> {

    @Override
    public REQ onMessage(REQ message, MessageContext ctx){
        if(ctx.side == Side.SERVER){
            handleServerSide(message, ctx.getServerHandler().playerEntity);
        } else {
            handleClientSide(message, Sheeps.proxy.getClientPlayer());
        }
        return null;
    }

    public abstract void handleClientSide(REQ message, EntityPlayer player);

    public abstract void handleServerSide(REQ message, EntityPlayer player);
}
