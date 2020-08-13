import java.sql.*;

public class JdbcUtil {
  static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
  static String url = "jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC";
  static String username = "root";
  static String password = "12345678";

  static {
    try {
      Class.forName(jdbcDriver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, username, password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return conn;
  }

  public static void closeConnection(Connection conn, Statement stmt) {
    try {
      if (stmt != null) {
        stmt.close();
      }

      if (conn != null) {
        conn.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    closeConnection(conn, stmt);
  }


}
