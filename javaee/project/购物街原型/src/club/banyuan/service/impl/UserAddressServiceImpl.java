package club.banyuan.service.impl;

import club.banyuan.dao.UserAddressDao;
import club.banyuan.dao.impl.UserAddressDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.UserAddress;
import club.banyuan.service.UserAddressService;

import java.sql.Connection;
import java.util.List;

public class UserAddressServiceImpl implements UserAddressService {
  @Override
  public UserAddress getAdByUserId(int id) throws Exception {
    Connection conn = DataSourceUtil.openConnection();
    UserAddressDao userAddressDao = new UserAddressDaoImpl(conn);
    UserAddress user_address = userAddressDao.getUserAddressByUserId(id);
    DataSourceUtil.closeConnection(conn);
    return user_address;
  }

  @Override
  public List<UserAddress> getAdListByUserId(int id) throws Exception {
    Connection conn = DataSourceUtil.openConnection();
    UserAddressDao userAddressDao = new UserAddressDaoImpl(conn);
    List<UserAddress> userAddList = userAddressDao.getUserAddressListByUserId(id);
    DataSourceUtil.closeConnection(conn);
    return userAddList;
  }
}
