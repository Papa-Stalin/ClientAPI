package cat.yoink.clientapi.discord;

public class DiscordRPC
{
    private final String id;
    private String details;
    private String state;
    private final String largeImageKey;
    private String largeImageText;
    private final String smallImageKey;
    private String smallImageText;

    public DiscordRPC(RPCBuilder builder)
    {
        this.id = builder.getId();

        if (builder.getDetails() == null) details = "";
        else details = builder.getDetails();
        if (builder.getState() == null) state = "";
        else state = builder.getState();

        if (builder.getLargeImageKey() == null) largeImageKey = "";
        else largeImageKey = builder.getLargeImageKey();
        if (builder.getLargeImageText() == null) largeImageText = "";
        else largeImageText = builder.getLargeImageText();

        if (builder.getSmallImageKey() == null) smallImageKey = "";
        else smallImageKey = builder.getSmallImageKey();
        if (builder.getSmallImageText() == null) smallImageText = "";
        else smallImageText = builder.getSmallImageText();
    }

    public void start() { }
    public void stop() { }

    public String getId()
    {
        return id;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getLargeImageKey()
    {
        return largeImageKey;
    }

    public String getLargeImageText()
    {
        return largeImageText;
    }

    public void setLargeImageText(String largeImageText)
    {
        this.largeImageText = largeImageText;
    }

    public String getSmallImageKey()
    {
        return smallImageKey;
    }

    public String getSmallImageText()
    {
        return smallImageText;
    }

    public void setSmallImageText(String smallImageText)
    {
        this.smallImageText = smallImageText;
    }
}
