package cat.yoink.example.component;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.component.Component;
import cat.yoink.clientapi.component.HUD;

@HUD(name = "Watermark")
public class Watermark extends Component
{
    @Override
    public void render()
    {
        mc.fontRenderer.drawStringWithShadow(ClientAPI.getName(), getX(), getY(), -1);
        setW(mc.fontRenderer.getStringWidth(ClientAPI.getName()));
        setH(mc.fontRenderer.FONT_HEIGHT);
    }
}
