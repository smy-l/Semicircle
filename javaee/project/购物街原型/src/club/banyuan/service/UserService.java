package club.banyuan.service;

import club.banyuan.pojo.User;

import java.sql.SQLException;

public interface UserService {
  User register(User user) throws SQLException;
  User login(String username, String password) throws Exception;
  User getUserById(int id) throws Exception;
  User checkLoginName(String loginName) throws Exception;
}
