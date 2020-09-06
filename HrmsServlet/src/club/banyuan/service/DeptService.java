package club.banyuan.service;

import club.banyuan.pojo.Department;

import java.sql.SQLException;
import java.util.List;

public interface DeptService {
  List<Department> getDeptAll() throws SQLException;
}
