package club.banyuan.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ControllerAdvice
public class ServerExceptionHandler {

  /**
   * 拦截所有的controller抛出的ServerException 异常，返回失败原因
   *
   * @param e
   * @return
   */
  @ExceptionHandler(ServerException.class)
//  @ResponseStatus(HttpStatus.OK)
//  @ResponseBody
  public void handleServerException(Exception e, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
    if ("用户未登录".equals(e.getMessage())) {
      System.out.println("拦截异常1");
      response.sendRedirect(request.getContextPath() + "/login.html");
    } else {
      System.out.println("拦截异常2");
//      request.setAttribute("msg", e.getMessage());
      request.setAttribute("msg", e.getMessage());
      request.getRequestDispatcher("form_post_fail.html").forward(request, response);
//      response.sendRedirect(request.getContextPath() + "/form_post_fail.html");
    }
  }

//  @ExceptionHandler(Exception.class)
//  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//  @ResponseBody
//  public RespResult handleException(Exception e) {
//    e.printStackTrace();
//    return RespResult.fail("服务器异常");
//  }
}
