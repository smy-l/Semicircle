public class LittleCar extends Car {
  private int seatNum;

  public LittleCar() {
  }

  public int getSeatNum() {
    return seatNum;
  }

  public void setSeatNum(int seatNum) {
    this.seatNum = seatNum;
  }

  @Override
  public String toString() {
    String status = "";
    if (isMaintain) {
      status = "保养";
    } else if (isRanting) {
      status = "借出";
    } else {
      status = "可用";
    }

    return "-----" + getCode() + "------" +
            getSeatNum() + "车" +
            "年份：" + getFactoryYear() +
            "厂家：" + getFactory() +
            "状态：" + status +
            "保养日期：" + getEndMaintainedDate() +
            "租借记录：";
  }
}
