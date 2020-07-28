package club.banyuan.dto;

public class User {

  private int id;
  @Validation(regex = "[^!@#$%^&*()]{2,10}", msg = "用户名不合法")
  private String name;
  @Validation(regex = "\\w{3,15}", msg = "密码不合法")
  private String pwd;
  private String pwdConfirm;
  private int userType;
  //userType = 0 普通用户
  //userType = 1 经理
  private String userTypeStr;


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

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getPwdConfirm() {
    return pwdConfirm;
  }

  public void setPwdConfirm(String pwdConfirm) {
    this.pwdConfirm = pwdConfirm;
  }

  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
  }

  public String getUserTypeStr() {
    return userTypeStr;
  }

  public void setUserTypeStr(String userTypeStr) {
    this.userTypeStr = userTypeStr;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pwd='" + pwd + '\'' +
            ", pwdConfirm='" + pwdConfirm + '\'' +
            ", userType=" + userType +
            ", userTypeStr='" + userTypeStr + '\'' +
            '}';
  }
}
