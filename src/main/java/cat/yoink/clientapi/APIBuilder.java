package cat.yoink.clientapi;

public class APIBuilder
{
    private String name;
    private String modID;
    private String version;

    public APIBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public APIBuilder withModID(String modID)
    {
        this.modID = modID;
        return this;
    }

    public APIBuilder withVersion(String version)
    {
        this.version = version;
        return this;
    }

    public ClientAPI build()
    {
        return new ClientAPI(name, modID, version);
    }
}
