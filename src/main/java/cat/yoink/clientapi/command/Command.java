package cat.yoink.clientapi.command;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.util.LoggerUtil;
import net.minecraft.client.Minecraft;

public class Command
{
    public Minecraft mc = Minecraft.getMinecraft();
    private final String name = getClass().getAnnotation(Com.class).name();
    private final String[] aliases = getClass().getAnnotation(Com.class).aliases();
    private final String usage = getClass().getAnnotation(Com.class).usage();
    private final String description = getClass().getAnnotation(Com.class).description();

    public void onRun(String arguments) { }

    public void printUsage()
    {
        LoggerUtil.sendMessage("Usage: " + ClientAPI.getPrefix() + usage);
    }

    public String getName()
    {
        return name;
    }

    public String getUsage()
    {
        return usage;
    }

    public String[] getAliases()
    {
        return aliases;
    }

    public String getDescription()
    {
        return description;
    }
}
