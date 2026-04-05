package com.footdablit2310.footorganicprocessing.content.squeezer;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SqueezerModePacket {

    private final BlockPos pos;
    private final int mode;

    public SqueezerModePacket(BlockPos pos, int mode) {
        this.pos = pos;
        this.mode = mode;
    }

    public static void encode(SqueezerModePacket pkt, FriendlyByteBuf buf) {
        buf.writeBlockPos(pkt.pos);
        buf.writeInt(pkt.mode);
    }

    public static SqueezerModePacket decode(FriendlyByteBuf buf) {
        return new SqueezerModePacket(buf.readBlockPos(), buf.readInt());
    }

    public static void handle(SqueezerModePacket pkt, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Level level = ctx.get().getSender().level();
            if (level.getBlockEntity(pkt.pos) instanceof SqueezerBlockEntity be) {
                be.setMode(pkt.mode == 0 ? SqueezerBlockEntity.SqueezerMode.SQUEEZING : SqueezerBlockEntity.SqueezerMode.COMPRESSING);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
