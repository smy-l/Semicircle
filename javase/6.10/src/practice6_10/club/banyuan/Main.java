package practice6_10.club.banyuan;
import practice6_10.club.banyuan.animal.Cat;
import practice6_10.club.banyuan.animal.Dog;
import practice6_10.club.banyuan.human.Person;


public class Main {

  public static void main(String[] args) {
    Person person = new Person();
    Cat cat = new Cat();
    cat.name = "汤姆";
    Dog dog = new Dog();
    dog.setName("小强");
    person.train(dog);
    dog.playWith(cat);
  }
}


