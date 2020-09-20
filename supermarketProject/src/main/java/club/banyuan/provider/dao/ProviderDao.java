package club.banyuan.provider.dao;

import club.banyuan.provider.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderDao {
    List<Provider> getProviderList();

    List<Provider> getProviderListByNameAndDesc(@Param("name") String name, @Param("desc") String desc);

    int deleteByPrimaryKey(Integer id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
}