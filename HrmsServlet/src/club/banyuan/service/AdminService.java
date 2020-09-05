package club.banyuan.service;

import club.banyuan.pojo.Admin;

import java.sql.SQLException;

public interface AdminService {
  Admin checkAdmin(String username, String password) throws SQLException;
}
