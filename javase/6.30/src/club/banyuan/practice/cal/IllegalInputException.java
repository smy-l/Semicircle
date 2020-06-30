package club.banyuan.practice.cal;

public class IllegalInputException extends Exception{
    public IllegalInputException() {
    }

    public IllegalInputException(String message) {
        super(message);
    }

    public IllegalInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalInputException(Throwable cause) {
        super(cause);
    }

    public IllegalInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
