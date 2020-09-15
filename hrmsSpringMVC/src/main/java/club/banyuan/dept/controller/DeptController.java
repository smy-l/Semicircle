package club.banyuan.dept.controller;

import club.banyuan.common.RespResult;
import club.banyuan.dept.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {

  @Autowired
  private DeptDao deptDao;

  @RequestMapping("/list")
  @ResponseBody
  public RespResult getDeptList(String name, int page, int rows) {
    return null;
  }

}
