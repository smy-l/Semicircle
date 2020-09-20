package club.banyuan.user.service.impl;

import club.banyuan.user.dao.UserDao;
import club.banyuan.user.entity.User;
import club.banyuan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserDao userDao;

  @Override
  public void saveUser(User user) {
    if (user.getId() == 0) {
      userDao.insert(user);
    } else {
      userDao.updateByPrimaryKey(user);
    }
  }

  @Override
  public List<User> getUserByName(String name) {
    return userDao.getUserListByName(name);
  }

  @Override
  public List<User> getUserList() {
    return userDao.getUserList();
  }

  @Override
  public void deleteUser(Integer id) {
    userDao.deleteByPrimaryKey(id);
  }

  @Override
  public User login(String name, String password) {
    return userDao.UserLogin(name, password);
  }

  @Override
  public User getUserById(Integer id) {
    return userDao.selectByPrimaryKey(id);
  }
}
