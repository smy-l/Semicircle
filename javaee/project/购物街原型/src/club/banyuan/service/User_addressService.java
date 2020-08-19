package club.banyuan.service;

import club.banyuan.pojo.User_address;

import java.sql.SQLException;
import java.util.List;

public interface User_addressService {
  User_address getAdByUserId(int id) throws Exception;
  List<User_address> getAdListByUserId(int id) throws Exception;
}
