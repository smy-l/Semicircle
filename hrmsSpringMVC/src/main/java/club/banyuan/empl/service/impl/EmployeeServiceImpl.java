package club.banyuan.empl.service.impl;

import club.banyuan.common.RespResult;
import club.banyuan.empl.dao.EmployeeDao;
import club.banyuan.empl.entity.Employee;
import club.banyuan.empl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDao employeeDao;

  @Override
  public void saveEmployee(String updateFlag, Employee employee) {
    if ("yes".equalsIgnoreCase(updateFlag)) {
      employeeDao.updateByPrimaryKey(employee);
    } else {
      employeeDao.insert(employee);
    }
  }

  @Override
  public void deleteEmployee(List<String> asList) {

  }

  @Override
  public List<Employee> getEmployeeList(Employee employee, int page, int rows) {
    return null;
  }

  @Override
  public int getEmployeeListCount(Employee employee) {
    return 0;
  }

  @Override
  public RespResult getEmployeeResult(Employee employee, int page, int rows) {
    return null;
  }

  @Override
  public List<Employee> getEmployeeByDeptIds(List<String> idList) {
    return null;
  }

  @Override
  public List<Employee> getEmployeePositionIds(List<String> idList) {
    return null;
  }
}
