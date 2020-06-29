package club.banyuan.practice;

public class Main {
    public static void main(String[] args) {

        for (Weekday value : Weekday.values()) {
            Weekday.printIsHoliday(value);
        }

        Weekday sat = Weekday.SATURDAY;
        for (Weekday day : Weekday.values()) {
            System.out.print(day.compareTo(sat) + " ");
            if (day.compareTo(sat) > 0) {
                System.out.println("大于sat");
            } else if (day.compareTo(sat) < 0) {
                System.out.println("小于sat");
            } else {
                System.out.println("等于sat");
            }
        }
    }
}
