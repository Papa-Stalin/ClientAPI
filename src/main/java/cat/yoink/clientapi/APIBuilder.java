package cat.yoink.clientapi;

import cat.yoink.clientapi.exception.InitializationException;

public class APIBuilder
{
    private String name;
    private String modID;
    private String version;
    private String loggerPrefix;
    private String folderName;
    private String prefix;

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

    public APIBuilder withLoggerPrefix(String loggerPrefix)
    {
        this.loggerPrefix = loggerPrefix;
        return this;
    }

    public APIBuilder withFolderName(String folderName)
    {
        this.folderName = folderName;
        return this;
    }

    public APIBuilder withPrefix(String prefix)
    {
        this.prefix = prefix;
        return this;
    }

    public ClientAPI build() throws InitializationException
    {
        return new ClientAPI(this);
    }

    public String getName()
    {
        return name;
    }

    public String getModID()
    {
        return modID;
    }

    public String getVersion()
    {
        return version;
    }

    public String getLoggerPrefix()
    {
        return loggerPrefix;
    }

    public String getFolderName()
    {
        return folderName;
    }

    public String getPrefix()
    {
        return prefix;
    }
}
