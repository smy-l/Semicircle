package club.banyuan.animalType;

public class Main {
    public static void main(String[] args) {
        System.out.println(AnimalType.LION.ordinal());
        System.out.println(AnimalType.ELEPHANT.ordinal());
        System.out.println(AnimalType.TIGER.ordinal());


        AnimalType a = AnimalType.valueOf(2);
        System.out.println(a);
    }
}
