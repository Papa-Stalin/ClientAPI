package cat.yoink.example.component;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.component.Component;
import cat.yoink.clientapi.component.ClientComponent;

@ClientComponent(name = "Watermark")
public class Watermark extends Component
{
    @Override
    public void render()
    {
        mc.fontRenderer.drawStringWithShadow(ClientAPI.getName(), getX(), getY(), ClientAPI.getSettingManager().getSetting(getName(), "Color").getColor().getRGB());

        setW(mc.fontRenderer.getStringWidth(ClientAPI.getName()));
        setH(mc.fontRenderer.FONT_HEIGHT);
    }
}
