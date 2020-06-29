package club.banyuan.fg.refine;

import java.util.Random;
import java.util.Scanner;

// int 猜拳人数
// 1个人是玩家 n个人是计算机  =》 String 玩家类型
// n个玩家的出拳   int // 123
// n个玩家，每个玩家的胜负情况 boolean
public class ex {

//    public static final String COMPUTER = "电脑";
//    public static final String PLAYER = "玩家";
//    public static final String STONE_WIN_PATTERN = "121";

    //    public static final String SCISSOR_WIN_PATTERN = "232";
    public static void main(String[] args) {

        while (true) {
            setPattern();
            compact();
//            printrlt(players);
//            players = getLeftPlayers(players);
        }
    }

    private static int getUsersTotal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("多少人参与猜拳（2~5人）:");
        int rlt = scanner.nextInt();
        if (rlt > 5 || rlt < 2) {
            System.out.println("输入不合法！");
            return getUsersTotal();
        }
        for (int i = 0; i < rlt; i++) {
            PlayerType.values()[i].setOut(false);
        }
        return rlt;
    }

    private static void setPattern() {
        int count = getUsersTotal();
        if(!PlayerType.HUMAN.isOut()) {
            scanUserPattern();
        }
        for (int i = 1; i < count; i++) {
            if(!PlayerType.values()[i].isOut()) {
                scanUserPattern();
            }
            PlayerType.values()[i].setPattern(randomPattern());
        }
    }

    private static FingerPattern randomPattern() {
        Random random = new Random();
        // [0,3) + 1 = [1,4) = [1,3]
        int index = random.nextInt(3) + 1;
        return FingerPattern.values()[index];
    }

    private static void scanUserPattern() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请出拳：\n1.石头\n2.剪刀\n3.布");
        int pattern = scanner.nextInt();
        if (pattern < 1 || pattern > 3) {
            System.out.println("输入不合法！");
            scanUserPattern();
        } else {
            PlayerType.values()[0].setPattern(FingerPattern.values()[pattern - 1]);
        }
    }

    private static void compact() {
        String rlt = "";
        for (PlayerType playerType : PlayerType.values()) {
            if (!rlt.contains(playerType.getPattern().getCode() + "")) {
                rlt += playerType.getPattern();
            }
        }

        if (rlt.length() != 2) {
            return;
        }

        int winPattern = getWinPattern(rlt);
        int count = 0;
        for (int i = 0; i < PlayerType.values().length; i++) {
            if(!PlayerType.values()[i].isOut()){
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            boolean isOut = PlayerType.values()[i].getPattern().getCode() != winPattern;
            PlayerType.values()[i].setOut(isOut);
        }

    }

//    private static void printrlt() {
//        if (players.length == left) {
//            for (Player player : players) {
//                System.out.println(player.getName() + "出了" + patternToString(player.getPattern()));
//            }
//            System.out.println("平局");
//        } else {
//            for (Player player : players) {
//                String msg = player.isOut() ? "被淘汰" : "胜出";
//                System.out.println(player.getName() + "出了" + patternToString(player.getPattern()) + msg);
//            }
//        }
//
//        if (left == 1) {
//            for (Player player : players) {
//                if (!player.isOut()) {
//                    System.out.println(player.getName() + "胜出");
//                }
//            }
//        }
//
//    }

    private static String patternToString(int pattern) {
        switch (pattern) {
            case 1:
                return "石头";
            case 2:
                return "剪刀";
            case 3:
                return "布";
        }
        return null;
    }

    private static int getWinPattern(String rlt) {
        if (FingerPattern.STONE_WIN_PATTERN.getName().contains(rlt)) {
            return 1;
        } else if (FingerPattern.SCISSOR_WIN_PATTERN.getName().contains(rlt)) {
            return 2;
        } else {
            return 3;
        }
    }
}
