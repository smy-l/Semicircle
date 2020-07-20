package club.banyuan.mbm.entity;

public class Supplier {
  private int id;
  private String desc;
  @Validation(regex = "[^!@#$%^&*()]{2,10}", msg = "供应商名称不合法")
  private String name;
  @Validation(regex = "1[358]0[0-9]{8}", msg = "供应商电话有误")
  private String phone;
  @Validation(regex = "[^!@#$%^&*()]{2,10}", msg = "联系人姓名不合法")
  private String contactPerson;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getContactPerson() {
    return contactPerson;
  }

  public void setContactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
