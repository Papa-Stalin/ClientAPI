package cat.yoink.clientapi.setting;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.module.Module;

import java.awt.*;
import java.util.ArrayList;

public class SettingBuilder
{
    private String name;
    private Module module;
    private final SettingType type;

    private boolean booleanValue;

    private int integerValue;
    private int minIntegerValue;
    private int maxIntegerValue;

    private float floatValue;
    private float minFloatValue;
    private float maxFloatValue;

    private String enumValue;
    private ArrayList<String> enumValues;

    private Color color;

    public SettingBuilder(SettingType type)
    {
        this.type = type;
    }

    public SettingBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public SettingBuilder withModule(Module module)
    {
        this.module = module;
        return this;
    }

    public SettingBuilder withBooleanValue(Boolean booleanValue)
    {
        this.booleanValue = booleanValue;
        return this;
    }

    public SettingBuilder withIntegerValue(int integerValue)
    {
        this.integerValue = integerValue;
        return this;
    }

    public SettingBuilder withMinIntegerValue(int maxIntegerValue)
    {
        this.maxIntegerValue = maxIntegerValue;
        return this;
    }

    public SettingBuilder withMaxIntegerValue(int minIntegerValue)
    {
        this.minIntegerValue = minIntegerValue;
        return this;
    }

    public SettingBuilder withFloatValue(float floatValue)
    {
        this.floatValue = floatValue;
        return this;
    }

    public SettingBuilder withMinFloatValue(float minFloatValue)
    {
        this.minFloatValue = minFloatValue;
        return this;
    }

    public SettingBuilder withMaxFloatValue(float maxFloatValue)
    {
        this.maxFloatValue = maxFloatValue;
        return this;
    }

    public SettingBuilder withEnumValue(String enumValue)
    {
        this.enumValue = enumValue;
        return this;
    }

    public SettingBuilder withEnumValues(ArrayList<String> enumValues)
    {
        this.enumValues = enumValues;
        return this;
    }

    public SettingBuilder addEnumValue(String enumValue)
    {
        if (enumValues == null) enumValues = new ArrayList<>();
        enumValues.add(enumValue);
        return this;
    }

    public SettingBuilder withColor(Color color)
    {
        this.color = color;
        return this;
    }

    public Setting build()
    {
        switch (type)
        {
            case BOOLEAN:
                Setting boolSetting = new Setting(name, module, booleanValue);
                ClientAPI.getSettingManager().addSetting(boolSetting);
                return boolSetting;
            case INTEGER:
                Setting intSetting = new Setting(name, module, integerValue, minIntegerValue, maxIntegerValue);
                ClientAPI.getSettingManager().addSetting(intSetting);
                return intSetting;
            case FLOAT:
                Setting floatSetting = new Setting(name, module, floatValue, minFloatValue, maxFloatValue);
                ClientAPI.getSettingManager().addSetting(floatSetting);
                return floatSetting;
            case ENUM:
                Setting enumSetting = new Setting(name, module, enumValue, enumValues);
                ClientAPI.getSettingManager().addSetting(enumSetting);
                return enumSetting;
            case COLOR:
                Setting colorSetting = new Setting(name, module, color);
                ClientAPI.getSettingManager().addSetting(colorSetting);
                return colorSetting;
            default:
                return null;
        }
    }
}
