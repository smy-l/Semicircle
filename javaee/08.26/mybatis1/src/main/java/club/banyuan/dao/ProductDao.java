package club.banyuan.dao;

import club.banyuan.pojo.Product;
import club.banyuan.vo.PageVO;
import club.banyuan.vo.ProductVO;

import java.util.List;
import java.util.Map;

public interface ProductDao {
  List<Product> getAll();
  List<Product> getProductByPrice(Map map);
  List<Product> getProductByNameOrDesc(String key);
  List<Product> getProductByParam(ProductVO productVO);
  int countProductRows();
  public List<PageVO> countLevel1ProductRows();
}
