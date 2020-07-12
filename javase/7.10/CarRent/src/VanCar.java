public class VanCar extends Car {
  private String fuelType;

  public VanCar() {
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

    return "-----" + getCode() + "------" +
            getFuelType() + "车" +
            "年份：" + getFactoryYear() +
            "厂家：" + getFactory() +
            "状态：" + status +
            "保养日期：" + getEndMaintainedDate() +
            "租借记录：";
  }
}
