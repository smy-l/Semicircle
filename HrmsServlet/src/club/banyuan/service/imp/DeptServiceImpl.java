package club.banyuan.service.imp;

import club.banyuan.dao.DepartmentDao;
import club.banyuan.dao.impl.DepartmentDaoImpl;
import club.banyuan.pojo.Department;
import club.banyuan.service.DeptService;
import club.banyuan.util.DataSourcesUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeptServiceImpl implements DeptService {
  @Override
  public List<Department> getDeptAll() throws SQLException {
    Connection conn = DataSourcesUtil.openConnection();
    DepartmentDao departmentDao = new DepartmentDaoImpl(conn);
    List<Department> departmentList = departmentDao.getDeptAll();
    DataSourcesUtil.closeConnection(conn);
    return departmentList;
  }
}
