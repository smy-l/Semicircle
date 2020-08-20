package club.banyuan.dao;

import club.banyuan.pojo.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailDao extends IBaseDao{
  OrderDetail getOrderDetailByOrdId(int id) throws Exception;
  OrderDetail addOrderDetail(OrderDetail orderDetail);
}
