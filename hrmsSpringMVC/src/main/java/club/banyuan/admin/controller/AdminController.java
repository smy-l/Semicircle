package club.banyuan.admin.controller;

import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;

  // spring mvc自动解析浏览器发送的数据
  @RequestMapping("/login")
  public String login(String username, String password, HttpSession session) {
    Admin login = adminService.login(username, password);
    if (login == null) {
      return "redirect:/login.html";
    } else {
      session.setAttribute(Constant.ADMIN_SESSION, login);
      return "redirect:/home_page.html";
    }
  }

  @RequestMapping("/list")
  // 让spring将方法返回的对象自动序列化为json
  @ResponseBody
  public Map<String, Object> getAdminList(Integer page, Integer rows, String username) {
    List<Admin> adminList
  }


}
