package club.banyuan.test;

import club.banyuan.dao.ProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.Product;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestProductDao {
    @Test
    public void testGetProductByKeyWords() throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        ProductDao productDao = new ProductDaoImpl(conn);
        List<Product> productList = productDao.getProductByKeyWords("华为");
        for (Product product : productList) {
            System.out.println(product);
        }
        DataSourceUtil.closeConnection(conn);
    }
}
