package practice6_16.club.banyuan.draw;

import java.util.Random;
import java.util.Scanner;

public class Draw {
    public static void draw(){
        System.out.println("进行抽签，输入0退出");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input != 0) {
            int rlt = (int) (Math.random() * 100);
            if (rlt >= 0 & rlt < 5) {
                System.out.println("大吉");
            } else if (rlt >= 5 & rlt < 15) {
                System.out.println("中吉");
            } else if (rlt >= 15 & rlt < 30) {
                System.out.println("小吉");
            } else if (rlt >= 30 & rlt < 60) {
                System.out.println("吉");
            } else if (rlt >= 60 & rlt < 80) {
                System.out.println("末吉");
            } else if (rlt >= 80 & rlt < 95) {
                System.out.println("凶");
            } else {
                System.out.println("大凶");
            }
            input = scanner.nextInt();
        }

    }

    public static void main(String[] args) {
        Draw.draw();
    }
}
