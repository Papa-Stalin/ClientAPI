package cat.yoink.clientapi.module;

public class ModuleBuilder
{
    private String name;
    private Category category;
    private String description;
    private int bind;
    private boolean visible;
    private boolean enabled;

    public ModuleBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public ModuleBuilder withCategory(Category category)
    {
        this.category = category;
        return this;
    }

    public ModuleBuilder withDescription(String description)
    {
        this.description = description;
        return this;
    }

    public ModuleBuilder withBind(int bind)
    {
        this.bind = bind;
        return this;
    }

    public ModuleBuilder withVisible(boolean visible)
    {
        this.visible = visible;
        return this;
    }

    public ModuleBuilder withEnabled(boolean enabled)
    {
        this.enabled = enabled;
        return this;
    }

    public Module build() throws ModuleException
    {
        return new Module(this);
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
}