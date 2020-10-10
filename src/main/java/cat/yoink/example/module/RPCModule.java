package cat.yoink.example.module;

import cat.yoink.clientapi.discord.Discord;
import cat.yoink.clientapi.discord.RPCBuilder;
import cat.yoink.clientapi.module.Category;
import cat.yoink.clientapi.module.Mod;
import cat.yoink.clientapi.module.Module;
import org.lwjgl.input.Keyboard;

@Mod(name = "DiscordRPC", category = Category.MISC, bind = Keyboard.KEY_O)
public class RPCModule extends Module
{
    public static Discord discordRPC = new RPCBuilder("764139387457765377").withDetails("Details").withState("State").withLargeImageKey("bigtest").withLargeImageText("Large image text").build();

    @Override
    public void onEnable()
    {
        discordRPC.start();
    }

    @Override
    public void onDisable()
    {
        discordRPC.stop();
    }
}
