package practice6_29.club.banyuan.animalType;

public enum AnimalType {
    LION("狮子", 1),
    ELEPHANT("大象", 2),
    TIGER("老虎", 3),
    UNKNOWN("未知物种", -1),

    ;

    private String name;
    private int id;

    AnimalType(String name, int code) {
        this.name = name;
        this.id = code;
    }

    public static AnimalType valueOf(int id) {
        AnimalType[] values = values();
        for (AnimalType value : values) {
            if(value.id == id){
                return value;
            }
        }
        return UNKNOWN;
    }


}
