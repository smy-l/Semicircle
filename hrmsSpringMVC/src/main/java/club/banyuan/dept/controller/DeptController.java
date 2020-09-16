package club.banyuan.dept.controller;

import club.banyuan.common.RespResult;
import club.banyuan.dept.dao.DeptDao;
import club.banyuan.dept.entity.Dept;
import club.banyuan.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

  @Autowired
  private DeptService deptService;

  @RequestMapping("/list")
  @ResponseBody
  public RespResult getDeptList(String name, int page, int rows) {
    List<Dept> deptList = deptService.getDeptList(name, page, rows);
    int total = deptService.getDeptListCount(name);
    return RespResult.success(total, deptList);
  }

  @RequestMapping("/save")
  @ResponseBody
  public RespResult saveDept(Dept dept) {
    deptService.saveDept(dept);
    return RespResult.success();
  }

  @RequestMapping("/delete")
  @ResponseBody
  public RespResult deleteDept(String ids) {
    deptService.deleteDeptByIds(Arrays.asList(ids.split(",")));
    return RespResult.success();
  }

  @RequestMapping("/getcombobox")
  @ResponseBody
  public List<Dept> getDeptCombobox() {
    return deptService.getDeptList();
  }


}
