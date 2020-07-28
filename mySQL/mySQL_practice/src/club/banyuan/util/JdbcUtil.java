package club.banyuan.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtil {

  // JDBC 驱动
  private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  // JDBC 连接
  private static final String DB_URL = "jdbc:mysql://localhost:3306/db_MarketBillManager?useSSL=false";
  // 数据库用户名
  private static final String USER = "root";
  // 数据库密码
  private static final String PASSWORD = "12345678";

  protected static Connection connection;
  protected static PreparedStatement preparedStatement;
  protected static ResultSet resultSet;

  // 初始化
  static {
    try {
      Class.forName(JDBC_DRIVER);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 获取数据库连接
  public static Connection getConnection() {
    try {
      connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return connection;
  }

  // 查询单条数据结果
  public static Map<String, Object> queryOne(String sql, Object... params) {
    Map<String, Object> map = new HashMap<>();
    connection = getConnection();
    try {
      preparedStatement = connection.prepareStatement(sql);
      if (params != null && params.length > 0) {
        for (int i = 0; i < params.length; i++) {
          preparedStatement.setObject(i + 1, params[i]);
        }
      }
      resultSet = preparedStatement.executeQuery();
      ResultSetMetaData metaData = resultSet.getMetaData();
      int colLen = metaData.getColumnCount();
      while (resultSet.next()) {
        for (int i = 0; i < colLen; i++) {
          String colName = metaData.getColumnName(i + 1);
          Object colValue = resultSet.getObject(colName);
          if (colValue == null) {
            colValue = "";
          }
          map.put(colName, colValue);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 关闭连接
      close(connection, preparedStatement, resultSet);
    }
    return map;
  }

  // 查询多条结果
  public static List<Map<String, Object>> queryAll(String sql, Object... params) {
    List<Map<String, Object>> list = new ArrayList<>();
    connection = getConnection();
    try {
      preparedStatement = connection.prepareStatement(sql);
      if (params != null && params.length > 0) {
        for (int i = 0; i < params.length; i++) {
          preparedStatement.setObject(i + 1, params[i]);
        }
      }
      resultSet = preparedStatement.executeQuery();
      ResultSetMetaData metaData = resultSet.getMetaData();
      int colLen = metaData.getColumnCount();
      while (resultSet.next()) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < colLen; i++) {
          String colName = metaData.getColumnName(i + 1);
          Object colValue = resultSet.getObject(colName);
          if (colValue == null) {
            colValue = "";
          }
          map.put(colName, colValue);
        }
        list.add(map);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 关闭连接
      close(connection, preparedStatement, resultSet);
    }
    return list;
  }

  // 插入 更新 删除数据
  public static int update(String sql, Object... params) {
    int result = 0;
    connection = getConnection();
    try {
      preparedStatement = connection.prepareStatement(sql);
      if (params != null && params.length > 0) {
        for (int i = 0; i < params.length; i++) {
          preparedStatement.setObject(i + 1, params[i]);
        }
      }
      result = preparedStatement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      // 关闭连接
      close(connection, preparedStatement, resultSet);
    }
    return result;
  }

  // 关闭连接
  public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      if (pstmt != null) {
        pstmt.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
