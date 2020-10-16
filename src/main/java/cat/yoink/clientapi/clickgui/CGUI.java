package cat.yoink.clientapi.clickgui;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.Module;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class CGUI extends GuiScreen
{
    private final int width;
    private final int height;

    public CGUI(int width, int height)
    {
        this.width = width;
        this.height = height;

        int xOffset = 3;
        for (Category category : Category.values())
        {
            category.setOpen(true);
            category.setX(xOffset);
            category.setY(3);
            xOffset += width + 3;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        for (Category category : Category.values())
        {
            int x = category.getX();
            int y = category.getY();
            ClientAPI.getClickGUI().drawCategory(x, y, width, height, mouseX, mouseY, category);

            for (Module module : ClientAPI.getModuleManager().getModules(category))
            {
                y += height;

                ClientAPI.getClickGUI().drawModule(x, y, width, height, mouseX, mouseY, module);
            }
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        for (Category category : Category.values())
        {
            int x = category.getX();
            int y = category.getY();
            if (isHover(x, y, width, height, mouseX, mouseY)) ClientAPI.getClickGUI().clickCategory(mouseX, mouseY, mouseButton, category);

            for (Module module : ClientAPI.getModuleManager().getModules(category))
            {
                y += height;

                if (isHover(x, y, width, height, mouseX, mouseY)) ClientAPI.getClickGUI().clickModule(mouseX, mouseY, mouseButton, module);
            }
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        ClientAPI.getClickGUI().mouseReleased(mouseX, mouseY, state);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        super.keyTyped(typedChar, keyCode);

        ClientAPI.getClickGUI().keyTyped(typedChar, keyCode);
    }

    @Override
    public void initGui()
    {
        ClientAPI.getClickGUI().onOpen();
    }

    @Override
    public void onGuiClosed()
    {
        ClientAPI.getClickGUI().onClose();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return ClientAPI.getClickGUI().doesPauseGame();
    }

    private boolean isHover(int X, int Y, int W, int H, int mX, int mY)
    {
        return mX >= X && mX <= X + W && mY >= Y && mY <= Y + H;
    }



    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
