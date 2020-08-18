package club.banyuan.dao;

import club.banyuan.pojo.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends IBaseDao{
  List<Product> getProductByKeyWords(String keyWords) throws Exception;
  Product getProductById(int id) throws Exception;
}
