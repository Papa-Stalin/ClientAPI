package cat.yoink.clientapi.command;

import cat.yoink.clientapi.ClientAPI;
import cat.yoink.clientapi.event.CommandTriggerEvent;
import cat.yoink.clientapi.util.LoggerUtil;
import net.minecraftforge.common.MinecraftForge;
import org.reflections.Reflections;

import java.util.ArrayList;

public class CommandManager
{
    private final ArrayList<Command> commands = new ArrayList<>();

    public CommandManager()
    {
        for (Class<?> aClass : new Reflections(ClientAPI.getMasterPackage() != null ? ClientAPI.getMasterPackage().getName() : "").getSubTypesOf(Command.class))
        {
            try { commands.add((Command) aClass.getConstructor().newInstance()); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void runCommand(String message)
    {
        boolean found = false;
        String[] split = message.split(" ");
        String startCommand = split[0];
        String args = message.substring(startCommand.length()).trim();

        for (Command command : getCommands())
        {
            for (String alias : command.getAliases())
            {
                if (startCommand.equals(ClientAPI.getPrefix() + alias))
                {
                    MinecraftForge.EVENT_BUS.post(new CommandTriggerEvent(command, message));
                    command.onRun(args);
                    found = true;
                }
            }
        }

        if (!found)
        {
            LoggerUtil.sendMessage("Unknown command");
        }
    }

    public ArrayList<Command> getCommands()
    {
        return commands;
    }
}
