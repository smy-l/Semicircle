package club.banyuan.season;

public class Main {

    public static void main(String[] args) {

        for (Season season : Season.values()) {
            season.getMonthRange();
        }

    }

}
