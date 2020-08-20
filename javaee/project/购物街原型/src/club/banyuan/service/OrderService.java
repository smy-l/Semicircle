package club.banyuan.service;

import club.banyuan.pojo.Order;
import club.banyuan.pojo.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
  Order createOrder(Order order, List<OrderDetail> orderDetailList) throws SQLException;
}
