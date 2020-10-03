package cat.yoink.clientapi.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

public class PlayerUtil
{
    public static double vanillaSpeed()
    {
        double baseSpeed = 0.272;
        if (Minecraft.getMinecraft().player.isPotionActive(MobEffects.SPEED))
        {
            final int amplifier = Objects.requireNonNull(Minecraft.getMinecraft().player.getActivePotionEffect(MobEffects.SPEED)).getAmplifier();
            baseSpeed *= 1.0 + 0.2 * amplifier;
        }
        return baseSpeed;
    }

    public static boolean isMoving()
    {
        return Minecraft.getMinecraft().player.moveForward != 0.0 || Minecraft.getMinecraft().player.moveStrafing != 0.0;
    }

    public static int getSlot(Item item)
    {
        for (int i = 0; i < 9; i++)
        {
            Item item1 = Minecraft.getMinecraft().player.inventory.getStackInSlot(i).getItem();

            if (item.equals(item1))
            {
                return i;
            }
        }
        return -1;
    }

    public static int getSlot(Block block)
    {
        for (int i = 0; i < 9; i++)
        {
            Item item = Minecraft.getMinecraft().player.inventory.getStackInSlot(i).getItem();

            if (item instanceof ItemBlock && ((ItemBlock) item).getBlock().equals(block))
            {
                return i;
            }
        }
        return -1;
    }
}
