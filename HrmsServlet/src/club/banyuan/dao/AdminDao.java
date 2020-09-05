package club.banyuan.dao;

import club.banyuan.pojo.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
  Admin getAdminByUsernameAndPwd(String username, String pwd) throws SQLException;
  List<Admin> getAdminAll();
  Admin getAdminById(int id) throws SQLException;
  int addAdmin(Admin admin);
  int delAdminById(int id);
  int updateAdmin(Admin admin);
}
