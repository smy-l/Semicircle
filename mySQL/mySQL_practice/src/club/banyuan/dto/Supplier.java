package club.banyuan.dto;

public class Supplier {
  private int id;
  private String description;
  @Validation(regex = "[^!@#$%^&*()]{2,10}", msg = "供应商名称不合法")
  private String name;
  @Validation(regex = "[1[358][05][0-9]{8}]?", msg = "供应商电话有误")
  private String phone;
  @Validation(regex = "[[^!@#$%^&*()]{2,10}]?", msg = "联系人姓名不合法")
  private String contactPerson;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  @Override
  public String toString() {
    return "Supplier{" +
            "id=" + id +
            ", desc='" + description + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", contactPerson='" + contactPerson + '\'' +
            '}';
  }
}
