import java.util.ArrayList;
import java.util.List;

public class Car {
  protected String model;
  protected int factoryYear;
  protected String factory;
  protected String code;

  protected boolean isMaintain;
  protected String startMaintainedDate;
  protected String endMaintainedDate = "-";

  protected boolean isRanting;
  protected String rantTime;
  protected String returnTime;

  protected int customerCode;
  List<String> rantRecord = new ArrayList<>();

  public Car() {
  }

  public Car(String model, int factoryYear, String factory, String code, String endMaintenanceDate) {
    this.model = model;
    this.factoryYear = factoryYear;
    this.factory = factory;
    this.code = code;
    this.endMaintainedDate = endMaintenanceDate;
  }

  public boolean isMaintain(boolean status) {
    if (status == isMaintain) {
      return false;
    }
    isMaintain = status;
    return true;
  }

  public boolean isRanting(boolean status) {
    if (status == isRanting) {
      return false;
    }
    isRanting = status;
    return true;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getFactoryYear() {
    return factoryYear;
  }

  public void setFactoryYear(int factoryYear) {
    this.factoryYear = factoryYear;
  }

  public String getFactory() {
    return factory;
  }

  public void setFactory(String factory) {
    this.factory = factory;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getStartMaintainedDate() {
    return startMaintainedDate;
  }

  public void setStartMaintainedDate(String startMaintainedDate) {
    this.startMaintainedDate = startMaintainedDate;
  }

  public String getEndMaintainedDate() {
    return endMaintainedDate;
  }

  public void setEndMaintainedDate(String endMaintainedDate) {
    this.endMaintainedDate = endMaintainedDate;
  }

  public String getRantTime() {
    return rantTime;
  }

  public void setRantTime(String rantTime) {
    this.rantTime = rantTime;
  }

  public String getReturnTime() {
    return returnTime;
  }

  public void setReturnTime(String returnTime) {
    this.returnTime = returnTime;
  }

  public int getCustomerCode() {
    return customerCode;
  }

  public void setCustomerCode(int customerCode) {
    this.customerCode = customerCode;
  }
}
