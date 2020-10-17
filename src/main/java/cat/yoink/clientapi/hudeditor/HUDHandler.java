package cat.yoink.clientapi.hudeditor;

import cat.yoink.clientapi.component.Component;
import net.minecraft.client.Minecraft;

public class HUDHandler
{
    private HUDEdit hudEdit;

    public final void display()
    {
        if (hudEdit == null) hudEdit = new HUDEdit();
        Minecraft.getMinecraft().displayGuiScreen(hudEdit);
    }

    public final void hide()
    {
        if (Minecraft.getMinecraft().currentScreen instanceof HUDEdit) Minecraft.getMinecraft().displayGuiScreen(null);
    }

    public void onOpen() { }
    public void onClose() { }
    public void render(int x, int y, int w, int h, int mouseX, int mouseY, Component component) { }
    public void clickComponent(int mouseX, int mouseY, int mouseButton, Component component) { }
    public void mouseReleased(int mouseX, int mouseY, int state) { }
    public boolean doesPauseGame() { return false; }

    public final void renderComponent(Component component)
    {
        component.render();
    }

    public final HUDEdit getHudEdit()
    {
        return hudEdit;
    }
}
