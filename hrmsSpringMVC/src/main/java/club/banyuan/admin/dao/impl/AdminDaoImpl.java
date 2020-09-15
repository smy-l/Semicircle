package club.banyuan.admin.dao.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.Admin;
import club.banyuan.common.ServerException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

// 让 mvc 知道这是用来操作数据库的
// 内部封装了数据查询和存储的逻辑
@Repository
// @Primary 当有自动填充的时候发生冲突，优先使用 @Primary 注释的类
@Primary
public class AdminDaoImpl implements AdminDao {

  // 自动填充(填充的内容在用 @Configuration 注解的类中 这里是SpringConfig)
  @Autowired
  private QueryRunner qr;

  @Override
  public List<Admin> getAdminByName(String name) {
    String sql = "SELECT * FROM t_admin WHERE username = ?";
    try {
      return qr.query(sql, new BeanListHandler<>(Admin.class), name);
    } catch (SQLException throwables) {
      throw new ServerException(throwables);
    }
  }

  @Override
  public void addAdmin(Admin admin) {
    String sql = "insert into t_admin (username, password) values (?, ?)";
    try {
      BigInteger id = qr.insert(sql, new ScalarHandler<>(1), admin.getUsername(), admin.getPassword());
      System.out.println("自增的主键：" + id);
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public void updateAdmin(Admin admin) {
    String sql = "update t_admin set username = ?, password = ? where id = ?";
    try {
      qr.update(sql, admin.getUsername(), admin.getPassword(), admin.getId());
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  // QueryRunner 中的 update 作用是更新
  @Override
  public void deleteAdmin(Admin admin) {
    String sql = "delete from t_admin where id = ?";
    try {
      qr.update(sql, admin.getId());
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  // QueryRunner 中的 batch 作用是遍历
  @Override
  public void deleteAdmin(List<Integer> adminList) {
    String sql = "delete from t_admin where id = ?";
    try {
      Object[][] params = new Object[adminList.size()][1];
      for (int i = 0; i < adminList.size(); i++) {
        params[i][0] = adminList.get(i);
      }
      qr.batch(sql, params);
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  // QueryRunner 中 query 作用是进行查询相关操作
  @Override
  public List<Admin> getAdminList() {
    String sql = "select * from t_admin";
    try {
      return qr.query(sql, new BeanListHandler<>(Admin.class));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Admin> getAdminList(String username) {
    String sql = "select * from t_admin where username like ?";
    try {
      return qr.query(sql, new BeanListHandler<>(Admin.class), "%" + username + "%");
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public Admin getAdmin(String username, String password) {
    String sql = "select * from t_admin where username = ? and password = ?";
    try {
      return qr.query(sql, new BeanHandler<>(Admin.class), username, password);
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public Admin getAdminById(int id) {
    String sql = "select * from t_admin where id = ?";
    try {
      return qr.query(sql, new BeanHandler<>(Admin.class), id);
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public List<Admin> getAdminListPage(String name, int page, int row) {
    try {
      if (name == null || name.length() == 0) {
        String sql = "SELECT * FROM t_admin LIMIT  ?, ?";
        return qr.query(sql, new BeanListHandler<>(Admin.class), (page - 1) * row, row);
      } else {
        String sql = "SELECT * FROM t_admin WHERE username LIKE ? LIMIT ?,?";
        return qr.query(sql, new BeanListHandler<>(Admin.class), "%" + name + "%", (page - 1) * row,
                row);
      }
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  // intValue() 是把 Integer 对象类型变成 int 的基础数据类型；
  // ScalarHandler：单行单列处理器！把结果集转换成Object。一般用于聚集查询，例如select count(*) from tab_student。
  @Override
  public int getAdminListPageCount(String name) {
    try {
      ScalarHandler<Long> rsh = new ScalarHandler<>();
      if (name == null || name.length() == 0) {
        String sql = "SELECT count(*) FROM t_admin";
        return qr.query(sql, rsh).intValue();
      } else {
        String sql = "SELECT count(*) FROM t_admin WHERE username LIKE ?";
        return qr.query(sql, rsh, "%" + name + "%").intValue();
      }
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }
}
