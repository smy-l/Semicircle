package club.banyuan.position.dao;

import club.banyuan.position.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    int getPositionListPageCount(@Param("name") String name);

    List<Position> getPositionListPage(@Param("name") String name, @Param("page") int page, @Param("rows") int rows);

    List<Position> getPositionList();

    void deletePositionByIds (List<String> asList);

    List<Position> getPositionListByName(@Param("name") String name);


}