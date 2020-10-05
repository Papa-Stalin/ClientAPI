package cat.yoink.example;

import cat.yoink.clientapi.APIBuilder;
import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.exception.InitializationException;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Client.MOD_ID, name = Client.MOD_NAME, version = Client.VERSION)
public class Client
{
    public static final String MOD_ID = "client";
    public static final String MOD_NAME = "Client";
    public static final String VERSION = "1";

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) throws InitializationException
    {
        ClientAPI api = new APIBuilder()
                .withName(MOD_NAME)
                .withModID(MOD_ID)
                .withVersion(VERSION)
                .withPrefix("-")
                .withLoggerPrefix("[ClientName]")
                .withFolderName("MyClient")
                .build();

        api.initialize();
        api.loadConfig();
    }
}
