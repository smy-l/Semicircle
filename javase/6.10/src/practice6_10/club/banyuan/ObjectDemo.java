package practice6_10.club.banyuan;

class Elephant {

  int heightInCM;
}

class Lion{
  int heightInCM;
}

class Fridge {

  int heightInCM;
  Elephant storage1;
  Lion storage2;

  public void store(Elephant elephant) {
    if(storage1 == null & storage2 == null){
      storage1 = elephant;
    }else{
      System.out.println("冰箱已经满了!");
    }
  }

  public void store(Lion lion){
    if(storage1 == null & storage2 == null){
      storage2 = lion;
    }else{
      System.out.println("冰箱已经满了!");
    }
  }

  public Elephant remove(){
    Elephant temp = storage1;
    storage1 = null;
    return temp;
  }

}

class ObjectDemo {
  static Elephant createElephant(int heightInCM) {
    System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
    // 使用定义的类作为数据类型
    // 使用new 创建一个对象（实例）
    Elephant elephant = new Elephant();
    // 使用. 访问对象的属性，可以对属性赋值或使用
    elephant.heightInCM = heightInCM;
    return elephant;
  }

  static Lion createLion(int heightInCM){
    System.out.printf("创建一个狮子，高度%d厘米\n",heightInCM);
    Lion lion = new Lion();
    lion.heightInCM = heightInCM;
    return lion;
  }

  static Fridge createFridge(int heightInCM) {
    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
    Fridge fridge = new Fridge();
    fridge.heightInCM = heightInCM;
    return fridge;
  }

  static void putInElephant(Elephant elephant, Fridge fridge) {
    System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.heightInCM, fridge.heightInCM);
    if(elephant.heightInCM < fridge.heightInCM) {

      // 使用对象方法
      fridge.store(elephant);
      System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.storage1.heightInCM);
    } else {
      System.out.printf("冰箱装不下!\n");
    }
    
  }

  public static void main(String[] args) {
    Elephant elephant = createElephant(300);
    Fridge fridge = createFridge(500);
    putInElephant(elephant, fridge); 

    Lion lion = createLion(300);
    fridge.store(lion);
  }
}


