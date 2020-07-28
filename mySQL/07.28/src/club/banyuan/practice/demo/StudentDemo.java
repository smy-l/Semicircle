package club.banyuan.practice.demo;

import club.banyuan.practice.dto.Student;
import club.banyuan.practice.service.StudentService;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class StudentDemo {

  public static void main(String[] args) {
    StudentService studentService = new StudentService();
//    System.out.println("--- 获取指定学生信息 ---");
//    // 入参 需要查询的学生序号
//    int sno = 101;
//    // 获取学生信息
//    Student s1 = studentService.getStudentById(sno);
//    // 输出信息
//    String data = JSONObject.toJSONString(s1);
//    System.out.println(data);

//    System.out.println("--- 获取学生列表 ---");
//    List<Student> students = studentService.getStudentList();
//    String data = JSONObject.toJSONString(students);
//    System.out.println(data);

    //{"classNo":90301,"sname":"李华","sno":101,"ssex":"男"}
//    System.out.println("--- 学生信息修改前数据结果 ---");
//    Student s1 =studentService.getStudentById(101);
//    System.out.println(JSONObject.toJSONString(s1));
//
//    Student s2 = new Student();
//    s2.setSno(101);
//    s2.setSname("张三");
//    s2.setSsex("女");
//    s2.setClassNo(99999);
//    // 更新学生信息
//    studentService.updateStudent(s2);
//
//    System.out.println("--- 学生信息修改后数据结果 ---");
//    Student s3 =studentService.getStudentById(101);
//    System.out.println(JSONObject.toJSONString(s3));

//    System.out.println("--- 新增学生信息前学生列表 ---");
//    List<Student> students = studentService.getStudentList();
//    System.out.println(JSONObject.toJSONString(students));
//
//    // 新增学生数据
//    Student s4 = new Student();
//    s4.setSsex("男");
//    s4.setClassNo(88888);
//    s4.setSname("李四");
//    studentService.insertStudent(s4);
//    System.out.println("--- 新增学生信息后学生列表 ---");
//    students = studentService.getStudentList();
//    System.out.println(JSONObject.toJSONString(students));

    System.out.println("--- 删除学生信息前学生列表 ---");
    List<Student> students = studentService.getStudentList();
    System.out.println(JSONObject.toJSONString(students));

    // 删除学生数据
    studentService.deleteStudent(107);

    System.out.println("--- 删除学生信息后学生列表 ---");
    students = studentService.getStudentList();
    System.out.println(JSONObject.toJSONString(students));
  }
}
