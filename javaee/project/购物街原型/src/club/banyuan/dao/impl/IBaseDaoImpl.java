package club.banyuan.dao.impl;

import club.banyuan.dao.IBaseDao;

import java.sql.*;

public abstract class IBaseDaoImpl implements IBaseDao {
  protected Connection connection;
  protected PreparedStatement pstm;

  public IBaseDaoImpl(Connection connection) {
    this.connection = connection;
  }

  // 查询
  @Override
  public ResultSet executeQuery(String sql, Object[] params) {
    ResultSet rs = null;
    try {
      pstm = connection.prepareStatement(sql);
      if (params != null) {
        for (int i = 0; i < params.length; i++) {
          pstm.setObject(i + 1, params[i]);
        }
      }
      rs = pstm.executeQuery();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return rs;
  }


  // 改
  @Override
  public int executeUpdate(String sql, Object[] params) {
    int updateRows = 0;
    try {
      pstm = connection.prepareStatement(sql);
      for (int i = 0; i < params.length; i++) {
        pstm.setObject(i + 1, params[i]);
      }
      updateRows = pstm.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      updateRows = -1;
    }
    return updateRows;
  }

  // 增加
  @Override
  public int executeInsert(String sql, Object[] params) {
    Long id = 0L;
    try {
      pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      for (int i = 0; i < params.length; i++) {
        pstm.setObject(i + 1, params[i]);
      }
      pstm.executeUpdate();
      ResultSet rs = pstm.getGeneratedKeys();
      if (rs.next()) {
        id = rs.getLong(1);
        System.out.println("数据主键：" + id);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      id = null;
    }

    return id.intValue();
  }

  @Override
  public boolean closeResource() {
    if (pstm != null) {
      try {
        pstm.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
        return false;
      }
    }
    return true;
  }

  // 释放资源
  @Override
  public boolean closeResource(ResultSet reSet) {
    if (reSet != null) {
      try {
        reSet.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
        return false;
      }
    }
    return true;
  }

  // 需要重写方法，将结果集转换为对象
  public abstract Object tableToClass(ResultSet rs) throws Exception;
}
