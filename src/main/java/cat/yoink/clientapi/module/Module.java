package cat.yoink.clientapi.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module
{
    public Minecraft mc = Minecraft.getMinecraft();
    private final String name = getClass().getAnnotation(Mod.class).name();
    private final Category category = getClass().getAnnotation(Mod.class).category();
    private final String description = getClass().getAnnotation(Mod.class).description();
    private final int bind = getClass().getAnnotation(Mod.class).bind();
    private final boolean visible = getClass().getAnnotation(Mod.class).visible();
    private boolean enabled;

    public void onEnable() { }
    public void onDisable() { }

    public final void enable()
    {
        setEnabled(true);
        if (!nullCheck()) onEnable();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public final void disable()
    {
        setEnabled(false);
        if (!nullCheck()) onDisable();
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public final void toggle()
    {
        if (enabled) disable();
        else enable();
    }

    public final boolean nullCheck()
    {
        return mc.player == null || mc.world == null;
    }

    public final String getName()
    {
        return name;
    }

    public final Category getCategory()
    {
        return category;
    }

    public final String getDescription()
    {
        return description;
    }

    public final int getBind()
    {
        return bind;
    }

    public final boolean isVisible()
    {
        return visible;
    }

    public final boolean isEnabled()
    {
        return enabled;
    }

    public final void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }
}
