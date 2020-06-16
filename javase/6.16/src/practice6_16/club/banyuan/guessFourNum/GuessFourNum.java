package practice6_16.club.banyuan.guessFourNum;

import java.util.Scanner;

public class GuessFourNum {
    static char[] example = {'0','1','2','3','4','5','6','7','8','9'};
    private static char[] value = new char[4];
    
    private static int index = 0; //下标正确的数目
    private static int curNum = 0; //数字正确的数目

    //设置随机数
    public static void setValue(){
        int exIndex;
        for (int i = 0; i < 4; i++) {
            exIndex = (int) (Math.random() * (10 - i));
            value[i] = example[exIndex];
            example[exIndex] = example[example.length - 1 - i];
        }
    }

    //猜四个数字
    public static void guessFourNum() {
        setValue();
        for (char one: value) {
            System.out.print(one);
        }
        System.out.println("\n====ans====");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (input.length() != 4) {
            System.out.println("输入有误，请输入4个数字");
            input = scanner.next();
        }
        char[] temp = input.toCharArray();

        while (index != 4) {
            count(temp); //统计正确的数目
            judgePrint(); //打印
            if (index != 4) {  //如果不对，重制，继续判断
                curNum = 0;
                index = 0;
                guessFourNum();
            }
        }
    }

    //统计下标和数字正确数量
    public static void count(char[] temp) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (value[i] == temp[j]) {
                    curNum++;
                    if (i == j) {
                        index++;
                    }
                }
            }
        }
    }

    //判断打印
    public static void judgePrint() {
        if (curNum == 4 & index == 4) {
            System.out.println("回答正确");
        } else if (index == 0 & curNum != 0) {
            System.out.printf("包含了%d个正确的数字\n但是这些数字位置错误\n", curNum);
        } else {
            System.out.printf("包含了%d个正确的数字\n%d个数字的位置正确\n", curNum, index);
        }
    }


    public static void main(String[] args) {
        System.out.println("猜一猜4个不重复的数字，请输入4个数字： ");
        GuessFourNum.guessFourNum();
    }

}
