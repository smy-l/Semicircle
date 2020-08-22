package club.banyuan.dao;

import club.banyuan.pojo.User;

import java.sql.ResultSet;

public interface UserDao extends IBaseDao {
  User getUserByUserNameAndPwd(String username, String password) throws  Exception;
  User addUser(User user);
  User getUserById(int id) throws Exception;
  User checkLoginName(String loginName) throws Exception;
}
