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
import java.io.PrintWriter;

@WebServlet(name = "CheckLoginNameServlet", urlPatterns = "/checkLoginName.do")
public class CheckLoginNameServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    System.out.println("进入checkLoginName");
    String loginName = request.getParameter("loginName");
    UserService userService = new UserServiceImpl();
    try {
      User user = userService.checkLoginName(loginName);
      if (user != null) {
        System.out.println("检测到重复LoginName");
        PrintWriter out = response.getWriter();
        out.println(true);
        out.flush();
        out.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
