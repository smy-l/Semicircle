package club.banyuan.servlet;

import club.banyuan.pojo.Product;
import club.banyuan.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckProStockServlet", urlPatterns = "/checkStock.do")
public class CheckProStockServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    int proNum = Integer.parseInt(request.getParameter("proNum"));
    int proId = Integer.parseInt(request.getParameter("proId"));
    ProductServiceImpl productService = new ProductServiceImpl();
    System.out.println(proNum + "  " + proId + "进入成功");

    PrintWriter out = response.getWriter();
    try {
      Product productById = productService.getProductById(proId);
      System.out.println(productById.getStock() > proNum);
      out.println(productById.getStock() >= proNum ? 1 : 0);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
