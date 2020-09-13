package club.banyuan.admin.service;

import club.banyuan.admin.entity.Admin;

import java.util.List;

public interface AdminService {
  Admin login(String username, String password);

  List<Admin> getAdminList(String username);

  void addAdmin(Admin admin);

  void updateAdmin(Admin admin);

  void deleteAdmins(List<String> adminList);

  List<Admin> getAdminList(String username, Integer page, Integer row);

  int getAdminListCount(String username);
}
