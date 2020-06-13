package practice6_10.club.banyuan.human;

import practice6_10.club.banyuan.animal.Dog;

public class Person {

public void train(Dog dog) {
    System.out.println("训练狗狗" + dog.getName());
    dog.bark();
  }
}
