package club.banyuan.service.imp;

import club.banyuan.dao.AdminDao;
import club.banyuan.dao.impl.AdminDaoImpl;
import club.banyuan.pojo.Admin;
import club.banyuan.service.AdminService;
import club.banyuan.util.DataSourcesUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {

  @Override
  public Admin checkAdmin(String username, String password) throws SQLException {
    Connection conn = DataSourcesUtil.openConnection();
    AdminDao adminDao = new AdminDaoImpl(conn);
    Admin admin = adminDao.getAdminByUsernameAndPwd(username, password);
    DataSourcesUtil.closeConnection(conn);
    return admin;
  }

  @Override
  public int addAdmin(Admin admin) throws SQLException {
    Connection conn = DataSourcesUtil.openConnection();
    AdminDao adminDao = new AdminDaoImpl(conn);
    int i = adminDao.addAdmin(admin);
    DataSourcesUtil.closeConnection(conn);
    return i;
  }
}
