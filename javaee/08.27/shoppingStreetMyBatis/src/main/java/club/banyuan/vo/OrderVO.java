package club.banyuan.vo;

import java.util.Date;

public class OrderVO {
  Integer orderId;
  Integer orderDetailId;
  Integer productId;
  Integer quantity;
  Double orderDetailCost;
  Integer userId;
  String loginName;
  String userAddress;
  Date createTime;
  Double orderCost;
  String serialNumber;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getOrderDetailId() {
    return orderDetailId;
  }

  public void setOrderDetailId(Integer orderDetailId) {
    this.orderDetailId = orderDetailId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getOrderDetailCost() {
    return orderDetailCost;
  }

  public void setOrderDetailCost(Double orderDetailCost) {
    this.orderDetailCost = orderDetailCost;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Double getOrderCost() {
    return orderCost;
  }

  public void setOrderCost(Double orderCost) {
    this.orderCost = orderCost;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }
}
