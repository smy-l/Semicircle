package club.banyuan.service;

import club.banyuan.dto.User;
import club.banyuan.util.JdbcUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {

  // 根据用户id获取用户信息
  public User getUserById(int id) {
    // SQL 语句
    String sql = "select name, pwd, pwdConfirm, userType, userTypeStr from user where id = ?";
    Map<String, Object> map = JdbcUtil.queryOne(sql, id);
    return JSONObject.parseObject(JSONObject.toJSONString(map), User.class);
  }

  // 获取用户列表
  public List<User> getUserList() {
    // SQL 语句
    String sql = "select id, name, pwd, pwdConfirm, userType, userTypeStr from user";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql);
    return JSONObject.parseArray(JSONObject.toJSONString(list), User.class);
  }

  // 获取指定信息的用户列表
  public List<User> getUserList(User user) {
    List<User> userList = getUserList();
    List<User> list = new ArrayList<>();
    for (User u1 : userList) {
      if (u1.getName().contains(user.getName().trim())) {
        list.add(u1);
      }
    }
    return list;
  }


  //核实用户名以及密码是否正确
  public boolean login(String userName, String pwd) {
    List<User> userList = getUserList();
    for (User user1 : userList) {
      System.out.println(user1);
      System.out.println("userName: " + userName + "pwd: " + pwd);
      if (user1.getName().equals(userName) && user1.getPwd().equals(pwd)) {
        return true;
      }
    }
    return false;
  }

  // 更新用户信息
  public void updateUser(User user) {
    //根据用户id获取用户信息
    User u1 = getUserById(user.getId());
    if (u1 != null) {
      u1.setName(user.getName());
      u1.setPwd(user.getPwd());
      u1.setUserType(user.getUserType());
      u1.setUserTypeStr(user.getUserType() == 0 ? "普通用户" : "经理");
      u1.setPwdConfirm(user.getPwdConfirm());
      // SQL 语句
      String sql = "update user set name = ?, pwd = ?, userType = ?, userTypeStr = ?, pwdConfirm = ?";
      JdbcUtil.update(sql, u1.getName(), u1.getPwd(), u1.getUserType(), u1.getUserTypeStr(), u1.getPwdConfirm());
    }
  }

  // 新增用户信息
  public void insertUser(User user) {
    // SQL 语句
    String sql = "insert into user(name, pwd, userType, userTypeStr, pwdConfirm) values (?, ?, ?, ?, ?)";
    String userTypeStr = user.getUserType() == 0 ? "普通用户" : "经理";
    JdbcUtil.update(sql, user.getName(), user.getPwd(), user.getUserType(), userTypeStr, user.getPwdConfirm());
  }

  // 删除用户信息
  public void deleteUser(User user) {
    // SQL
    String sql = "delete from user where id = ?";
    JdbcUtil.update(sql, user.getId());
  }
}
