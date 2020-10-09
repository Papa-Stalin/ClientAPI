package cat.yoink.example;

import cat.yoink.clientapi.APIBuilder;
import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.InitializationException;
import cat.yoink.clientapi.discord.DiscordRPC;
import cat.yoink.clientapi.discord.RPCBuilder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Client.MOD_ID, name = Client.MOD_NAME, version = Client.VERSION)
public class Client
{
    public static final String MOD_ID = "client";
    public static final String MOD_NAME = "Client";
    public static final String VERSION = "1";
    public static DiscordRPC discordRPC;

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) throws InitializationException
    {
        ClientAPI api = new APIBuilder()
                .withName(MOD_NAME)
                .withModID(MOD_ID)
                .withVersion(VERSION)
                .withPrefix("-")
                .withLoggerPrefix("&7[&cClientName&7]")
                .withFolderName("MyClient")
                .build();

        api.initialize();
        api.loadConfig();

        discordRPC = new RPCBuilder("764139387457765377")
                .withDetails("Details")
                .withState("State")
                .withLargeImageKey("BigTest")
                .withSmallImageKey("SmallTest")
                .build();

        discordRPC.start();
    }
}
