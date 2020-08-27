import club.banyuan.dao.ProductDao;
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
import java.util.List;

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
  public void testGetProductById() throws Exception {
    int id = 747;
    Product product = productDao.getProductById(id);
    System.out.println(product);
  }

  @Test
  public void testGetProByKeyWords() {
    String key = "%华为%";
    List<Product> productList = productDao.getProductByKeyWords(key);
    for (Product product : productList) {
      System.out.println(product);
    }
  }


}
