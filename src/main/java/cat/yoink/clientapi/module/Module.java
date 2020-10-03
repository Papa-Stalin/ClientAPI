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

    public void enable()
    {
        setEnabled(true);
        if (!nullCheck()) onEnable();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void disable()
    {
        setEnabled(false);
        if (!nullCheck()) onDisable();
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public void toggle()
    {
        if (enabled) disable();
        else enable();
    }

    public boolean nullCheck()
    {
        return mc.player == null || mc.world == null;
    }

    public String getName()
    {
        return name;
    }

    public Category getCategory()
    {
        return category;
    }

    public String getDescription()
    {
        return description;
    }

    public int getBind()
    {
        return bind;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }
}
