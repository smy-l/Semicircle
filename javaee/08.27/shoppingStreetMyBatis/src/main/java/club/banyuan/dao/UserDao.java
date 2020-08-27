package club.banyuan.dao;

import club.banyuan.pojo.User;

import java.sql.ResultSet;
import java.util.Map;

public interface UserDao {
  User userLogin(User user) throws Exception;
  int addUser(User user);
  User getUserById(int id) throws Exception;
  boolean checkLoginName(String loginName) throws Exception;
}
