package club.banyuan.common;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    Object attribute = request.getSession().getAttribute(Constant.USER_SESSION);
    if (attribute == null) {
      System.out.println(request.getServletPath());
      if (request.getServletPath().endsWith(".html")) {
        System.out.println("用户未登录，转到login");
        response.sendRedirect(request.getContextPath() + "/login.html");
        return false;
      } else {
        System.out.println("/server出错");
        throw new ServerException("用户未登录");
      }
    }
    return true;
  }
}
