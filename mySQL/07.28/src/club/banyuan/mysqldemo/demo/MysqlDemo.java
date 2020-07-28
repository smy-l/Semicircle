package club.banyuan.mysqldemo.demo;

import java.sql.*;

public class MysqlDemo {

  // 数据库用户名
  static final String USER = "root";
  // 数据库密码
  static final String PASSWORD = "12345678";

  // JDBC 连接驱动
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  // JDBC 连接串 db_demo 表示数据库名称
  static final String DB_URL = "jdbc:mysql://localhost:3306/db_demo?useSSL=false";

  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;

    try {
      Class.forName(JDBC_DRIVER);
      System.out.println("连接数据库。。。");
      connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
      System.out.println("实例化 Statement 对象。。。");
      statement = connection.createStatement();

      // SQL 语句
      String sql = "SELECT tno, tname FROM teacher";
      // 执行 SQL 查询语句
      ResultSet rs = statement.executeQuery(sql);
      // 循环遍历查询结果
      while (rs.next()) {
        // 获取本条数据的 sno 的字段值
        Integer tno = rs.getInt("tno");
        // 获取本条数据的 sname 的字段值
        String tname = rs.getString("tname");
        // 输出结果
        System.out.println("学生序号为：" + tno + "的姓名是：" + tname);
      }
      // 关闭 ResultSet
      rs.close();
      // 关闭 Statement
      statement.close();
      // 关闭 Connection
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }

}
