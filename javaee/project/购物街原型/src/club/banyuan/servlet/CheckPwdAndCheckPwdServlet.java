package club.banyuan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckPwdAndCheckPwdServlet", urlPatterns = "/checkPwdAndCheckPwd.do")
public class CheckPwdAndCheckPwdServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String pwd = request.getParameter("pwd");
    String checkPwd = request.getParameter("checkPwd");
    System.out.println(pwd + checkPwd);
    PrintWriter out = response.getWriter();
    out.print(pwd.equals(checkPwd) ? 1 : 0);
    out.flush();
    out.close();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
