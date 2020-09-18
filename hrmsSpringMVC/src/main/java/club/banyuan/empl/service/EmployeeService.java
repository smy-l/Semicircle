package club.banyuan.empl.service;

import club.banyuan.common.RespResult;
import club.banyuan.empl.entity.Employee;

import java.util.List;

public interface EmployeeService {
  void saveEmployee(String updateFlag, Employee employee);

  void deleteEmployee(List<String> asList);

  List<Employee> getEmployeeList(Employee employee, int page, int rows);

  int getEmployeeListCount(Employee employee);

  RespResult getEmployeeResult(Employee employee, int page, int rows);

  List<Employee> getEmployeeByDeptIds(List<String> idList);

  List<Employee> getEmployeePositionIds(List<String> idList);
}
