package club.banyuan.dao;

import club.banyuan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
  List<User> getAll();
  User getUserByNameAndPwd(@Param("loginname") String loginname, @Param("password") String password);
  User getUserAndOrder(int userId);
}
