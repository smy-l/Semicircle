package club.banyuan.servlet;

import club.banyuan.pojo.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistServlet", urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    String checkPwd = request.getParameter("checkPwd");
    String email = request.getParameter("email");
    String mobile = request.getParameter("mobile");

    User user = new User();
    user.setLoginName(loginName);
    user.setPassword(password);
    user.setEmail(email);
    user.setMobile(mobile);

    UserService userService = new UserServiceImpl();
    try {
      if (password.equals(checkPwd)) {
        User newUser = userService.register(user);
        response.sendRedirect("Login.html");
      } else {
        response.sendRedirect("Regist.html");
      }
    } catch (Exception e) {
      response.sendRedirect("Regist.html");
    }
  }
}
