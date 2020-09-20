package club.banyuan.user.entity;

public class UserListEntity {
  String name;
  String flag;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  @Override
  public String toString() {
    return "ListEntity{" +
            "name='" + name + '\'' +
            ", flag='" + flag + '\'' +
            '}';
  }
}
