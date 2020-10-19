package cat.yoink.clientapi.module;

import cat.yoink.clientapi.MinecraftInstance;
import cat.yoink.clientapi.event.ModuleToggleEvent;
import net.minecraftforge.common.MinecraftForge;

public class Module implements MinecraftInstance
{
    private final String name;
    private final Category category;
    private final String description;
    private int bind;
    private boolean visible;
    private boolean enabled;
    private boolean open;

    public void onEnable() { }
    public void onDisable() { }

    public Module()
    {
        this.name = getClass().getAnnotation(ClientModule.class).name();
        this.category = getClass().getAnnotation(ClientModule.class).category();
        this.description = getClass().getAnnotation(ClientModule.class).description();
        this.bind = getClass().getAnnotation(ClientModule.class).bind();
        this.visible = getClass().getAnnotation(ClientModule.class).visible();
        this.open = false;
    }

    public Module(ModuleBuilder builder) throws ModuleException
    {
        if (builder.getName() == null) throw new ModuleException("Module name not specified");
        if (builder.getCategory() == null) throw new ModuleException("Module category not specified");

        this.name = builder.getName();
        this.category = builder.getCategory();

        if (builder.getDescription() == null) this.description = "Descriptionless";
        else this.description = builder.getDescription();
        this.bind = builder.getBind();
        this.visible = builder.isVisible();
        this.enabled = builder.isEnabled();
        this.open = false;
    }

    public final void enable()
    {
        setEnabled(true);
        if (!nullCheck()) onEnable();
        MinecraftForge.EVENT_BUS.post(new ModuleToggleEvent(this, true));
        MinecraftForge.EVENT_BUS.register(this);
    }

    public final void disable()
    {
        setEnabled(false);
        if (!nullCheck()) onDisable();
        MinecraftForge.EVENT_BUS.post(new ModuleToggleEvent(this, false));
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

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    public void setBind(int bind)
    {
        this.bind = bind;
    }

    public void setOpen(boolean open)
    {
        this.open = open;
    }

    public boolean isOpen()
    {
        return open;
    }
}
