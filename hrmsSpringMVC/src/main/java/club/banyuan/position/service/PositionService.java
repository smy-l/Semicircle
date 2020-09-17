package club.banyuan.position.service;

import club.banyuan.position.entity.Position;

import java.util.List;

public interface PositionService {

  List<Position> getPositionListPage(String name, int page, int rows);

  int getPositionListPageCount(String name);

  void savePosition(Position position);

  void deletePositionByIds(List<String> asList);

  List<Position> getPositionList();

  List<Position> getPositionList(String positionName);
}
