package club.banyuan.user.service;

import club.banyuan.user.entity.User;

import java.util.List;

public interface UserService {
  void saveUser(User user);

  List<User> getUserByName(String name);
  
  List<User> getUserList();

  void deleteUser(Integer id);
  
  User login(String name, String password);
  
  User getUserById(Integer id);

}
