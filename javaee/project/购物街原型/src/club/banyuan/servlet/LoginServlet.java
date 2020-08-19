package club.banyuan.servlet;

import club.banyuan.pojo.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");

    String url = "Login.jsp";
    UserService userService = new UserServiceImpl();
    try {
      User checkUser = userService.login(loginName, password);
      if (checkUser != null) {
//        request.setAttribute("user", checkUser);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1000);
        session.setAttribute("user", checkUser);
        url = "index.jsp";
      } else {
        request.setAttribute("errorMsg", "用户名或者密码错误");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    request.getRequestDispatcher(url).forward(request,response);
  }
}
