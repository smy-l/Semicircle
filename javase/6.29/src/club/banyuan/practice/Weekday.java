package club.banyuan.practice;

public enum Weekday {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天"),

    ;
    private String name;

    Weekday(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void print(Weekday weekday) {
        if (isHoliday(weekday)) {
            System.out.println(weekday.toString() + "是假日");
        } else {
            System.out.println(weekday.toString() + "不是假日");
        }
    }

    public static boolean isWeekDay(Weekday weekday) {
        Weekday[] values = values();
        for (Weekday value : values) {
            if (!weekday.equals(SATURDAY) && !weekday.equals(SUNDAY)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHoliday(Weekday weekday) {
        return !isWeekDay(weekday);
    }
}
