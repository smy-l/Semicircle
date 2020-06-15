package practice6_15.club.banyuan.myRandom;

import java.util.Random;

public class MyRandom {
    public static int randomInt(int from, int to) {
//        int randomNum;
//        int interval = to - from;
//        Random random = new Random();
//        randomNum = random.nextInt(interval + 1) + from;
//        return randomNum;

        return (int) (Math.random() * (to - from + 1) + from);



    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(randomInt(-10,5) + " ");
        }

    }
}
