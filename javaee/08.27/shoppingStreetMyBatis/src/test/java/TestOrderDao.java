import club.banyuan.dao.OrderDao;
import club.banyuan.pojo.Order;
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

public class TestOrderDao {
  SqlSession session = null;
  OrderDao orderDao = null;
  @Before
  public void init() throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
    session = sqlSessionFactory.openSession();
    orderDao = session.getMapper(OrderDao.class);
  }

  @After
  public void destroy() {
    session.commit();
    session.close();
  }

  @Test
  public void testAddOrder() {
    Order order = new Order();
    order.setUserId(20);
    order.setLoginName("五六七");
    order.setCost(599.9);
    order.setCreateTime(new Date());
    order.setSerialNumber("123123123");
    order.setUserAddress("栖霞区");

    orderDao.addOrder(order);
  }

}
