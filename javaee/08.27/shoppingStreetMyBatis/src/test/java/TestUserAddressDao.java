import club.banyuan.dao.UserAddressDao;
import club.banyuan.pojo.UserAddress;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestUserAddressDao {
  SqlSession session = null;
  UserAddressDao userAddressDao = null;
  @Before
  public void init() throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
    session = sqlSessionFactory.openSession();
    userAddressDao = session.getMapper(UserAddressDao.class);
  }

  @After
  public void destroy() {
    session.commit();
    session.close();
  }

  private void printUserAddressList(List<UserAddress> userAddressList) {
    for (UserAddress userAddress : userAddressList) {
      System.out.println(userAddress);
    }
  }

  @Test
  public void testGetUserAddressById() throws Exception {
    int id = 15;
    List<UserAddress> userAddressList = userAddressDao.getUserAddListByUserId(id);
    printUserAddressList(userAddressList);
  }

  @Test
  public void testAddUserAddress() {
    UserAddress userAddress = new UserAddress();
    userAddress.setAddress("南京市栖霞区");
    userAddress.setCreateTime(new Date());
    userAddress.setIsDefault(1);
    userAddress.setUserId(20);
    userAddress.setRemark("company");

    userAddressDao.addUserAddress(userAddress);
  }


}
