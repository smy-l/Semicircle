package club.banyuan.user.controller;

import club.banyuan.common.Constant;
import club.banyuan.common.ServerException;
import club.banyuan.user.entity.UserListEntity;
import club.banyuan.user.entity.User;
import club.banyuan.user.service.UserService;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/server/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/getInfo")
  @ResponseBody
  public Map<String, String> getInfo(HttpSession session) {
    Object attribute = session.getAttribute(Constant.USER_SESSION);
    Map<String, String> rlt = new HashMap<>();
    if (attribute != null) {
      User user = (User) attribute;
      rlt.put("name", user.getName());
    }
    return rlt;
  }

  @RequestMapping("/login")
  public String login(String name, String pwd, HttpSession session) {
    User loginUser = userService.login(name, pwd);
    session.setAttribute(Constant.USER_SESSION, loginUser);
    if (loginUser == null) {
      return "redirect:/login.html";
    } else {
      return "redirect:/user_list.html";
    }
  }

  @RequestMapping("/list")
  @ResponseBody
  public List<User> getUserList(UserListEntity listEntity) {
    System.out.println(listEntity);
    if (listEntity.getName() == null) {
      return userService.getUserList();
    } else {
      return userService.getUserByName(listEntity.getName());
    }
  }

  @RequestMapping("/get")
  @ResponseBody
  public User getUserById(@RequestBody JSONObject jsonObject) {
    Object idObject = jsonObject.get("id");
    int id = Integer.parseInt(idObject.toString());
    return userService.getUserById(id);
  }

  //  id=0&name=1&pwd=2&pwdConfirm=3&userType=0
  @RequestMapping("/modify")
  public String modifyUser(String id, String name, String pwd, String pwdConfirm, String userType) {
    if (!pwd.equals(pwdConfirm)) {
      throw new ServerException("两次密码输入不正确！");
    }
//    System.out.println(id);
    User user = new User();
    user.setId(Integer.parseInt(id));
    user.setName(name);
    user.setPwd(pwd);
    int type = Integer.parseInt(userType);
    user.setUserType(type);
    user.setUserTypeStr(type == 0 ? "普通用户" : "经理");
//    System.out.println(user);
    userService.saveUser(user);
    return "redirect:/user_list.html";
  }

  @RequestMapping("/delete")
  public String deleteUser(@RequestBody JSONObject jsonObject) {
//    System.out.println(jsonObject);
    Object idObject = jsonObject.get("id");
    int id = Integer.parseInt(idObject.toString());
    userService.deleteUser(id);
    return "redirect:/user_list.html";
  }

  @RequestMapping("/quit")
  public String quit(HttpSession session) {
    session.invalidate();
    return "redirect:/login.html";
  }

}
