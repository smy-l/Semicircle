import club.banyuan.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test4 {
  public static void main(String[] args) throws SQLException {

    Connection conn = JdbcUtil.getConnection();
    // 增 insert into

//    String sql = "insert into student(name, gender, birthday) values (?, ?, ?)";
//    PreparedStatement pstm = conn.prepareStatement(sql);
//    pstm.setString(1,name);
//    pstm.setBoolean(2,gender);
//    pstm.setObject(3, new Date());
//    pstm.executeUpdate();

//    JdbcUtil.closeConnection(conn,pstm);


    // 改 update
    conn = JdbcUtil.getConnection();

    String sql2 = "update student set name  = ? where id = ?";
    PreparedStatement pstm2 = conn.prepareStatement(sql2);
    pstm2.setString(1,"abcd");
    pstm2.setInt(2,1);
    pstm2.executeUpdate();

    JdbcUtil.closeConnection(conn,pstm2);

    // 删 delete
    conn = JdbcUtil.getConnection();

    String sql3 = "delete from student where id = ?";
    PreparedStatement pstm3 = conn.prepareStatement(sql3);
    pstm3.setInt(1,7);
    pstm3.executeUpdate();

    JdbcUtil.closeConnection(conn,pstm3);

    // 查
    conn = JdbcUtil.getConnection();
    String sql4= "select * from student";
    PreparedStatement pstm4 = conn.prepareStatement(sql4);
    ResultSet rs = pstm4.executeQuery();

    List<Student> studentList = new ArrayList<>();
    while(rs.next()){
      Student student = new Student();
      student.setId(rs.getInt(1));
      student.setName(rs.getString(2));
      student.setSex(rs.getBoolean(3));
      student.setBirthday(rs.getDate(4));

      studentList.add(student);
    }

    for (Student student : studentList) {
      System.out.println(student);
    }

  }
}
