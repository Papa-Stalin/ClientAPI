package cat.yoink.example;

import cat.yoink.clientapi.APIBuilder;
import cat.yoink.clientapi.ClientAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Client.MOD_ID, name = Client.MOD_NAME, version = Client.VERSION)
public class Client
{
    public static final String MOD_ID = "client";
    public static final String MOD_NAME = "Client";
    public static final String VERSION = "1";

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event)
    {
        ClientAPI api = new APIBuilder().withName(MOD_NAME).withModID(MOD_ID).withVersion(VERSION).build();

        api.initialize();

        ClientAPI.Configuration.setChatlogPrefix("&7[&1ClientName&7]");
        ClientAPI.Configuration.setConfigFolderName("client config");
        ClientAPI.Configuration.setCommandPrefix("=");

        api.loadConfig();

    }
}
