package club.banyuan.service.impl;

import club.banyuan.dao.User_addressDao;
import club.banyuan.dao.impl.User_addressDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.User_address;
import club.banyuan.service.User_addressService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class User_addressServiceImpl implements User_addressService {
  @Override
  public User_address getAdByUserId(int id) throws Exception {
    Connection conn = DataSourceUtil.openConnection();
    User_addressDao user_addressDao = new User_addressDaoImpl(conn);
    User_address user_address = user_addressDao.getUser_addressByUserId(id);
    DataSourceUtil.closeConnection(conn);
    return user_address;
  }

  @Override
  public List<User_address> getAdListByUserId(int id) throws Exception {
    Connection conn = DataSourceUtil.openConnection();
    User_addressDao user_addressDao = new User_addressDaoImpl(conn);
    List<User_address> userAddList = user_addressDao.getUser_addressListByUserId(id);
    DataSourceUtil.closeConnection(conn);
    return userAddList;
  }
}
