package service;

import com.alibaba.fastjson.JSONObject;
import entity.User;
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
      byte[] bytes = jsonStr.getBytes();
      fileOutputStream.write(bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //核实用户名以及密码是否正确
  public boolean login(String userName, String pwd) {
    for (User user1 : userList) {
      if (user1.getName().equals(userName) && user1.getPwd() == pwd) {
        return true;
      }
    }
    return false;
  }

  //增
  public void addUser(User user) {
    synchronized (userList) {
      user.setId(userId++);
      userList.add(user);
      save();
    }
  }

  //删
  public void deleteUser(User user) {
    User userById = getUserById(user.getId());
    userList.remove(userById);
    save();
  }

  //改
  public void modifyUser(User user) {

  }

  //查
  //根据id获取user对象
  public User getUserById(int id) {
    for (User user : userList) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }


}
