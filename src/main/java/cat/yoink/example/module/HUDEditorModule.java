package cat.yoink.example.module;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.Mod;
import cat.yoink.clientapi.module.Module;
import org.lwjgl.input.Keyboard;

@Mod(name = "HudEditor", category = Category.CLIENT, bind = Keyboard.KEY_GRAVE)
public class HUDEditorModule extends Module
{
    @Override
    public void onEnable()
    {
        ClientAPI.getHudEditor().display();
    }
}
