import java.util.Scanner;

public class CarLauncher {

  private static final Scanner scanner = new Scanner(System.in);
  private static final CarStore carStore = new CarStore();

  public static void main(String[] args) {

    carStore.load();

    while (true) {
      System.out.println("****租车系统菜单****");
      System.out.println();
      System.out.println("1.添加汽车");
      System.out.println("2.出租汽车");
      System.out.println("3.归还汽车");
      System.out.println("4.汽车保养");
      System.out.println("5.结束保养");
      System.out.println("6.查询信息");
      System.out.println("7.退出系统");

      String input = scanner.nextLine();
      switch (input) {
        case "1":
          addCars();
          break;
        case "2":
          rantCars();
          break;
        case "3":
          returnCars();
          break;
        case "4":
          maintainCars();
          break;
        case "5":
          endMaintainCars();
          break;
        case "6":
          printInfo();
          break;
        case "7":
          System.out.println("谢谢使用");
          return;

      }
    }

  }

  private static void addCars() {
    String model = inputModel();
    int factoryYear = inputFactoryYear();
    String factory = inputFactory();
    String code = inputCode(model);
    int seatNum = inputSeatNum(model);
    String fuelType = inputFuelType(model);
    String maintainDate = intputMaintainDate();

    Car car = carStore.addCar(model, factoryYear, factory, code, maintainDate);
    if (car instanceof LittleCar) {
      ((LittleCar) car).setSeatNum(seatNum);
      System.out.println(car);
    }
    if (car instanceof VanCar) {
      ((VanCar) car).setFuelType(fuelType);
      System.out.println(car);
    }
  }

  private static String intputMaintainDate() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("保养日期(年-月-日): ");
    return scanner.nextLine();
  }

  private static String inputFuelType(String model) {
    if ("Van".equals(model)) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("请输入燃油类型：");
      System.out.println("1.汽油");
      System.out.println("2.柴油");
      return scanner.nextLine();
    }
    return null;
  }

  private static int inputSeatNum(String model) {
    if ("Car".equals(model)) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("输入轿车座数(4/7):");
      return scanner.nextInt();
    }
    return -1;
  }

  private static String inputCode(String model) {
    Scanner scanner = new Scanner(System.in);
    String code = "";
    if ("Van".equals(model)) {
      System.out.print("车辆编号: v_");
      code = "v_";
    }
    if ("Car".equals(model)) {
      System.out.print("车辆编号: c_");
      code = "c_";
    }
    int codeNum = scanner.nextInt();
    code = code + codeNum;
    return code;
  }

  private static String inputFactory() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("厂家：");
    return scanner.nextLine();
  }

  private static int inputFactoryYear() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("出厂年份: ");
    return scanner.nextInt();
  }

  private static String inputModel() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入添加的车型");
    System.out.println("Van: 卡车");
    System.out.println("Car: 轿车");
    System.out.print("请输入：");
    return scanner.nextLine();
  }

  private static void rantCars() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("汽车编号：");
    String code = scanner.nextLine();
    System.out.println();

    System.out.print("顾客编号: ");
    int customerCode = scanner.nextInt();
    System.out.println();

    System.out.print("出租起始时间(年-月-日)：");
    String date = scanner.nextLine();
    System.out.println();

    System.out.print("出租时长(天): ");
    String rantTime = scanner.nextLine();
    System.out.println();

    try {
      carStore.rantCar(code, customerCode, date, rantTime);
      System.out.println(code + "被顾客" + customerCode + "借出，从" + date + "开始，借出" + rantTime + "天");
    } catch (IllegalAccessException e) {
      System.out.println(e.getMessage());
    }

  }

  private static void returnCars() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("汽车编号：");
    String code = scanner.nextLine();
    System.out.println();

    System.out.print("归还日期(年-月-日): ");
    String date = scanner.nextLine();
    carStore.returnCar(code, date);

  }

  private static void maintainCars() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("保养汽车编号：");
    String code = scanner.nextLine();
    System.out.println();

    try {
      carStore.maintainingCar(code);
    } catch (IllegalAccessException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(code + "开始保养");

  }

  private static void endMaintainCars() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("汽车编号：");
    String code = scanner.nextLine();
    System.out.println();

    System.out.print("保养结束时间(年-月-日):");
    String date = scanner.nextLine();
    System.out.println();

    try {
      carStore.endMaintainCar(code, date);
      System.out.println();
    } catch (IllegalAccessException e) {
      System.out.println(e.getMessage());
    }

  }

  private static void printInfo() {
    System.out.println("*********卡车**********");
    for (int i = 0; i < carStore.cars.size(); i++) {
      if(carStore.cars.get(i).getModel().equals("Car")){
        VanCar car = (VanCar)carStore.cars.get(i);
        System.out.println(car);
      }
    }

    System.out.println("*********轿车**********");
    for (int i = 0; i < carStore.cars.size(); i++) {
      if(carStore.cars.get(i).getModel().equals("Van")){
        LittleCar car = (LittleCar)carStore.cars.get(i);
        System.out.println(car);
      }
    }

  }

}
