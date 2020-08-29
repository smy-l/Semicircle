package club.banyuan.dao;

import club.banyuan.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductDao {
  List<Product> getProductByParam(Map map);
  List<Product> getProductByParam2(Map map);
  List<Product> getProductByParam3(@Param("keyList") List<String> keyList);
  List<Product> getProductByLevel1IdArray(@Param("level1Ids") List<Integer> level1Ids);
  Product getProductAndOrder(int productId);

}
