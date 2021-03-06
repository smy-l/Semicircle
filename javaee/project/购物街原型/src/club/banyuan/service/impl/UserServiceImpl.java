package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.User;
import club.banyuan.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
  @Override
  public User register(User user) throws SQLException {
    Connection conn = DataSourceUtil.openConnection();
    UserDao userDao = new UserDaoImpl(conn);
    User newUser = userDao.addUser(user);
    DataSourceUtil.closeConnection(conn);
    return newUser;
  }

  @Override
  public User login(String username, String password) throws Exception {
    Connection conn = DataSourceUtil.openConnection();
    UserDao userDao = new UserDaoImpl(conn);
    User checkUser = userDao.getUserByUserNameAndPwd(username, password);
    DataSourceUtil.closeConnection(conn);
    return checkUser;
  }

  @Override
  public User getUserById(int id) throws Exception {
    Connection conn = DataSourceUtil.openConnection();
    UserDao userDao = new UserDaoImpl(conn);
    User user = userDao.getUserById(id);
    DataSourceUtil.closeConnection(conn);
    return user;
  }

  @Override
  public User checkLoginName(String loginName) throws Exception {
    Connection conn = DataSourceUtil.openConnection();
    UserDao userDao = new UserDaoImpl(conn);
    User user = userDao.checkLoginName(loginName);
    DataSourceUtil.closeConnection(conn);
    return user;
  }


}
