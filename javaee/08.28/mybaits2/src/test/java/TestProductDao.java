import club.banyuan.dao.ProductDao;
import club.banyuan.pojo.Order;
import club.banyuan.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestProductDao {
  SqlSession session = null;
  ProductDao productDao = null;
  @Before
  public void init() throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
    session = sqlSessionFactory.openSession();
    productDao = session.getMapper(ProductDao.class);
  }

  @After
  public void destroy() {
    session.commit();
    session.close();
  }

  @Test
  public void testGetProductByParam() {
    Map map = new HashMap();
    map.put("lowPrice", 400);
    map.put("hiPrice", 550);
    map.put("stock", 300);

    List<Product> productByParam = productDao.getProductByParam(map);
    printProductList(productByParam);
  }

  @Test
  public void testGetProductByParam3() {
    String param = "奶 华为";
    List<String> keyList = new ArrayList<>();
    String[] params = param.split(" ");
    for (String s : params) {
      keyList.add("%" + s + "%");
    }

    List<Product> productList = productDao.getProductByParam3(keyList);
    printProductList(productList);
  }

  @Test
  public void testProductAndOrder() {
    Product product = productDao.getProductAndOrder(734);
    System.out.println(product);
    for(Order order : product.getOrderList()){
      System.out.println(order);
    }
  }


  private void printProductList(List<Product> productByParam) {
    for (Product product : productByParam) {
      System.out.println(product);
    }
  }

}
