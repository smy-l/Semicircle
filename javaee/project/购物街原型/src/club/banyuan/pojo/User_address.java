package club.banyuan.pojo;

import javax.xml.crypto.Data;

public class User_address {
  private Integer id;
  private Integer userId;
  private String address;
  private Data createTime;
  private Integer isDefault;
  private String remark;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Data getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Data createTime) {
    this.createTime = createTime;
  }

  public Integer getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Integer isDefault) {
    this.isDefault = isDefault;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
