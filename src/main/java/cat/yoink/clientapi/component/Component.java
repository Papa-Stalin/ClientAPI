package cat.yoink.clientapi.component;

import cat.yoink.clientapi.MinecraftInstance;

public class Component implements MinecraftInstance
{
    private final String name = getClass().getAnnotation(ClientComponent.class).name();
    private int x = getClass().getAnnotation(ClientComponent.class).x();
    private int y = getClass().getAnnotation(ClientComponent.class).y();
    private int w = getClass().getAnnotation(ClientComponent.class).width();
    private int h = getClass().getAnnotation(ClientComponent.class).height();
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
