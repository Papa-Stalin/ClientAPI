package cat.yoink.example.command;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.command.Com;
import cat.yoink.clientapi.command.Command;
import cat.yoink.clientapi.util.LoggerUtil;

@Com(name = "Prefix", aliases = { "prefix" }, usage = "prefix <character>")
public class Prefix extends Command
{
    @Override
    public void onRun(String arguments)
    {
        if (arguments.equals(""))
        {
            printUsage();
            return;
        }

        ClientAPI.setCommandPrefix(arguments);
        LoggerUtil.sendMessage("Command prefix set to " + arguments);
    }
}
