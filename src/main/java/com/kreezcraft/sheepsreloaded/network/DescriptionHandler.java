package com.kreezcraft.sheepsreloaded.network;

import com.kreezcraft.sheepsreloaded.Reference;
import com.kreezcraft.sheepsreloaded.Sheeeps;
import com.kreezcraft.sheepsreloaded.tileentities.SheeepsTileEntityBase;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

/**
 * Created by Dan on 3/2/2016.
 */
@ChannelHandler.Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket> {
    public static final String CHANNEL = Reference.MODID + "Description";

    static {
        NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
    }

    public static void init(){}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        TileEntity te = Sheeeps.proxy.getClientPlayer().worldObj.getTileEntity(new BlockPos(x, y, z));
        if(te instanceof SheeepsTileEntityBase){
            ((SheeepsTileEntityBase)te).readFromPacket(buf);
        }
    }
}
