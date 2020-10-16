package cat.yoink.clientapi.setting;

import cat.yoink.clientapi.module.Module;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SettingManager
{
    private final ArrayList<Setting> settings = new ArrayList<>();

    public void addSetting(Setting setting)
    {
        settings.add(setting);
    }

    public Setting getSetting(Module module, String name)
    {
        for (Setting setting : settings)
        {
            if (setting.getModule().equals(module) && setting.getName().equalsIgnoreCase(name))
            {
                return setting;
            }
        }

        return null;
    }

    public Setting getSetting(String moduleName, String settingName)
    {
        for (Setting setting : settings)
        {
            if (setting.getModule().getName().equalsIgnoreCase(moduleName) && setting.getName().equalsIgnoreCase(settingName))
            {
                return setting;
            }
        }

        return null;
    }

    public ArrayList<Setting> getSettings()
    {
        return settings;
    }

    public ArrayList<Setting> getSettings(Module module)
    {
        return getSettings().stream().filter(s -> s.getModule().equals(module)).collect(Collectors.toCollection(ArrayList::new));
    }
}
