package exception;

public class MbmException extends Exception{
  public MbmException() {
  }

  public MbmException(String message) {
    super(message);
  }

  public MbmException(String message, Throwable cause) {
    super(message, cause);
  }

  public MbmException(Throwable cause) {
    super(cause);
  }

  public MbmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
