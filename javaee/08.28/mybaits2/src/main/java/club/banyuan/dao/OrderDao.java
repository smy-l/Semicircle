package club.banyuan.dao;

import club.banyuan.pojo.Order;
import club.banyuan.vo.OrderVO;

import java.util.List;

public interface OrderDao {
  Order getOrderAndProduct(int orderId);
  List<OrderVO> getOrderByUserId(int userId);
  List<Order> getOrderByUserId2(int userId);
}
