package club.banyuan.pojo;

public class Employee {
  private Integer id;
  private String name;
  private String sex;
  private String phone;
  private String email;
  private String address;
  private String education;
  private String birthday;
  private String department;
  private Integer positionId;
  private Integer passwordId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Integer getPositionId() {
    return positionId;
  }

  public void setPositionId(Integer positionId) {
    this.positionId = positionId;
  }

  public Integer getPasswordId() {
    return passwordId;
  }

  public void setPasswordId(Integer passwordId) {
    this.passwordId = passwordId;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            ", education='" + education + '\'' +
            ", birthday=" + birthday +
            ", department='" + department + '\'' +
            ", positionId=" + positionId +
            ", passwordId=" + passwordId +
            '}';
  }
}
