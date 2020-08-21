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
  public Order createOrder(Order order, List<OrderDetail> orderDetailList) {
    Connection conn = null;
    try {
      conn = DataSourceUtil.openConnection();
      conn.setAutoCommit(false);
      OrderDao orderDao = new OrderDaoImpl(conn);
      OrderDetailDao orderDetailDao = new OrderDetailDaoImpl(conn);
      order = orderDao.addOrder(order);
      for (OrderDetail orderDetail : orderDetailList) {
        orderDetail.setOrderId(order.getId());
        orderDetailDao.addOrderDetail(orderDetail);
      }

      conn.commit();
    } catch (SQLException throwables) {
      try {
        conn.rollback();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        if (conn != null) {
          DataSourceUtil.closeConnection(conn);
        }
      }
    }
    return order;
  }
}
