package club.banyuan.Main;

import club.banyuan.character.Fighter;

public class Process {
    private static int rounds;

    private static void attacking(Fighter f1, Fighter f2) {
        if (f1.getDizziness() == 0) {
            f1.attack(f2);
            rounds++;
        } else {
            System.out.println(f1.getName() + "眩晕1回合");
            rounds++;
//            f1.vertigo(rounds);
            f1.recover();
        }
    }

    public static void start(Fighter f1, Fighter f2) {
        rounds = 0;
        while (f1.getBloodVolume() > 0 & f2.getBloodVolume() > 0) {
            if (rounds % 2 == 0) {
                attacking(f1, f2);
            } else {
                attacking(f2, f1);
            }
            System.out.println();
        }
    }

    public static void end(Fighter f1, Fighter f2) {
        if (f1.getBloodVolume() < 0) {
            System.out.println(f1.getName() + "被打败了");
        } else {
            System.out.println(f2.getName() + "被打败了");
        }
    }

    public static void process(Fighter f1, Fighter f2) {
        start(f1, f2);
        end(f1, f2);
    }
}
