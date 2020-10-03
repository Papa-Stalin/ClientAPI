package cat.yoink.clientapi.setting;

import cat.yoink.clientapi.module.Module;

import java.awt.*;
import java.util.ArrayList;

public class Setting
{
    private final String name;
    private final Module module;
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

    public Setting(String name, Module module, Color color)
    {
        this.name = name;
        this.module = module;
        this.color = color;
        this.type = SettingType.COLOR;
    }

    public Setting(String name, Module module, String enumValue, ArrayList<String> enumValues)
    {
        this.name = name;
        this.module = module;
        this.enumValue = enumValue;
        this.enumValues = enumValues;
        this.type = SettingType.ENUM;
    }

    public Setting(String name, Module module, float floatValue, float minFloatValue, float maxFloatValue)
    {
        this.name = name;
        this.module = module;
        this.floatValue = floatValue;
        this.minFloatValue = minFloatValue;
        this.maxFloatValue = maxFloatValue;
        this.type = SettingType.FLOAT;
    }

    public Setting(String name, Module module, int integerValue, int minIntegerValue, int maxIntegerValue)
    {
        this.name = name;
        this.module = module;
        this.integerValue = integerValue;
        this.minIntegerValue = minIntegerValue;
        this.maxIntegerValue = maxIntegerValue;
        this.type = SettingType.INTEGER;
    }

    public Setting(String name, Module module, boolean booleanValue)
    {
        this.name = name;
        this.module = module;
        this.booleanValue = booleanValue;
        this.type = SettingType.BOOLEAN;
    }

    public String getName()
    {
        return name;
    }

    public Module getModule()
    {
        return module;
    }

    public SettingType getType()
    {
        return type;
    }

    public boolean getBooleanValue()
    {
        return booleanValue;
    }

    public int getIntegerValue()
    {
        return integerValue;
    }

    public int getMinIntegerValue()
    {
        return minIntegerValue;
    }

    public int getMaxIntegerValue()
    {
        return maxIntegerValue;
    }

    public float getFloatValue()
    {
        return floatValue;
    }

    public float getMinFloatValue()
    {
        return minFloatValue;
    }

    public float getMaxFloatValue()
    {
        return maxFloatValue;
    }

    public String getEnumValue()
    {
        return enumValue;
    }

    public ArrayList<String> getEnumValues()
    {
        return enumValues;
    }

    public Color getColor()
    {
        return color;
    }

    public void setBooleanValue(boolean booleanValue)
    {
        this.booleanValue = booleanValue;
    }

    public void setIntegerValue(int integerValue)
    {
        this.integerValue = integerValue;
    }

    public void setFloatValue(float floatValue)
    {
        this.floatValue = floatValue;
    }

    public void setEnumValue(String enumValue)
    {
        this.enumValue = enumValue;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
