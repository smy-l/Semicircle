package club.banyuan.dao;

import club.banyuan.pojo.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
  List<Product> getProductByKeyWords(String keyWords);
  Product getProductById(int id) throws Exception;
}
