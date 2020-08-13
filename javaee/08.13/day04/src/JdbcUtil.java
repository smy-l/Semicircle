import java.sql.*;

public class JdbcUtil {
  static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
  static String url = "jdbc:mysql://localhost:3306/day4_smallProject?&useSSL=false&serverTimezone=UTC";
  static String name = "root";
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
      conn = DriverManager.getConnection(url, name, password);
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
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    closeConnection(conn, stmt);

  }




}
