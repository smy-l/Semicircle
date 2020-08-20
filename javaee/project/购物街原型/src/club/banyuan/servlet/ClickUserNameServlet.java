package club.banyuan.servlet;

import club.banyuan.pojo.User;
import club.banyuan.pojo.UserAddress;
import club.banyuan.service.UserAddressService;
import club.banyuan.service.impl.UserAddressServiceImpl;

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
    UserAddressService userAddressService = new UserAddressServiceImpl();
    try {
      User user = (User) session.getAttribute("user");
      List<UserAddress> addressList = userAddressService.getAdListByUserId(user.getId());
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
