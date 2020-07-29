package club.banyuan.service;

import club.banyuan.dto.User;
import club.banyuan.exception.FormPostException;
import club.banyuan.util.JdbcUtil;
import club.banyuan.util.ValidationUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class UserService {

  // 根据用户id获取用户信息
  public User getUserById(int id) {
    // SQL 语句
    String sql = "select * from user where id = ?";
    Map<String, Object> map = JdbcUtil.queryOne(sql, id);
    return JSONObject.parseObject(JSONObject.toJSONString(map), User.class);
  }

  // 获取用户列表
  public List<User> getUserList() {
    // SQL 语句
    String sql = "select * from user";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql);
    return JSONObject.parseArray(JSONObject.toJSONString(list), User.class);
  }

  // 获取指定信息的用户列表
  public List<User> getUserList(User user) {
    // 查询包含指定信息用户的 SQL 语句
    String sql = "select * from user where name like ?";
    String like = "%" + user.getName().trim() + "%";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql, like);
    return JSONObject.parseArray(JSONObject.toJSONString(list), User.class);
  }

  //核实用户名以及密码是否正确
  public boolean login(String userName, String pwd) {
    // SQL 语句
    String sql = "select * from user where name = ? and pwd = ?";
    Map<String, Object> user = JdbcUtil.queryOne(sql, userName, pwd);
    return user.size() != 0;
  }

  // 更新用户信息
  public void updateUser(User user) {
    checkUser(user);
    // SQL 语句
    String sql = "update user set name = ?, pwd = ?, userType = ?, userTypeStr = ?, pwdConfirm = ? where id = ?";
    String userTypeStr = user.getUserType() == 1 ? "经理" : "普通用户";
    JdbcUtil.update(sql, user.getName(), user.getPwd(), user.getUserType(), userTypeStr, user.getPwdConfirm(), user.getId());
  }

  // 新增用户信息
  public void insertUser(User user) {
    checkUserName(user);
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

  private void checkUserName(User user) {
    // SQL 语句
    String sql = "select * from user where name = ?";
    Map<String, Object> u = JdbcUtil.queryOne(sql, user.getName());
    if (u.size() != 0) {
      throw new FormPostException("用户名已存在");
    }
    checkUser(user);
  }

  private void checkUser(User user) {
    if (!user.getPwd().equals(user.getPwdConfirm())) {
      throw new FormPostException("密码不一致");
    }
    try {
      ValidationUtil.validate(user);
    } catch (Exception e) {
      throw new FormPostException(e.getMessage());
    }
  }
}
