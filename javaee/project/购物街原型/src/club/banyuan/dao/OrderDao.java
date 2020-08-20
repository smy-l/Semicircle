package club.banyuan.dao;

import club.banyuan.pojo.Order;

import java.util.List;

public interface OrderDao extends IBaseDao{
  Order addOrder(Order order);
}
