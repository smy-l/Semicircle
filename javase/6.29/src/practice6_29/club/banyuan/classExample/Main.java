package practice6_29.club.banyuan.classExample;

public class Main {

  public static void main(String[] args) {
    Elephant elephant = new Elephant();
    AnimalType animalType = elephant.getAnimalType();
    System.out.println(animalType);

    // animalType = AnimalType.LION;
    //
    // if (animalType == AnimalType.ELEPHANT) {
    //   // do something
    // } else if(animalType == AnimalType.LION){
    //
    // }

  }
}
