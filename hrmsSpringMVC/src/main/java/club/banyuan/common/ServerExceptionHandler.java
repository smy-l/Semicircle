package club.banyuan.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice 实现全局异常处理
@ControllerAdvice
public class ServerExceptionHandler {

  /**
   * 拦截所有的controller抛出的ServerException 异常，返回失败原因
   *
   * @param e
   * @return
   */
  // @ExceptionHandler 专门处理括号里的错误类
  @ExceptionHandler(ServerException.class)
  // @ResponseStatus 用来处理返回的服务器代码，如404，200，500等
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public RespResult handleServerException(Exception e) {
    e.printStackTrace();
    return RespResult.fail(e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public RespResult handleException(Exception e) {
    e.printStackTrace();
    return RespResult.fail("服务器异常");
  }
}
