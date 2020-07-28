package club.banyuan.practice.service;

import club.banyuan.practice.dto.Student;
import club.banyuan.practice.util.JdbcUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class StudentService {

  // 根据学生序号获取学生信息
  public Student getStudentById(int sno) {
    // SQL 语句
    String sql = "select sno, sname, ssex, classNo from student where sno = ?";
    Map<String, Object> map = JdbcUtil.queryOne(sql, sno);
    return JSONObject.parseObject(JSONObject.toJSONString(map), Student.class);
  }

  // 获取学生列表
  public List<Student> getStudentList() {
    // SQL 语句
    String sql = "select sno, sname, ssex, classNo from student";
    List<Map<String, Object>> list = JdbcUtil.queryAll(sql);
    return JSONObject.parseArray(JSONObject.toJSONString(list), Student.class);
  }

  // 更新学生信息
  public void updateStudent(Student student) {
    // 根据学生序号获取学生信息
    Student s = getStudentById(student.getSno());
    // 如果查询的到学生信息则进行更新操作
    if (s != null) {
      s.setSname(student.getSname());
      s.setClassNo(student.getClassNo());
      s.setSsex(student.getSsex());
      // SQL 语句
      String sql = "update student set sname = ?, ssex = ?, classNo = ? where sno = ?";
      JdbcUtil.update(sql, s.getSname(), s.getSsex(), s.getClassNo(), s.getSno());
    }
  }

  // 新增学生信息
  public void insertStudent(Student student) {
    // SQL 语句
    String sql = "insert into student(sname, ssex, classNo) values (?, ?, ?)";
    JdbcUtil.update(sql, student.getSname(), student.getSsex(), student.getClassNo());
  }

  // 删除学生信息
  public void deleteStudent(int sno) {
    // SQL 语句
    String sql = "delete from student where sno = ?";
    JdbcUtil.update(sql, sno);
  }
}
