public class BindingException extends Exception
{

    private static final long serialVersionUID = 2015L;

    public BindingException()
    {
        
    }

    public BindingException(String message)
    {
        super(message);        
    }

    public BindingException(Throwable cause)
    {
        super(cause);       
    }

    public BindingException(String message, Throwable cause)
    {
        super(message, cause);        
    }

    public BindingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);        
    }

}
