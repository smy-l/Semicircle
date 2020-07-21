package club.banyuan.mbm.entity;

import static com.alibaba.fastjson.JSON.parseArray;

public class Bill {
  private int id;
  private int providerId;
  private String providerName;
  private String product;
  private int isPay;
  private String updateTime;
  private String isPayStr;
  @Validation(regex = "\\d", msg = "账单金额不合法")
  private int money;

  public String getProviderName() {
    return providerName;
  }

  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

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

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
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

  public void setIsPayStr(String isPayStr) {
    this.isPayStr = isPayStr;
  }

  public int getIsPay() {
    return isPay;
  }

  public void setIsPay(int isPay) {
    this.isPay = isPay;
  }

  @Override
  public String toString() {
    return "Bill{" +
            "id=" + id +
            ", providerId=" + providerId +
            ", providerName='" + providerName + '\'' +
            ", product='" + product + '\'' +
            ", money=" + money +
            ", isPay=" + isPay +
            ", updateTime='" + updateTime + '\'' +
            ", isPayStr='" + isPayStr + '\'' +
            '}';
  }
}
