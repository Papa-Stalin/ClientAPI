package cat.yoink.clientapi.hudeditor;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.component.Component;
import net.minecraft.client.gui.GuiScreen;

public class HUDEdit extends GuiScreen
{
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        for (Component component : ClientAPI.getComponentManager().getComponents())
        {
            ClientAPI.getHudEditor().render(component.getX(), component.getY(), component.getW(), component.getH(), mouseX, mouseY, component);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        for (Component component : ClientAPI.getComponentManager().getComponents())
        {
            if (isHover(component.getX(), component.getY(), component.getW(), component.getH(), mouseX, mouseY))
            {
                ClientAPI.getHudEditor().clickComponent(mouseX, mouseY, mouseButton, component);
            }
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        ClientAPI.getHudEditor().mouseReleased(mouseX, mouseY, state);
    }

    @Override
    public void initGui()
    {
        ClientAPI.getHudEditor().onOpen();
    }

    @Override
    public void onGuiClosed()
    {
        ClientAPI.getHudEditor().onClose();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return ClientAPI.getHudEditor().doesPauseGame();
    }



    private boolean isHover(int X, int Y, int W, int H, int mX, int mY)
    {
        return mX >= X && mX <= X + W && mY >= Y && mY <= Y + H;
    }
}
