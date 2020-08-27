package club.banyuan.dao;

import club.banyuan.pojo.UserAddress;

import java.util.List;

public interface UserAddressDao {
  List<UserAddress> getUserAddListByUserId(int id) throws Exception;
  int addUserAddress(UserAddress userAddress);
}
