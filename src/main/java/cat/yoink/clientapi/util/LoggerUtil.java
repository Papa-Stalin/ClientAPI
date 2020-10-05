package cat.yoink.clientapi.util;

import cat.yoink.clientapi.ClientAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class LoggerUtil
{
    public static void sendMessage(String message)
    {
        sendMessage(message, true);
    }

    public static void sendMessage(String message, boolean waterMark)
    {
        StringBuilder messageBuilder = new StringBuilder();

        if (waterMark) messageBuilder.append(ClientAPI.getLoggerPrefix()).append("&r ");

        messageBuilder.append(message);

        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(messageBuilder.toString().replace("&", "§")));
    }
}
