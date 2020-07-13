public class VanCar extends Car {
  private String fuelType;

  public VanCar() {
  }

  public VanCar(String model, int factoryYear, String factory, String code, String maintenanceDate, String fuelType) {
    super(model, factoryYear, factory, code, maintenanceDate);
    this.fuelType = fuelType;
  }

  public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
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
            getFuelType() + "车" +
            "\n年份：" + getFactoryYear() +
            "\n厂家：" + getFactory() +
            "\n状态：" + status +
            "\n保养日期：" + getEndMaintainedDate() +
            "\n租借记录：" + timeRecord;
  }
}
