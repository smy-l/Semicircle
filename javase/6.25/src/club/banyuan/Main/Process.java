package club.banyuan.Main;

import club.banyuan.character.Fighter;

public class Process {
//    private static int rounds;

    private static void attacking(Fighter f1, Fighter f2) {
        if (f1.getVertigo() == 0) {
            f1.attack(f2);
        } else {
            System.out.println(f1.getName() + "眩晕1回合");
            f1.recover();
        }
    }

    public static void start(Fighter f1, Fighter f2) {
        while (f1.isAlive() & f2.isAlive()) {
            attacking(f1, f2);
            if (f2.isAlive()) {
                attacking(f2, f1);
            }
        }
    }

    public static void end(Fighter f1, Fighter f2) {
        if (f2.isAlive()) {
            printResult(f1, f2);
        } else {
            printResult(f2, f1);
        }
    }

    private static void printResult(Fighter f1, Fighter f2) {
        System.out.println(f1.getName() + "被" + f2.getName() + "打败了");
    }

    public static void process(Fighter f1, Fighter f2) {
        start(f1, f2);
        end(f1, f2);
    }
}
