package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDetailDao;
import club.banyuan.pojo.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDaoImpl extends IBaseDaoImpl implements OrderDetailDao {
  public OrderDetailDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public OrderDetail getOrderDetailByOrdId(int id) throws Exception {
    String sql = "select * from order_detail where orderId = ?";
    OrderDetail orderDetail = null;
    ResultSet rs = executeQuery(sql, new Object[]{id});
    if (rs.next()) {
      orderDetail =  tableToClass(rs);
    }
    this.closeResource();
    return orderDetail;
  }

  @Override
  public OrderDetail addOrderDetail(OrderDetail orderDetail) {
    String sql = "insert into order_detail values(?, ?, ?, ?, ?)";
    Object[] param = new Object[5];
    param[0] = null;
    param[1] = orderDetail.getOrderId();
    param[2] = orderDetail.getProductId();
    param[3] = orderDetail.getQuantity();
    param[4] = orderDetail.getCost();
    int id = executeInsert(sql, param);
    orderDetail.setId(id);
    closeResource();
    return orderDetail;
  }

  @Override
  public OrderDetail tableToClass(ResultSet rs) throws Exception {
    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setId(rs.getInt(1));
    orderDetail.setOrderId(rs.getInt(2));
    orderDetail.setProductId(rs.getInt(3));
    orderDetail.setQuantity(rs.getInt(4));
    orderDetail.setCost(rs.getDouble(5));
    return orderDetail;
  }
}
