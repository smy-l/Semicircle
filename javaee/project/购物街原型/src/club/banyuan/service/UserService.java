package club.banyuan.service;

import club.banyuan.pojo.User;

import java.sql.SQLException;

public interface UserService {
  User register(User user) throws SQLException;
  User checkLogin(User user) throws Exception;
}
