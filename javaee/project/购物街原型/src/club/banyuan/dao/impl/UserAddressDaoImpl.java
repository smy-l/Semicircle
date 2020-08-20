package club.banyuan.dao.impl;

import club.banyuan.dao.UserAddressDao;
import club.banyuan.pojo.UserAddress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAddressDaoImpl extends IBaseDaoImpl implements UserAddressDao {
  public UserAddressDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public UserAddress tableToClass(ResultSet rs) throws Exception {
    UserAddress user_address = new UserAddress();
    user_address.setId(rs.getInt(1));
    user_address.setUserId(rs.getInt(2));
    user_address.setAddress(rs.getString(3));
    user_address.setCreateTime((Date) rs.getObject(4));
    user_address.setIsDefault(rs.getInt(5));
    user_address.setRemark(rs.getString(6));
    return user_address;
  }

  @Override
  public UserAddress getUserAddressByUserId(int id) throws Exception {
    UserAddress user_address = null;
    String sql = "select * from user_address where userId = ?";
    ResultSet rs = executeQuery(sql, new Object[]{id});
    while (rs.next()) {
      user_address = tableToClass(rs);
    }
    this.closeResource();
    return user_address;
  }

  @Override
  public List<UserAddress> getUserAddressListByUserId(int id) throws Exception {
    List<UserAddress> addressList = new ArrayList<>();
    String sql = "select * from user_address where userId = ?";
    ResultSet rs = executeQuery(sql, new Object[]{id});
    while (rs.next()) {
      UserAddress address = tableToClass(rs);
      addressList.add(address);
    }
    this.closeResource();
    return addressList;
  }
}
