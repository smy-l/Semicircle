package club.banyuan.position.service.impl;

import club.banyuan.position.dao.PositionDao;
import club.banyuan.position.entity.Position;
import club.banyuan.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PositionServiceImpl implements PositionService {

  @Autowired
  private PositionDao positionDao;

  @Override
  public List<Position> getPositionListPage(String name, int page, int rows) {
    return positionDao.getPositionListPage(name, (page - 1) * rows, rows );
  }

  @Override
  public int getPositionListPageCount(String name) {
    return positionDao.getPositionListPageCount(name);
  }

  @Override
  public void savePosition(Position position) {
    if (position.getId() == null) {
      positionDao.insert(position);
    } else {
      positionDao.updateByPrimaryKey(position);
    }
  }

  @Override
  public void deletePositionByIds(List<String> asList) {
    positionDao.deletePositionByIds(asList);
  }

  @Override
  public List<Position> getPositionList() {
    return positionDao.getPositionList();
  }

  @Override
  public List<Position> getPositionList(String positionName) {
    return positionDao.getPositionListByName(positionName);
  }
}
