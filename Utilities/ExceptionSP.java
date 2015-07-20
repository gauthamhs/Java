public class StoredProcedureException extends PolicyPlatformException {

  public StoredProcedureException() {
    super();
     }

  public StoredProcedureException(ErrorCodes errorCode, Throwable cause) {
    super(errorCode, cause);
    }

  public StoredProcedureException(ErrorCodes errorCode) {
    super(errorCode);
    }

  public StoredProcedureException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
     }

  public StoredProcedureException(String message, Throwable cause) {
    super(message, cause);
    }

  public StoredProcedureException(String message) {
    super(message);
     }

  public StoredProcedureException(Throwable cause) {
    super(cause);
      }
 
}
