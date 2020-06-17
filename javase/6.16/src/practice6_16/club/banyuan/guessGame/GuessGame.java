package practice6_16.club.banyuan.guessGame;

import java.util.Scanner;

public class GuessGame {
    static int level;
    static int number;
    static int[] enNum;
    static int guessCount;
    static int actualTimes;

    //初始化
    public static void initialization() {
        level = 0;
        number = 0;
        guessCount = 0;
        actualTimes = 0;
    }

    //设置要猜的数
    public static void startGuess() {
        initialization();
        System.out.println("请选择难度等级\n1. 0~9\n2. 0~99\n3.0~999\n0.退出");
        Scanner scanner = new Scanner(System.in);
        level = scanner.nextInt();
        switch (level) {
            case (1):
                number = (int) (Math.random() * 10);
                System.out.println("你当前选择的难度等级0~9");
                break;
            case (2):
                number = (int) (Math.random() * 100);
                System.out.println("你当前选择的难度等级0~99");
                break;
            case (3):
                number = (int) (Math.random() * 1000);
                System.out.println("你当前选择的难度等级0~999");
                break;
            case (0):
                return;
        }
        setGuessCount();
    }

    //设置次数
    public static void setGuessCount() {
        System.out.println("请输入想要猜的次数，0返回上一级");
        Scanner scanner = new Scanner(System.in);
        guessCount = scanner.nextInt();
        enNum = new int[guessCount];
        System.out.println("你的输入：" + guessCount);
        if (guessCount == 0) {
            startGuess();
        }
        System.out.println("现在开始猜数");
        guessTorF();
    }

    //是否猜中
    public static void guessTorF() {
        System.out.printf("剩余次数%d,请输入数字(0~999)：", guessCount);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(actualTimes == guessCount){
            return;
        }
        enNum[actualTimes] = input;
        judgePrint(input);
        if (input != number) {
            actualTimes++;
            guessCount--;
            guessTorF();
            return;//猜对了，结束运行
        }
        if(guessCount == 0){
            return;
        }
        record();
        System.out.println();
        System.out.println("是否继续，1.继续, 0. 退出\n");
        input = scanner.nextInt();
        if (input == 1) {
            startGuess();
        }
    }

    //判断打印
    public static void judgePrint(int input) {
        if (input < number) {
            System.out.printf("输入的是%d，没有猜中，猜小了\n", input);
        } else if (input == number) {
            System.out.printf("输入的是%d，恭喜你，猜中了\n\n", input);
//            return true;
        } else {
            System.out.printf("输入的是%d，没有猜中，猜大了\n", input);
        }
        System.out.println();
    }

    //记录
    public static void record() {
        for (int i = 0; i < actualTimes; i++) {
            if (enNum[i] - number == 0) {
                System.out.printf("第%d次 %d => 正确\n", i + 1, enNum[i]);
                return;
            }
            System.out.printf("第%d次 %d => %d\n", i + 1, enNum[i], enNum[i] - number);
        }
    }


    public static void main(String[] args) {
        GuessGame.startGuess();
//        GuessGame.setGuessCount();
////        System.out.println("现在开始猜数");
//        GuessGame.guessTorF();


    }


}
