package cat.yoink.clientapi.module;

public enum Category
{
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    RENDER("Render"),
    EXPLOIT("Exploit"),
    WORLD("World"),
    MISC("Miscellaneous"),
    HUD("HUD"),
    CLIENT("Client"),
    HIDDEN("Hidden");

    private final String name;
    private int x;
    private int y;
    private boolean open;

    Category(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public boolean isOpen()
    {
        return open;
    }

    public void setOpen(boolean open)
    {
        this.open = open;
    }
}
