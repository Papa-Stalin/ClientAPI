package cat.yoink.example.module;

import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.Mod;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.util.LoggerUtil;
import org.lwjgl.input.Keyboard;

@Mod(name = "Watermark", category = Category.RENDER, bind = Keyboard.KEY_Z)
public class Watermark extends Module
{
    @Override
    public void onEnable()
    {
        LoggerUtil.sendMessage("Now showing watermark!");
    }

    @Override
    public void onDisable()
    {
        LoggerUtil.sendMessage("No longer showing watermark!");
    }
}