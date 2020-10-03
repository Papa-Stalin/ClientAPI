package cat.yoink.clientapi.setting;

import java.util.ArrayList;

public class SettingManager
{
    private final ArrayList<Setting> settings = new ArrayList<>();

    public void addSetting(Setting setting)
    {
        settings.add(setting);
    }

    public ArrayList<Setting> getSettings()
    {
        return settings;
    }
}
