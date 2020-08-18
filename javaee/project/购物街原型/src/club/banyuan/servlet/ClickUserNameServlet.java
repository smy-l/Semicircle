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

@WebServlet(name = "ClickUserNameServlet", urlPatterns = "/clickUserName.do")
public class ClickUserNameServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    System.out.println(loginName);
    UserService userService = new UserServiceImpl();
    try {
      User user = userService.getUserInfoByLoginName(loginName);
      System.out.println(user);
      request.setAttribute("user", user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    request.getRequestDispatcher("Member_Address.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
