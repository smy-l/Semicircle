package club.banyuan.admin.controller;

import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
/**
 * 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录；
 *
 * 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。
 *
 * 若类定义处未标注 @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录
 *
 * 返回ModelAndView时的url会根据你的 @RequestMapping实际情况组成。
 *
 * 如果类上没有映射，那么url直接就是方法的映射；否则url为类上+方法上映射路径组合。
 *
 * 对应项目jsp位置则是一级路径对应一级文件目录。
 */
@RequestMapping("/admin")
public class AdminController {

  // 这里会自动寻找adminService，找到AdminService接口，会找到其实现类
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
    List<Admin> adminList = adminService.getAdminList(username);
    int total = adminService.getAdminListCount(username);
    Map<String, Object> rlt = new HashMap<>();
    rlt.put("rows", adminList);
    rlt.put("total", total);
    rlt.put("code", 0);
    rlt.put("message", "");
    System.out.println(rlt);
    return rlt;
  }

  @RequestMapping("/info")
  // @ResponseBody 表示方法返回的对象自动序列化为json
  @ResponseBody
  public Map<String, Object> getAdminInfo(HttpSession session) {
    Map<String, Object> rlt = new HashMap<>();
    Object attribute = session.getAttribute(Constant.ADMIN_SESSION);
    if (attribute != null) {
      rlt.put("username", ((Admin) attribute).getUsername());
      rlt.put("code", 0);
      rlt.put("message", "");
    } else {
      rlt.put("code", 1);
      rlt.put("message", "用户未登录");
    }
    return rlt;
  }

  @RequestMapping("/save")
  @ResponseBody
  public Map<String, Object> modifyAdmin(Integer id, String username, String password) {
    Admin admin = new Admin();
    admin.setPassword(password);
    admin.setUsername(username);
    if (id == null) {
      adminService.addAdmin(admin);
    } else {
      admin.setId(id);
      adminService.updateAdmin(admin);
    }
    Map<String, Object> rlt = new HashMap<>();
    rlt.put("code", 0);
    rlt.put("message", "");
    return rlt;
  }

  @RequestMapping("/logout")
  public String logoutAdmin(HttpSession session) {
    // session置为失效
    session.invalidate();
    return "redirect:/login.html";
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Map<String, Object> deleteAdmin(String ids) {
    String[] idStr = ids.split(",");
    List<String> idList = new ArrayList<>();
    Collections.addAll(idList, idStr);
    adminService.deleteAdmins(idList);

    Map<String, Object> rlt = new HashMap<>();
    rlt.put("code", 0);
    rlt.put("message", "");
    return rlt;
  }

}
