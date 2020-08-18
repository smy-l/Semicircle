package club.banyuan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistServlet", urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet {
  // 处理以 post 方式提交的请求
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  // 处理以 get 方式提交的请求
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    String checkPwd = request.getParameter("checkPwd");


    PrintWriter out = response.getWriter();

    out.write("<html><body>");
    out.write("RegistServlet");
    out.write("</body></html>");
    out.flush();
    out.close();
  }
}
