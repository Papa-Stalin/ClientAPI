package cat.yoink.clientapi.command;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.MinecraftInstance;
import cat.yoink.clientapi.util.LoggerUtil;

public class Command implements MinecraftInstance
{
    private final String name = getClass().getAnnotation(ClientCommand.class).name();
    private final String[] aliases = getClass().getAnnotation(ClientCommand.class).aliases();
    private final String usage = getClass().getAnnotation(ClientCommand.class).usage();
    private final String description = getClass().getAnnotation(ClientCommand.class).description();

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
