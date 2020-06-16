package practice6_16.club.banyuan.moraGame;

import java.util.Scanner;

public class MoraGame {
    Player[] cWarehouse;
    private static final int shears = 1;
    private static final int stone = 2;
    private static final int cloth = 3;


    public static void main(String[] args) {
        System.out.println("请输入多少人参数猜拳(2~5)");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Player[] c1 = new Player[input];

        for(int i = 0; i < input; i++){
            c1[i] = new Player();
        }




    }




}
