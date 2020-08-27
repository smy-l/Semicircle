package club.banyuan.dao;

import club.banyuan.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    int addUser(User user);
    int updateUser(User user);
    int delUser(int id);
}
