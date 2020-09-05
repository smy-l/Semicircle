package club.banyuan.pojo;

public class Admin {
  private int id;
  private String username;
  private String rolename;
  private String password;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", rolename='" + rolename + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
