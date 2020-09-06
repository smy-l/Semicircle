package club.banyuan.servlet;

import club.banyuan.pojo.Admin;
import club.banyuan.service.AdminService;
import club.banyuan.service.imp.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/admin/login")
public class AdminLoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    String username = request.getParameter("username");
    String pwd = request.getParameter("password");
    AdminService adminService = new AdminServiceImpl();
    String url = "login.html";
    try {
      Admin admin = adminService.checkAdmin(username, pwd);
      if (admin != null) {
        url = "home_page.html";
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    request.getRequestDispatcher(url).forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
