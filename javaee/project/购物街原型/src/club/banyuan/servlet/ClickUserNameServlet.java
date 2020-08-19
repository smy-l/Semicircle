package club.banyuan.servlet;

import club.banyuan.pojo.User;
import club.banyuan.pojo.User_address;
import club.banyuan.service.UserService;
import club.banyuan.service.User_addressService;
import club.banyuan.service.impl.UserServiceImpl;
import club.banyuan.service.impl.User_addressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClickUserNameServlet", urlPatterns = "/clickUserName.do")
public class ClickUserNameServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    User_addressService user_addressService = new User_addressServiceImpl();
    try {
      User user = (User) session.getAttribute("user");
      List<User_address> addressList = user_addressService.getAdListByUserId(user.getId());
      session.setAttribute("addressList", addressList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    request.getRequestDispatcher("Member_Address.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
