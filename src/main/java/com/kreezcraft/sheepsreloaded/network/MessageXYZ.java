package com.kreezcraft.sheepsreloaded.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/**
 * Created by Dan on 3/2/2016.
 */
public abstract class MessageXYZ<REQ extends IMessage> extends MessageBase<REQ> {
    protected int x, y, z;

    public MessageXYZ(){}

    public MessageXYZ(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public MessageXYZ(TileEntity te){
        this(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
    }

    @Override
    public void fromBytes(ByteBuf buf){
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    protected TileEntity getTileEntity(World world){
        return world.getTileEntity(new BlockPos(x, y, z));
    }
}
