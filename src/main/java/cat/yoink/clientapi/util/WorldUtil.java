package cat.yoink.clientapi.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class WorldUtil
{
    public static void placeBlock(BlockPos pos)
    {
        for (EnumFacing enumFacing : EnumFacing.values())
        {
            if (!Minecraft.getMinecraft().world.getBlockState(pos.offset(enumFacing)).getBlock().equals(Blocks.AIR) && !isIntercepted(pos))
            {
                Vec3d vec = new Vec3d(pos.getX() + 0.5D + (double) enumFacing.getXOffset() * 0.5D, pos.getY() + 0.5D + (double) enumFacing.getYOffset() * 0.5D, pos.getZ() + 0.5D + (double) enumFacing.getZOffset() * 0.5D);

                float[] old = new float[]{Minecraft.getMinecraft().player.rotationYaw, Minecraft.getMinecraft().player.rotationPitch};

                Minecraft.getMinecraft().player.connection.sendPacket(new CPacketPlayer.Rotation((float) Math.toDegrees(Math.atan2((vec.z - Minecraft.getMinecraft().player.posZ), (vec.x - Minecraft.getMinecraft().player.posX))) - 90.0F, (float) (-Math.toDegrees(Math.atan2((vec.y - (Minecraft.getMinecraft().player.posY + (double) Minecraft.getMinecraft().player.getEyeHeight())), (Math.sqrt((vec.x - Minecraft.getMinecraft().player.posX) * (vec.x - Minecraft.getMinecraft().player.posX) + (vec.z - Minecraft.getMinecraft().player.posZ) * (vec.z - Minecraft.getMinecraft().player.posZ)))))), Minecraft.getMinecraft().player.onGround));
                Minecraft.getMinecraft().player.connection.sendPacket(new CPacketEntityAction(Minecraft.getMinecraft().player, CPacketEntityAction.Action.START_SNEAKING));
                Minecraft.getMinecraft().playerController.processRightClickBlock(Minecraft.getMinecraft().player, Minecraft.getMinecraft().world, pos.offset(enumFacing), enumFacing.getOpposite(), new Vec3d(pos), EnumHand.MAIN_HAND);
                Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);
                Minecraft.getMinecraft().player.connection.sendPacket(new CPacketEntityAction(Minecraft.getMinecraft().player, CPacketEntityAction.Action.STOP_SNEAKING));
                Minecraft.getMinecraft().player.connection.sendPacket(new CPacketPlayer.Rotation(old[0], old[1], Minecraft.getMinecraft().player.onGround));

                return;
            }
        }
    }

    public static boolean isIntercepted(BlockPos pos)
    {
        for (Entity entity : Minecraft.getMinecraft().world.loadedEntityList) if (new AxisAlignedBB(pos).intersects(entity.getEntityBoundingBox())) return true;
        return false;
    }
}
