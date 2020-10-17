package cat.yoink.example.gui;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.component.Component;
import cat.yoink.clientapi.hudeditor.HUDHandler;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class HUDEditor extends HUDHandler
{
    private Component drag;
    private int dragX, dragY;

    @Override
    public void render(int x, int y, int w, int h, int mouseX, int mouseY, Component component)
    {
        if (component.equals(drag))
        {
            component.setX(dragX + mouseX);
            component.setY(dragY + mouseY);
        }

        Gui.drawRect(x - 2, y - 2, x + w + 2, y + h + 2, new Color(0x92FFFFFF, true).getRGB());
        renderComponent(component);
    }

    @Override
    public void clickComponent(int mouseX, int mouseY, int mouseButton, Component component)
    {
        if (mouseButton == 0)
        {
            drag = component;
            dragX = component.getX() - mouseX;
            dragY = component.getY() - mouseY;
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state)
    {
        drag = null;
    }

    @Override
    public void onClose()
    {
        ClientAPI.getModuleManager().getModule("HUDEditor").disable();
    }
}
