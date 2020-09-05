package club.banyuan.dao.impl;

import club.banyuan.dao.AdminDao;
import club.banyuan.pojo.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {
  public AdminDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Admin getAdminByUsernameAndPwd(String username, String pwd) throws SQLException {
    Admin admin = null;
    String sql = "select * from admin where username = ? and password = ?";
    ResultSet rs = executeQuery(sql, new Object[]{username, pwd});
    if (rs.next()) {
      try {
        admin = tableToClass(rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return admin;
  }

  @Override
  public List<Admin> getAdminAll() {
    List<Admin> adminList = new ArrayList<>();
    String sql = "select * from admin";
    ResultSet rs = executeQuery(sql, new Object[]{});
    try {
      while (rs.next()) {
        Admin admin = tableToClass(rs);
        adminList.add(admin);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return adminList;
  }

  @Override
  public Admin getAdminById(int id) throws SQLException {
    Admin admin = null;
    String sql = "select * from admin where id = ?";
    ResultSet rs = executeQuery(sql, new Object[]{id});
    if (rs.next()) {
      try {
        admin = tableToClass(rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return admin;
  }

  @Override
  public int addAdmin(Admin admin) {
    String sql = "insert into admin values(?, ?, ?, ?)";
    Object[] param = new Object[4];
    param[0] = null;
    param[1] = admin.getPassword();
    param[2] = admin.getUsername();
    param[3] = "admin";
    int id = executeInsert(sql, param);
    admin.setId(id);
    closeResource();
    return 1;
  }

  @Override
  public int delAdminById(int id) {
    return 0;
  }

  @Override
  public int updateAdmin(Admin admin) {
    return 0;
  }

  @Override
  public Admin tableToClass(ResultSet rs) throws Exception {
    Admin admin = new Admin();
    admin.setId(rs.getInt(1));
    admin.setPassword(rs.getString(2));
    admin.setUsername(rs.getString(3));
    admin.setRolename(rs.getString(4));
    return admin;
  }
}
