package club.banyuan.user.controller;

import club.banyuan.common.Constant;
import club.banyuan.common.ServerException;
import club.banyuan.user.entity.User;
import club.banyuan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public List<User> getUserList(@RequestBody(required = false) User user) {
    System.out.println(user);
    if (user == null) {
      return userService.getUserList();
    } else {
      return userService.getUserByName(user.getName());
    }
  }

  @RequestMapping("/get")
  @ResponseBody
  public User getUserById(@RequestBody User user) {
    return userService.getUserById(user.getId());
  }

  @RequestMapping("/modify")
  public String modifyUser(String id, String name, String pwd, String pwdConfirm, String userType) {
    System.out.println("查看id" + id);
    if ("0".equals(id)) {
      List<User> userByName = userService.getUserByName(name);
      System.out.println(userByName);
      if (userByName.size() != 0) {
        throw new ServerException("用户名已存在");
      }
    }
    if (!pwd.equals(pwdConfirm)) {
      throw new ServerException("两次密码输入不一致！");
    }

    User user = new User();
    user.setId(Integer.parseInt(id));
    user.setName(name);
    user.setPwd(pwd);
    int type = Integer.parseInt(userType);
    user.setUserType(type);
    user.setUserTypeStr(type == 0 ? "普通用户" : "经理");
    userService.saveUser(user);
    return "redirect:/user_list.html";
  }

  @RequestMapping("/delete")
  public ResponseEntity deleteUser(@RequestBody User user) {
    userService.deleteUser(user.getId());
    return new ResponseEntity(HttpStatus.OK);
  }

  @RequestMapping("/quit")
  public String quit(HttpSession session) {
    session.invalidate();
    return "redirect:/login.html";
  }

}
