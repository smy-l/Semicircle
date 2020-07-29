package club.banyuan.dto;

public class Bill {
  private int id;
  private int providerId;
  private String providerName;
  private String product;
  private int isPay;
  private String updateTime;
  private String isPayStr;
  private double money;

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

  public String getProviderName() {
    return providerName;
  }

  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public int getIsPay() {
    return isPay;
  }

  public void setIsPay(int isPay) {
    this.isPay = isPay;
    setIsPayStr(isPay == 1 ? "已付款" : "未付款");
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getIsPayStr() {
    return isPayStr;
  }

  private void setIsPayStr(String isPayStr) {
    this.isPayStr = isPayStr;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }
}
