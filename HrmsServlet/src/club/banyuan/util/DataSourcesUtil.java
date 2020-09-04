package club.banyuan.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourcesUtil {
  private static String driver;
  private static String url;
  private static String username;
  private static String password;

  static {
    init();
  }

  public static void init() {
    InputStream inputStream = DataSourcesUtil.class.getClassLoader().getResourceAsStream("hrms.properties");
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
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection openConnection() throws SQLException {
    Connection connection = null;
    connection = DriverManager.getConnection(url, username, password);
    return connection;
  }

  public static void closeConnection(Connection connection) {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
