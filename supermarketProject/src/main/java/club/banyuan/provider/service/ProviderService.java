package club.banyuan.provider.service;

import club.banyuan.provider.entity.Provider;

import java.util.List;

public interface ProviderService {

  void saveProvider(Provider provider);

  List<Provider> getProviderList();

  List<Provider> getProviderListByNameAndDesc(String name, String desc);

  Provider getProviderById(Integer id);

  void deleteProvider(Integer id);


}
