package club.banyuan.mbm.entity;

import club.banyuan.mbm.uti.PropUtil;

import java.util.List;

import static com.alibaba.fastjson.JSON.parseArray;

public class Bill {
  private int id;
  @Validation(regex = "[^!@#$%^&*()_+-=]{}",msg = "账单名称错误")
  private int providerId;
  private String productDescription;
  private String product;
  @Validation(regex = "[0-9]{0,}", msg = "账单金额错误")
  private long money;
  private int isPay;
  private String time;
  private String isPayStr;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProviderId() {
    return providerId;
  }

  public void setProviderId(int providerId) {
    this.providerId = providerId;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }

  public int isPay() {
    return isPay;
  }

  public void setPay(int pay) {
    isPay = pay;
    setIsPayStr();
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getIsPayStr() {
    return isPayStr;
  }

  public void setIsPayStr() {
    if(isPay == 1){
      isPayStr = "是";
    }else if(isPay == 0){
      isPayStr = "否";
    }
  }
}
