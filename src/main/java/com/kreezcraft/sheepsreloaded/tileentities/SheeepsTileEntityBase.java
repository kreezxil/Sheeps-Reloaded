package com.kreezcraft.sheepsreloaded.tileentities;

import com.kreezcraft.sheepsreloaded.network.DescriptionHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

/**
 * Created by Dan on 3/2/2016.
 */
public class SheeepsTileEntityBase extends TileEntity {

    @Override
    public Packet getDescriptionPacket(){
        PacketBuffer buf = new PacketBuffer(Unpooled.buffer());

        buf.writeInt(getPos().getX());
        buf.writeInt(getPos().getY());
        buf.writeInt(getPos().getZ());
        writeToPacket(buf);
        return new FMLProxyPacket(buf, DescriptionHandler.CHANNEL);
    }

    public void writeToPacket(ByteBuf buf){}

    public void readFromPacket(ByteBuf buf){}

}
