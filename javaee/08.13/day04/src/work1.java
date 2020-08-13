import club.banyuan.Product;
import club.banyuan.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class work1 {
  public static void main(String[] args) {
    try {
//      work1.add();
//      work1.login();
//      work1.searchByNameAndDesc();
      work1.searchByProId();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  // 增加
  public static void add() throws SQLException {
    Connection conn = JdbcUtil.getConnection();
    int id = 22;
    String loginName = "aaa";
    String userName = "aaa";
    String password = "123456";
    int sex = 1;
    String identity = "123456789123456789";
    String email = "aaa@163.com";
    String mobile = "12345678910";
    int type = 0;

    String sql = "insert into user values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    PreparedStatement pstm1 = conn.prepareStatement(sql);
    pstm1.setInt(1, id);
    pstm1.setString(2, loginName);
    pstm1.setString(3, userName);
    pstm1.setString(4, password);
    pstm1.setInt(5, sex);
    pstm1.setString(6, identity);
    pstm1.setString(7, email);
    pstm1.setString(8, mobile);
    pstm1.setInt(9, type);
    pstm1.executeUpdate();

    JdbcUtil.closeConnection(conn, pstm1);
  }


  // 核查
  public static boolean login() throws SQLException {
    Connection conn = JdbcUtil.getConnection();
    String logName = "aaa";
    String pwd = "123456";

    String sql = "select * from user where loginName = ? and password = ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, logName);
    pstm.setString(2, pwd);

    ResultSet rs = pstm.executeQuery();

    if (rs.next()) {
      System.out.println("用户名或密码输入正确");
      return true;
    } else {
      System.out.println("用户名或密码输入错误");
      return false;
    }
  }

  // 根据商品描述以及名字查询
  public static void searchByNameAndDesc() throws SQLException {
    Connection conn = JdbcUtil.getConnection();
    String proName = "华为";
    String proNameLike = "%" + "华为" + "%";
    String description = "";
    String descriptionLike = "%" + "" + "%";

    String sql = "select * from product where name like ? and description like ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, proNameLike);
    pstm.setString(2, descriptionLike);
    ResultSet rs = pstm.executeQuery();

    if (!rs.next()) {
      System.out.println("没有该商品");
      return;
    }

    List<Product> productList = getProductList();
    for (Product product : productList) {
      if (product.getName().contains(proName) && product.getDescription().contains(description)) {
        System.out.println(product);
      }
    }
  }

  public static void searchByProId() throws SQLException {
    Connection conn = JdbcUtil.getConnection();
    int id = 736;

    String sql = "select * from product where id = ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1, id);
    ResultSet rs = pstm.executeQuery();

    if (!rs.next()) {
      System.out.println("没有该商品");
      return;
    }

    List<Product> productList = getProductList();
    for (Product product : productList) {
      if (product.getId() == id) {
        System.out.println(product);
      }
    }
  }

  public static List getUserList() throws SQLException {
    Connection conn = JdbcUtil.getConnection();
    String sqlSelectAll = "select * from user";
    PreparedStatement pstm = conn.prepareStatement(sqlSelectAll);
    ResultSet rsAll = pstm.executeQuery();

    List<User> userList = new ArrayList<>();
    while (rsAll.next()) {
      User user = new User();
      user.setId(rsAll.getInt(1));
      user.setLoginName(rsAll.getString(2));
      user.setUserName(rsAll.getString(3));
      user.setPassword(rsAll.getString(4));
      user.setSex(rsAll.getInt(5));
      user.setIdentity(rsAll.getString(6));
      user.setEmail(rsAll.getString(7));
      user.setMobile(rsAll.getString(8));
      user.setType(rsAll.getInt(9));

      userList.add(user);
    }
    JdbcUtil.closeConnection(conn, pstm, rsAll);
    return userList;
  }

  public static List getProductList() throws SQLException {
    Connection conn = JdbcUtil.getConnection();
    String sqlSelectAll = "select * from product";
    PreparedStatement pstm = conn.prepareStatement(sqlSelectAll);
    ResultSet rsAll = pstm.executeQuery();

    List<Product> productList = new ArrayList<>();
    while (rsAll.next()) {
      Product product = new Product();
      product.setId(rsAll.getInt(1));
      product.setName(rsAll.getString(2));
      product.setDescription(rsAll.getString(3));
      product.setPrice(rsAll.getDouble(4));
      product.setStock(rsAll.getInt(5));
      product.setCategoryLevel1Id(rsAll.getInt(6));
      product.setCategoryLevel2Id(rsAll.getInt(7));
      product.setCategoryLevel3Id(rsAll.getInt(8));
      product.setFileName(rsAll.getString(9));
      product.setIsDelete(rsAll.getInt(10));

      productList.add(product);
    }
    JdbcUtil.closeConnection(conn, pstm, rsAll);
    return productList;
  }


}
