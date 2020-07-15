import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

  public static final String USER_PATH = "user.path";
  private static List<User> userList;


  private static void load() {
    File file = new File(PropUtil.getProp(USER_PATH));
    if (file.exists()) {
      try {
        FileInputStream fileInputStream = new FileInputStream(file);
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

  public User login(String username, String pwd) {
    for (User user : userList) {
      if (user.getName().equals(username) && user.getPwd().equals(pwd)) {
        return user;
      }
    }

    return null;
  }
}
