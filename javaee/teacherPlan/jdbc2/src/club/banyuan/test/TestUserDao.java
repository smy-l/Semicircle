package club.banyuan.test;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.User;
import org.junit.jupiter.api.Test;

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
}
