package club.banyuan.provider.service.impl;

import club.banyuan.provider.dao.ProviderDao;
import club.banyuan.provider.entity.Provider;
import club.banyuan.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

  @Autowired
  private ProviderDao providerDao;

  @Override
  public void saveProvider(Provider provider) {
    if (provider.getId() == 0) {
      providerDao.insert(provider);
    } else {
      providerDao.updateByPrimaryKey(provider);
    }
  }

  @Override
  public List<Provider> getProviderList() {
    return providerDao.getProviderList();
  }

  @Override
  public List<Provider> getProviderListByNameAndDesc(String name, String desc) {
    return providerDao.getProviderListByNameAndDesc(name, desc);
  }

  @Override
  public Provider getProviderById(Integer id) {
    return providerDao.selectByPrimaryKey(id);
  }

  @Override
  public void deleteProvider(Integer id) {
    providerDao.deleteByPrimaryKey(id);
  }
}
