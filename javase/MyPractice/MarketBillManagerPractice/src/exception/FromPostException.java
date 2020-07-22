package exception;

public class FromPostException extends Exception{
  public FromPostException() {
  }

  public FromPostException(String message) {
    super(message);
  }

  public FromPostException(String message, Throwable cause) {
    super(message, cause);
  }

  public FromPostException(Throwable cause) {
    super(cause);
  }

  public FromPostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
