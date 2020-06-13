package practice6_11.club.banyuan.time;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public void nextSecond() {
        second += 1;
        if (second == 60) {
            minute += 1;
            second = 0;
        }

        if (minute == 60) {
            hour += 1;
            minute = 0;
        }
    }

    public void setTime(int aHour, int aMinute, int aSecond) {
        second = aSecond % 60;
        minute = (aMinute % 60) + aSecond / 60;
        hour = (aMinute / 60 + aHour) % 24;
    }

    public String toString() {
        String result;
        result = hour + ":" + minute + ":" + second;
//        System.out.println(result);
        System.out.printf("%02d:%02d:%02d\n",hour,minute,second);
        return result;
    }

    public static void main(String[] args) {
        Time time = new Time();
        time.setTime(20, 9, 73);
        time.toString();
//        System.out.println(time.toString());
        time.nextSecond();
        time.toString();
    }


}
