package club.banyuan.service;

import club.banyuan.pojo.UserAddress;

import java.util.List;

public interface UserAddressService {
  UserAddress getAdByUserId(int id) throws Exception;
  List<UserAddress> getAdListByUserId(int id) throws Exception;
}
