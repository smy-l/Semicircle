package club.banyuan.test;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestUserDao {
    @Test
    public void testGetUserByUsernameAndPwd() throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        UserDao userDao = new UserDaoImpl(conn);

        User user =userDao.getUserByUserNameAndPwd("aaa","123");
        System.out.println(user);

        DataSourceUtil.closeConnection(conn);
    }

    @Test
    public void testAddUser() throws SQLException {
        User user = new User();
        user.setLoginName("ABC");
        user.setUserName("xxxx");
        user.setType(1);
        user.setMobile("1234567890");
        user.setEmail("111@11.com");
        user.setIdentityCode("123456789987654321");
        user.setSex(1);
        user.setPassword("123456");
        Connection conn = DataSourceUtil.openConnection();


    }

}
