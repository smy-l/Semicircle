package club.banyuan.dao;

/*
用户的注册与登录(注册用户名假设为aaa)

商品的查询（如：按商品名称及描述查询“华为”）

依据商品的id，查询商品的详情

生成用户aaa的订单（
订单表，插入一个订单信息
把具体的购买的商品信息插入订单详情表）

查询用户aaa的订单及订单详情信息
 */

import club.banyuan.pojo.Order;

import java.util.List;

public interface OrderDao extends IBaseDao{
  List<Order> getOrderAndDetailByUserName(String userName) throws Exception;
}
