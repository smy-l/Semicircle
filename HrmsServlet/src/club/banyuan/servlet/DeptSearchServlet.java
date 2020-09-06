package club.banyuan.servlet;

import club.banyuan.pojo.Department;
import club.banyuan.service.DeptService;
import club.banyuan.service.imp.DeptServiceImpl;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DeptSearchServlet", urlPatterns = "/dept/list")
public class DeptSearchServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    DeptService deptService = new DeptServiceImpl();
    Map<String, Object> map = new HashMap<>();
    try {
      List<Department> departmentList = deptService.getDeptAll();
      if (departmentList != null) {
        map.put("total", departmentList.size());
        map.put("code", 0);
        map.put("rows", departmentList);
      } else {
        map.put("code", 1);
        map.put("message", "服务器异常");
      }
      String str = JSONObject.toJSONString(map);
      PrintWriter out = response.getWriter();
      out.print(str);
      out.flush();
      out.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);

  }
}
