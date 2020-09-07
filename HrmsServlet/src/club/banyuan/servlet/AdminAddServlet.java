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

@WebServlet(name = "AdminAddServlet")
public class AdminAddServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    Admin admin = new Admin();
    admin.setUsername(username);
    admin.setPassword(password);
    String url = "adminManage.html";
    AdminService adminService = new AdminServiceImpl();
    try {
      int i = adminService.addAdmin(admin);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
