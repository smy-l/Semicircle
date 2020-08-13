import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    jdbc driver class name
    String jdbcDriver = "com.mysql.cj.jdbc.Driver";
//    数据库连接字符串
    //连接协议，MySQL的ip，端口，数据库名
    String url = "jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC";
    // 登录mysql用户名
    String username = "root";
    // 登录mysql密码
    String password = "12345678";

    // 加载jdbc驱动类
    Class.forName(jdbcDriver);
    // 创建数据库连接
    Connection conn = DriverManager.getConnection(url, username, password);
    //创建Statement对象，用于执行Sql语句
    Statement stmt = conn.createStatement();
    String sql = "create table student(\n" +
            "\tid int primary key auto_increment,\n" +
            "    name varchar(20),\n" +
            "    gender boolean,\n" +
            "    birthday date\n" +
            ");";

    // 执行 executeXXX() 执行sql
    // 如果是非查询 sql executeUpdate()
    // 如果是查询 sql executeQuery()
    stmt.executeUpdate(sql);

    stmt.close();
    conn.close();

  }
}
