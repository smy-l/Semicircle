package club.banyuan.common;

import java.util.ArrayList;
import java.util.List;

public class RespResult extends ArrayList<Object> {

  public RespResult success(List<?> objects) {
    RespResult rlt = new RespResult();
    return rlt;
  }

}
