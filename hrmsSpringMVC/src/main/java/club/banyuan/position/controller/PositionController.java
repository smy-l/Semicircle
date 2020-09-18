package club.banyuan.position.controller;

import club.banyuan.common.RespResult;
import club.banyuan.position.entity.Position;
import club.banyuan.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {

  @Autowired
  private PositionService positionService;

  @RequestMapping("/list")
  @ResponseBody
  public RespResult getPositionList(String name, int page, int rows) {
    List<Position> positionList = positionService.getPositionListPage(name, page, rows);
    int total = positionService.getPositionListPageCount(name);
    return RespResult.success(total, positionList);
  }

  @RequestMapping("/save")
  @ResponseBody
  public RespResult savePosition(Position position) {
    positionService.savePosition(position);
    return RespResult.success();
  }

  @RequestMapping("/delete")
  @ResponseBody
  public RespResult deletePosition(String ids) {
    positionService.deletePositionByIds(Arrays.asList(ids.split(",")));
    return RespResult.success();
  }

  @RequestMapping("/getcomboBox")
  @ResponseBody
  public List<Position> getPositionCombobox() {
    return positionService.getPositionList();
  }

}
