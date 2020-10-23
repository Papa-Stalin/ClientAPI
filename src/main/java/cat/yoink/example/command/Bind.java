package cat.yoink.example.command;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.command.ClientCommand;
import cat.yoink.clientapi.command.Command;
import cat.yoink.clientapi.module.Module;
import cat.yoink.clientapi.util.LoggerUtil;
import org.lwjgl.input.Keyboard;

@ClientCommand(name = "Bind", description = "Bind modules to keys", aliases = { "b", "bind" }, usage = "bind <module> <key>")
public class Bind extends Command
{
    @Override
    public void onRun(String arguments)
    {
        String[] split = arguments.split(" " );

        Module module = ClientAPI.getModuleManager().getModule(split[0]);

        if (module != null)
        {
            try
            {
                module.setBind(Keyboard.getKeyIndex(split[1].toUpperCase()));
                LoggerUtil.sendMessage(String.format("Bound %s to %s", module.getName(), split[1].toUpperCase()));
                return;
            }
            catch (Exception ignored)
            {
            }
        }

        printUsage();
    }
}
