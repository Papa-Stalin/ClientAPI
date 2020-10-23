package cat.yoink.clientapi;

import cat.yoink.clientapi.clickgui.ClickHandler;
import cat.yoink.clientapi.command.CommandManager;
import cat.yoink.clientapi.component.ComponentManager;
import cat.yoink.clientapi.config.Config;
import cat.yoink.clientapi.friend.FriendManager;
import cat.yoink.clientapi.hudeditor.HUDHandler;
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
    private static ClickHandler clickGUI;
    private static HUDHandler hudEditor;
    private static Package masterPackage;

    private static ModuleManager moduleManager;
    private static SettingManager settingManager;
    private static CommandManager commandManager;
    private static ComponentManager componentManager;
    private static FriendManager friendManager;
    private static Config config;

    public ClientAPI(APIBuilder builder) throws InitializationException
    {
        if (builder.getName() == null || builder.getModID() == null || builder.getVersion() == null) throw new InitializationException("You must specify the Name, ModID and Version");

        name = builder.getName();
        modID = builder.getModID();
        version = builder.getVersion();

        if (builder.getLoggerPrefix() == null) loggerPrefix = "&7[&4" + name + "&7]";
        else loggerPrefix = builder.getLoggerPrefix();
        if (builder.getFolderName() == null) folderName = name;
        else folderName = builder.getFolderName();
        if (builder.getPrefix() == null) prefix = ".";
        else prefix = builder.getPrefix();

        clickGUI = builder.getClickGUI();
        hudEditor = builder.getHUDEditor();
        masterPackage = builder.getMasterPackage();
    }

    public void initialize()
    {
        componentManager = new ComponentManager();
        settingManager = new SettingManager();
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        friendManager = new FriendManager();
        config = new Config();

        MinecraftForge.EVENT_BUS.register(new EventHandler());
        Runtime.getRuntime().addShutdownHook(config);
    }

    public void loadConfig()
    {
        try { config.loadConfig(); }
        catch (IOException e) { e.printStackTrace(); }
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
    public static ComponentManager getComponentManager()
    {
        return componentManager;
    }
    public static FriendManager getFriendManager()
    {
        return friendManager;
    }
    public static ClickHandler getClickGUI()
    {
        return clickGUI;
    }
    public static HUDHandler getHudEditor()
    {
        return hudEditor;
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

    public static void setMasterPackage(Package masterPackage)
    {
        ClientAPI.masterPackage = masterPackage;
    }
    public static Package getMasterPackage()
    {
        return masterPackage;
    }
}