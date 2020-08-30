import club.banyuan.dao.OrderDao;
import club.banyuan.dao.UserDao;
import club.banyuan.pojo.Order;
import club.banyuan.pojo.Product;
import club.banyuan.pojo.User;
import club.banyuan.vo.OrderVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
  public void destroy(){
    //事务提交
    session.commit();
//        资源关闭
    session.close();
  }

  @Test
  public void testGetOrderByUserId() {
    List<OrderVO> orderVOList = orderDao.getOrderByUserId(18);
    for(OrderVO orderVO : orderVOList){
      System.out.println(orderVO);
    }
  }
  @Test
  public void testGetOrderByUserId2() {
    List<Order> orderList = orderDao.getOrderByUserId2(18);
    for(Order order : orderList){
      System.out.println(order);
      System.out.println(order.getUser());
    }
  }

  @Test
  public void testGetOrderAndProduct() {
    Order order = orderDao.getOrderAndProduct(1);
    System.out.println(order);
    for(Product product : order.getProductList()){
      System.out.println(product);
    }
  }
}
