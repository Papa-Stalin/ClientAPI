package cat.yoink.example.module;

import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.Mod;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.setting.Setting;
import cat.yoink.clientapi.setting.SettingBuilder;
import cat.yoink.clientapi.setting.SettingType;
import org.lwjgl.input.Keyboard;

import java.awt.*;

@Mod(name = "Watermark", category = Category.HUD, bind = Keyboard.KEY_Z)
public class WatermarkModule extends Module
{
    private final Setting color = new SettingBuilder(SettingType.COLOR)
            .withName("Color")
            .withModule(this)
            .withColor(new Color(255, 0, 0))
            .build();
}
