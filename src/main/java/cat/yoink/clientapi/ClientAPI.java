package cat.yoink.clientapi;

import cat.yoink.clientapi.command.CommandManager;
import cat.yoink.clientapi.config.Config;
import cat.yoink.clientapi.module.ModuleManager;
import cat.yoink.clientapi.setting.SettingManager;
import net.minecraftforge.common.MinecraftForge;

import java.io.IOException;

public class ClientAPI
{
    private static String name;
    private static String modID;
    private static String version;
    private static String loggerPrefix;
    private static String folderName;
    private static String prefix;

    private static ModuleManager moduleManager;
    private static SettingManager settingManager;
    private static CommandManager commandManager;
    private static Config config;

    public ClientAPI(String name, String modID, String version)
    {
        ClientAPI.name = name;
        ClientAPI.modID = modID;
        ClientAPI.version = version;
        loggerPrefix = "&7[&4" + name + "&7]";
        folderName = name;
        prefix = ".";
    }

    public ClientAPI(APIBuilder builder) throws InitializationException
    {
        if (builder.getName() == null) throw new InitializationException("Name not specified");
        if (builder.getModID() == null) throw new InitializationException("ModID not specified");
        if (builder.getVersion() == null) throw new InitializationException("Version not specified");

        ClientAPI.name = builder.getName();
        ClientAPI.modID = builder.getModID();
        ClientAPI.version = builder.getVersion();

        if (builder.getLoggerPrefix() == null) loggerPrefix = "&7[&4" + name + "&7]";
        else loggerPrefix = builder.getLoggerPrefix();
        if (builder.getFolderName() == null) folderName = name;
        else folderName = builder.getFolderName();
        if (builder.getPrefix() == null) prefix = ".";
        else prefix = builder.getPrefix();
    }


    public void initialize()
    {
        settingManager = new SettingManager();
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        config = new Config();

        MinecraftForge.EVENT_BUS.register(new EventHandler());
        Runtime.getRuntime().addShutdownHook(config);
    }

    public void loadConfig()
    {
        try
        {
            config.loadConfig();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void setChatlogPrefix(String prefix)
    {
        setLoggerPrefix(prefix);
    }

    public static void setConfigFolderName(String name)
    {
        setFolderName(name);
    }

    public static void setCommandPrefix(String prefix)
    {
        setPrefix(prefix);
    }

    public static String getName()
    {
        return name;
    }

    public static String getModID()
    {
        return modID;
    }

    public static String getVersion()
    {
        return version;
    }

    public static ModuleManager getModuleManager()
    {
        return moduleManager;
    }

    public static SettingManager getSettingManager()
    {
        return settingManager;
    }

    public static CommandManager getCommandManager()
    {
        return commandManager;
    }

    public static String getLoggerPrefix()
    {
        return loggerPrefix;
    }

    public static void setLoggerPrefix(String loggerPrefix)
    {
        ClientAPI.loggerPrefix = loggerPrefix;
    }

    public static String getFolderName()
    {
        return folderName;
    }

    public static void setFolderName(String folderName)
    {
        ClientAPI.folderName = folderName;
    }

    public static void setPrefix(String prefix)
    {
        ClientAPI.prefix = prefix;
    }

    public static String getPrefix()
    {
        return prefix;
    }
}