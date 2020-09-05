package club.banyuan.dao;

import java.sql.ResultSet;

public interface BaseDao {
  ResultSet executeQuery(String sql, Object[] params);
  int executeUpdate(String sql, Object[] params);
  int executeInsert(String sql, Object[] params);
  boolean closeResource();
  boolean closeResource(ResultSet reSet);
  Object tableToClass(ResultSet rs) throws Exception;
}
