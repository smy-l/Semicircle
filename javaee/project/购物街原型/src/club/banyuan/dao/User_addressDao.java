package club.banyuan.dao;

import club.banyuan.pojo.User_address;

import java.util.List;

public interface User_addressDao extends IBaseDao{
  User_address getUser_addressByUserId(int id) throws Exception;
  List<User_address> getUser_addressListByUserId(int id) throws Exception;
}
