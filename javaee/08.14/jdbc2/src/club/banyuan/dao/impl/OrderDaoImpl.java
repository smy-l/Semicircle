package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.pojo.Order;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
  public OrderDaoImpl(Connection conn) {
    super(conn);
  }

  @Override
  public Order tableToClass(ResultSet rs) throws Exception {
    Order order = new Order();
    order.setId(rs.getInt(1));
    order.setUserId(rs.getInt(2));
    order.setLoginName(rs.getString(3));
    order.setUserAddress(rs.getString(4));
    order.setCreateTime((Data) rs.getTime(5));
    order.setCost(rs.getDouble(6));
    order.setSerialNumber(rs.getString(7));
    return order;
  }

  @Override
  public List<Order> getOrderAndDetailByUserName(String userName) throws Exception {
    String sql = "";
//    select `order`.*, order_detail.* from `order`
//    join in order_detail
//    on `order`.id = order_detail.orderId
//    where `order`.loginName = 'admin';

    return null;

  }
}
