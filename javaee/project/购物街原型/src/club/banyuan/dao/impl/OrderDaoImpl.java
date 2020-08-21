package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.pojo.Order;

import java.sql.Connection;
import java.sql.ResultSet;

public class OrderDaoImpl extends IBaseDaoImpl implements OrderDao {
  public OrderDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Order addOrder(Order order) {
    String sql = "insert into `order` values(?, ?, ?, ?, ?, ?, ?)";
    Object[] param = new Object[7];
    param[0] = null;
    param[1] = order.getUserId();
    param[2] = order.getLoginName();
    param[3] = order.getUserAddress();
    param[4] = order.getCreateTime();
    param[5] = order.getCost();
    param[6] = order.getSerialNumber();
    int id = executeInsert(sql, param);
    order.setId(id);
    closeResource();
    return order;
  }

  @Override
  public Object tableToClass(ResultSet rs) throws Exception {
    Order order = new Order();
    order.setId(rs.getInt(1));
    order.setUserId(rs.getInt(2));
    order.setLoginName(rs.getString(3));
    order.setUserAddress(rs.getString(4));
    order.setCreateTime(rs.getTime(5));
    order.setCost(rs.getDouble(6));
    order.setSerialNumber(rs.getString(7));
    return order;
  }
}
