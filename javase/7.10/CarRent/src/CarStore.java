import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarStore {

  public static final String PATH = PropUtil.getPath();
  List<Car> cars = new ArrayList<>();

  void store() {
    File file = new File(PATH);
    if (!file.exists()) {
      File parentFile = file.getParentFile();
      if (!parentFile.exists()) {
        parentFile.mkdirs();
      }
    }

    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(file))) {

      writer.write(JSONObject.toJSONString(cars));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Car addCar(String model, int factoryYear, String factory, String code, String maintenanceDate) {
    Car car = new Car(model, factoryYear, factory, code, maintenanceDate);
    cars.add(car);
    store();
    return car;
  }

  public boolean rantCar(String code, int customerCode, String startRantTime, String rantingTime) throws IllegalAccessException {
    for (Car car : cars) {
      if (car.getCode().equals(code)) {
        if (car.isMaintain) {
          throw new IllegalAccessException("汽车在保养，无法出租!");
        }
        if(!car.isRanting) {
          car.isRanting(true);
          car.setCustomerCode(customerCode);
          car.setStartMaintainedDate(startRantTime);
          car.setRantTime(rantingTime);
        }
      } else {
        throw new IllegalAccessException("没有该车！");
      }
    }
    return true;
  }

  public boolean returnCar(String code, String returnTime) {
    for (Car car : cars) {
      if (car.getCode().equals(code)) {
        if(car.isRanting) {
          car.isRanting(false);
          car.setReturnTime(returnTime);
        }
      }
    }
    return true;
  }

  public boolean maintainingCar(String code) throws IllegalAccessException {
    for (Car car : cars) {
      if (car.getCode().equals(code)) {
        if (car.isRanting) {
          throw new IllegalAccessException("汽车已租出，无法保养！");
        }
        if(car.isMaintain) {
          throw new IllegalAccessException("汽车正在保养！");
        }
        car.isMaintain(true);
      }
    }
    return true;
  }

  public boolean endMaintainCar(String code, String endMaintainedTime) throws IllegalAccessException {
    for (Car car : cars) {
      if (car.getCode().equals(code)) {
        if (car.isMaintain) {
          car.setEndMaintainedDate(endMaintainedTime);
          car.isMaintain(false);
        }else{
          throw new IllegalAccessException("汽车没有保养！");
        }
      }
    }
    return true;
  }

  public void load() {
    File file = new File(PATH);
    if (!file.exists()) {
      File parentFile = file.getParentFile();
      if (!parentFile.exists()) {
        parentFile.mkdirs();
      }
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))
    ) {
      writer.write(JSONObject.toJSONString(cars));
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
