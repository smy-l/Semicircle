public class LittleCar extends Car {
  private int seatNum;

  public LittleCar() {
  }

  public LittleCar(String model, int factoryYear, String factory, String code, String maintenanceDate, int seatNum) {
    super(model, factoryYear, factory, code, maintenanceDate);
    this.seatNum = seatNum;
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

    String timeRecord = "尚未出租";
    for (int i = 0; i < rantRecord.size(); i += 2) {
      if(rantRecord.size() % 2 != 0){
        rantRecord.add("尚未归还！");
      }
      timeRecord = rantRecord.get(i) + "-" + rantRecord.get(i + 2);
    }

    return "-----" + getCode() + "------\n" +
            getSeatNum() + "座车\n" +
            "年份：" + getFactoryYear() +
            "\n厂家：" + getFactory() +
            "\n状态：" + status +
            "\n保养日期：" + getEndMaintainedDate() +
            "\n租借记录：" + timeRecord;
  }
}
