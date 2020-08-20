package club.banyuan.servlet;

import club.banyuan.pojo.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    String isSave = request.getParameter("isSave");
    String url = "Login.jsp";
    UserService userService = new UserServiceImpl();
    try {
      User checkUser = userService.login(loginName, password);
      if (checkUser != null) {
//        request.setAttribute("user", checkUser);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 10);
        session.setAttribute("user", checkUser);
        url = "index.jsp";

        // 是否保存，cookie
        if ("true".equals(isSave)) {
          Cookie cookie = new Cookie("loginName", checkUser.getLoginName());
          cookie.setMaxAge(3600);
          response.addCookie(cookie);
        }

      } else {
        request.setAttribute("errorMsg", "用户名或者密码错误");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    request.getRequestDispatcher(url).forward(request, response);
  }
}
