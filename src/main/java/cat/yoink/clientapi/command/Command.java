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

    public final void printUsage()
    {
        LoggerUtil.sendMessage("Usage: " + ClientAPI.getPrefix() + usage);
    }

    public final String getName()
    {
        return name;
    }

    public final String getUsage()
    {
        return usage;
    }

    public final String[] getAliases()
    {
        return aliases;
    }

    public final String getDescription()
    {
        return description;
    }
}
