package club.banyuan.common;

/*
* 创建一个封装类，集中处理异常
* */
public class ServerException extends RuntimeException {
  public ServerException() {
  }

  public ServerException(String message) {
    super(message);
  }

  public ServerException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServerException(Throwable cause) {
    super(cause);
  }

  public ServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
