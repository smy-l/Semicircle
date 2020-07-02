package practice6_29.club.banyuan.classExample;

public class AnimalType {

    public static final AnimalType LION = new AnimalType("狮子", 1);
    public static final AnimalType ELEPHANT = new AnimalType("大象", 2);
    public static final AnimalType TIGER = new AnimalType("老虎", 3);
    public static final AnimalType UNKNOWN = new AnimalType("未知物种", -1);

    private String name;
    private int id;

    private AnimalType(String name){
        this.name = name;
    }

    private AnimalType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public static AnimalType valueOf(String typeName) {
        if (ELEPHANT.name.equals(typeName)) {
            return ELEPHANT;
        } else if (LION.name.equals(typeName)) {
            return LION;
        } else if (TIGER.name.equals(typeName)) {
            return TIGER;
        }
        return UNKNOWN;
    }

    public static AnimalType valueOf(int id) {
        if (ELEPHANT.id == id) {
            return ELEPHANT;
        } else if (LION.id == id) {
            return LION;
        } else if (TIGER.id == id) {
            return TIGER;
        }
        return UNKNOWN;
    }

    public static int animalTypeToInt(AnimalType object) {
        if (LION.name.equals(object.name)) {
            return 1;
        } else if (ELEPHANT.name.equals(object.name)) {
            return 2;
        } else if (TIGER.name.equals(object.name)) {
            return 3;
        }
        return -1;
    }

    public static String animalTypeToString(AnimalType object) {
        if (LION.name.equals(object.name)) {
            return LION.name;
        } else if (ELEPHANT.name.equals(object.name)) {
            return ELEPHANT.name;
        } else if (TIGER.name.equals(object.name)) {
            return TIGER.name;
        }
        return UNKNOWN.name;
    }

}
