package cat.yoink.example.module;

import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.ClientModule;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.setting.Setting;
import cat.yoink.clientapi.setting.SettingBuilder;
import cat.yoink.clientapi.setting.SettingType;
import cat.yoink.clientapi.util.LoggerUtil;
import org.lwjgl.input.Keyboard;

import java.awt.*;

@ClientModule(name = "Watermark", category = Category.HUD, bind = Keyboard.KEY_Z)
public class WatermarkModule extends Module
{
    private final Setting color = new SettingBuilder(SettingType.COLOR)
            .withName("Color")
            .withModule(this)
            .withColor(new Color(255, 0, 0))
            .build();

    @Override
    public void onEnable()
    {
        LoggerUtil.sendMessage("Current color: " + color.getColor().toString());
    }
}
