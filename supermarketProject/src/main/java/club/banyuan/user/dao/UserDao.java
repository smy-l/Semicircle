package club.banyuan.user.dao;

import club.banyuan.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    List<User> getUserListByName(@Param("name") String name);
    
    User UserLogin(@Param("username") String username, @Param("password") String password);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}