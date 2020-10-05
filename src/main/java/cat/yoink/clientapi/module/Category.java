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
    CLIENT("Client");

    private final String name;

    Category(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
