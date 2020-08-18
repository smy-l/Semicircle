package club.banyuan.dao.impl;

import club.banyuan.dao.User_addressDao;
import club.banyuan.pojo.User_address;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;

public class User_addressDaoImpl extends IBaseDaoImpl implements User_addressDao {
  public User_addressDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public User_address tableToClass(ResultSet rs) throws Exception {
    User_address user_address = new User_address();
    user_address.setId(rs.getInt(1));
    user_address.setUserId(rs.getInt(2));
    user_address.setAddress(rs.getString(3));
    user_address.setCreateTime((Data) rs.getTime(4));
    user_address.setIsDefault(rs.getInt(5));
    user_address.setRemark(rs.getString(6));
    return user_address;
  }
}
