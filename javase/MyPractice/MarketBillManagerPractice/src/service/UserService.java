package service;

import exception.FormPostException;
import myUtil.ValidationUtil;
import com.alibaba.fastjson.JSONObject;
import entity.User;
import exception.*;
import myUtil.PropUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class UserService {

  private static int userId;
  private static final String USER_STORE_PATH = "user.store.path";
  private static List<User> userList;


  // 存储save()、加载load()、增、删、改、查

  static {
    load();
//    userId = userList.size() + 1;
//    for (User user : userList) {
//      if(user.getId() > userId){
//        userId = user.getId() + 1;
//      }
//    }
    Optional<User> max = userList.stream().max(Comparator.comparingInt(User::getId));
    userId = max.map(user -> user.getId() + 1).orElse(1);
  }

  //加载
  private static void load() {
    File file = new File(PropUtil.getProp(USER_STORE_PATH));
    if (file.exists()) {
      try (FileInputStream fileInputStream = new FileInputStream(file)) {
        byte[] bytes = fileInputStream.readAllBytes();
        userList = JSONObject.parseArray(new String(bytes), User.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("用户文件不存在");
      userList = new ArrayList<>();
    }
  }

  //存储
  public static void save() {
    File file = new File(PropUtil.getProp(USER_STORE_PATH));
    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
      String jsonStr = JSONObject.toJSONString(userList);
      fileOutputStream.write(jsonStr.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //核实用户名以及密码是否正确
  public boolean login(String userName, String pwd) {
    for (User user1 : userList) {
      System.out.println(user1);
      System.out.println("userName: " + userName + "pwd: " + pwd);
      if (user1.getName().equals(userName) && user1.getPwd().equals(pwd)) {
        return true;
      }
    }
    return false;
  }

  //增
  public void addUser(User user) {
    validate(user);
    synchronized (userList) {
      user.setId(userId++);
      userList.add(user);
      save();
    }
  }

  //删
  public void deleteUser(User user) {
    synchronized (userList) {
      User userById = getUserById(user.getId());
      userList.remove(userById);
      save();
    }
  }

  //改
  public void modifyUser(User user) {
    synchronized (userList) {
      User userById = getUserById(user.getId());
      userById.setName(user.getName());
      userById.setPwd(user.getPwd());
      userById.setPwdConfirm(user.getPwdConfirm());
      userById.setUserType(user.getUserType());
    }
  }

  //查
  //根据id获取user对象
  public User getUserById(int id) {
    for (User userId : userList) {
      if (userId.getId() == id) {
        return userId;
      }
    }
    return null;
  }

  //获取用户列表
  public List<User> getUserList() {
    return userList;
  }

  public List<User> getUserList(User user) {
    if (user.getName() == null || user.getName().trim().length() == 0) {
      return userList;
    }

    List<User> list = new ArrayList<>();
    for (User user1 : userList) {
      if (user1.getName().contains(user.getName().trim())) {
        list.add(user1);
      }
    }
    return list;
  }

  //校验用户名和密码
  private void validate(User user) {
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
