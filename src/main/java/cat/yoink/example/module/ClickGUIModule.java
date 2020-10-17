package cat.yoink.example.module;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.ClientModule;
import cat.yoink.clientapi.module.Module;
import org.lwjgl.input.Keyboard;

@ClientModule(name = "ClickGUI", category = Category.CLIENT, bind = Keyboard.KEY_RSHIFT)
public class ClickGUIModule extends Module
{
    @Override
    public void onEnable()
    {
        ClientAPI.getClickGUI().display();
    }
}
