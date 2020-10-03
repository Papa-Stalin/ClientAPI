package cat.yoink.clientapi.component;

import net.minecraft.client.Minecraft;

public class Component
{
    public Minecraft mc = Minecraft.getMinecraft();
    private final String name = getClass().getAnnotation(HUD.class).name();
    private int x = getClass().getAnnotation(HUD.class).x();
    private int y = getClass().getAnnotation(HUD.class).y();
    private int w = getClass().getAnnotation(HUD.class).width();
    private int h = getClass().getAnnotation(HUD.class).height();
    private boolean showing;

    public void render() { }

    public final String getName()
    {
        return name;
    }

    public final int getX()
    {
        return x;
    }

    public final void setX(int x)
    {
        this.x = x;
    }

    public final int getY()
    {
        return y;
    }

    public final void setY(int y)
    {
        this.y = y;
    }

    public final int getW()
    {
        return w;
    }

    public final void setW(int w)
    {
        this.w = w;
    }

    public final int getH()
    {
        return h;
    }

    public final void setH(int h)
    {
        this.h = h;
    }

    public boolean isShowing()
    {
        return showing;
    }

    public void setShowing(boolean showing)
    {
        this.showing = showing;
    }
}
