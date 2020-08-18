package club.banyuan.dao.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceUtil {
  private static String driver;
  private static String url;
  private static String username;
  private static String password;

  static {
    init();
  }

  public static void init() {
    InputStream inputStream = DataSourceUtil.class.
            getClassLoader().getResourceAsStream("db.properties");
    Properties properties = new Properties();

    try {
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    url = properties.getProperty("url");
    driver = properties.getProperty("driver");
    username = properties.getProperty("username");
    password = properties.getProperty("password");

    try {
      // 加载JDBC驱动类
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  // 获取连接
  public static Connection openConnection() throws SQLException {
    Connection conn = null;
    conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  // 关闭连接
  public static void closeConnection(Connection connection) {
    try {
      if(connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
