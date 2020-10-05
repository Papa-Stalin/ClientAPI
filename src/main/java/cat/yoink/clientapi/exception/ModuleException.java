package cat.yoink.clientapi.exception;

public class ModuleException extends Exception
{
    public ModuleException()
    {
        super();
    }

    public ModuleException(String message)
    {
        super(message);
    }

    public ModuleException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ModuleException(Throwable cause)
    {
        super(cause);
    }

    protected ModuleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
