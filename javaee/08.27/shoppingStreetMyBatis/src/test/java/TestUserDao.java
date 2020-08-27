import club.banyuan.dao.UserDao;
import club.banyuan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestUserDao {
  SqlSession session = null;
  UserDao userDao = null;
  @Before
  public void init() throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
    session = sqlSessionFactory.openSession();
    userDao = session.getMapper(UserDao.class);
  }

  @After
  public void destroy() {
    session.commit();
    session.close();
  }

  @Test
  public void testUserLogin() throws Exception {
    User newUser = new User();
    newUser.setLoginName("aaa");
    newUser.setPassword("123");

    User user = userDao.userLogin(newUser);
    System.out.println(user);
  }

  @Test
  public void testAddUser(){
    User user = new User();
    user.setLoginName("七八九");
    user.setUserName("七八九");
    user.setSex(1);
    user.setEmail("sdfs@dfsdf.com");
    user.setMobile("99898294892");
    user.setIdentityCode("32432423222");
    user.setPassword("123");
    user.setType(1);

    userDao.addUser(user);
  }

  @Test
  public void testGetUserById() throws Exception {
    int id = 24;
    User userById = userDao.getUserById(id);
    System.out.println(userById);
  }

  @Test
  public void testCheckLoginName() throws Exception {
    String loginName = "aaa";
    boolean b = userDao.checkLoginName(loginName);
    System.out.println(b);
  }
}
