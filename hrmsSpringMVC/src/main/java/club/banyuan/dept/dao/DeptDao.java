package club.banyuan.dept.dao;

import club.banyuan.dept.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDao {

    List<Dept> getDeptListPage(@Param("name") String name, @Param("page") int page, @Param("rows") int rows);

    int getDeptListPageCount(String name);

    List<Dept> getDeptList();

    List<Dept> getDeptListByName(@Param("name") String name);

    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}