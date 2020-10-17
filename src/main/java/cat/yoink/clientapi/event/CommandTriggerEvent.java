package cat.yoink.clientapi.event;

import cat.yoink.clientapi.command.Command;
import net.minecraftforge.fml.common.eventhandler.Event;

public class CommandTriggerEvent extends Event
{
    private final Command command;
    private final String message;

    public CommandTriggerEvent(Command command, String message)
    {
        this.command = command;
        this.message = message;
    }

    public Command getCommand()
    {
        return command;
    }

    public String getMessage()
    {
        return message;
    }
}
