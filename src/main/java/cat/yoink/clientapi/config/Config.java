package cat.yoink.clientapi.config;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.setting.Setting;
import cat.yoink.clientapi.util.FileUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Config extends Thread
{
    private final File clientFolder = new File(Minecraft.getMinecraft().gameDir + File.separator + ClientAPI.getFolderName());
    private static final String ENABLED_MODULES = "EnabledModules.txt";
    private static final String SETTINGS = "Settings.txt";
    private static final String PREFIX = "Prefix.txt";

    @Override
    public void run()
    {
        if (!clientFolder.exists() && !clientFolder.mkdirs()) System.err.println("Failed to create folder");

        try { FileUtil.saveFile(new File(clientFolder.getAbsolutePath(), ENABLED_MODULES), enabledModulesConfig()); }
        catch (IOException e) { e.printStackTrace(); }

        try { FileUtil.saveFile(new File(clientFolder.getAbsolutePath(), SETTINGS), settingsConfig()); }
        catch (IOException e) { e.printStackTrace(); }

        try { FileUtil.saveFile(new File(clientFolder.getAbsolutePath(), PREFIX), prefixConfig()); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void loadConfig() throws IOException
    {
        if (!clientFolder.exists()) return;

        for (String s : FileUtil.loadFile(new File(clientFolder.getAbsolutePath(), ENABLED_MODULES)))
        {
            try { ClientAPI.getModuleManager().getModule(s).enable(); }
            catch (Exception e) { e.printStackTrace(); }
        }

        for (String s : FileUtil.loadFile(new File(clientFolder.getAbsolutePath(), SETTINGS)))
        {
            try
            {
                String[] split = s.split(":");

                for (Setting setting : ClientAPI.getSettingManager().getSettings())
                {
                    if (split[0].equals(setting.getName()) && split[1].equals(setting.getModule().getName()))
                    {
                        switch (setting.getType())
                        {
                            case BOOLEAN:
                                setting.setBooleanValue(Boolean.parseBoolean(split[2]));
                                break;
                            case INTEGER:
                                setting.setIntegerValue(Integer.parseInt(split[2]));
                                break;
                            case FLOAT:
                                setting.setFloatValue(Float.parseFloat(split[2]));
                                break;
                            case ENUM:
                                setting.setEnumValue(split[2]);
                                break;
                            case COLOR:
                                setting.setColor(new Color(Integer.parseInt(split[2])));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            catch (Exception e) { e.printStackTrace(); }
        }

        for (String s : FileUtil.loadFile(new File(clientFolder.getAbsolutePath(), PREFIX)))
        {
            ClientAPI.setPrefix(s);
        }
    }

    public ArrayList<String> enabledModulesConfig()
    {
        ArrayList<String> content = new ArrayList<>();

        for (Module enabledModule : ClientAPI.getModuleManager().getEnabledModules())
        {
            content.add(enabledModule.getName());
        }

        return content;
    }

    public ArrayList<String> settingsConfig()
    {
        ArrayList<String> content = new ArrayList<>();

        for (Setting setting : ClientAPI.getSettingManager().getSettings())
        {
            switch (setting.getType())
            {
                case BOOLEAN:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getBooleanValue()));
                    break;
                case INTEGER:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getIntegerValue()));
                    break;
                case FLOAT:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getFloatValue()));
                    break;
                case ENUM:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getEnumValue()));
                    break;
                case COLOR:
                    content.add(String.format("%s:%s:%s", setting.getName(), setting.getModule().getName(), setting.getColor().getRGB()));
                    break;
                default:
                    break;
            }
        }

        return content;
    }

    public ArrayList<String> prefixConfig()
    {
        return new ArrayList<>(Collections.singletonList(ClientAPI.getPrefix()));
    }

}
