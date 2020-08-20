package club.banyuan.service.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.OrderDetailDao;
import club.banyuan.dao.impl.OrderDaoImpl;
import club.banyuan.dao.impl.OrderDetailDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.Order;
import club.banyuan.pojo.OrderDetail;
import club.banyuan.service.OrderService;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
  @Override
  public Order createOrder(Order order, List<OrderDetail> orderDetailList) throws SQLException {
    Connection conn = DataSourceUtil.openConnection();
    OrderDao orderDao = new OrderDaoImpl(conn);
    OrderDetailDao orderDetailDao = new OrderDetailDaoImpl(conn);
    Order o1 = orderDao.addOrder(order);
    int orderId = o1.getId();
    for (OrderDetail orderDetail : orderDetailList) {
      OrderDetail orderDe1 = orderDetailDao.addOrderDetail(orderDetail);
    }
    return o1;
  }
}
