package club.banyuan.dao;

import club.banyuan.pojo.UserAddress;

import java.util.List;

public interface UserAddressDao extends IBaseDao{
  UserAddress getUserAddressByUserId(int id) throws Exception;
  List<UserAddress> getUserAddressListByUserId(int id) throws Exception;
}
