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
    private final String name;

    Weekday(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void printIsHoliday(Weekday weekday) {
        if (isHoliday(weekday)) {
            System.out.println(weekday + "是假日");
        } else {
            System.out.println(weekday + "不是假日");
        }
    }

    public static boolean isWeekDay(Weekday weekday) {
        return weekday.ordinal() <= Weekday.FRIDAY.ordinal();
    }

    public static boolean isHoliday(Weekday weekday) {
        return !isWeekDay(weekday);
    }
}
