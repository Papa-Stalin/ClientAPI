package cat.yoink.clientapi;

import cat.yoink.clientapi.clickgui.ClickHandler;
import cat.yoink.clientapi.hudeditor.HUDHandler;

public class APIBuilder
{
    private String name;
    private String modID;
    private String version;
    private String loggerPrefix;
    private String folderName;
    private String prefix;
    private ClickHandler clickGUI;
    private HUDHandler hudEditor;
    private Package masterPackage;

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

    public APIBuilder withClickGUI(ClickHandler clickGUI)
    {
        this.clickGUI = clickGUI;
        return this;
    }

    public APIBuilder withHUDEditor(HUDHandler hudHandler)
    {
        this.hudEditor = hudHandler;
        return this;
    }

    public APIBuilder withMasterPackage(Package masterPackage)
    {
        this.masterPackage = masterPackage;
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

    public ClickHandler getClickGUI()
    {
        return clickGUI;
    }

    public HUDHandler getHUDEditor()
    {
        return hudEditor;
    }

    public Package getMasterPackage()
    {
        return masterPackage;
    }
}
