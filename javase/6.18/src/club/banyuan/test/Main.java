package club.banyuan.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Card c1 = new Card();
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        c1.setCards();
        System.out.println(Arrays.toString(c1.cards));

        p1.getCards(c1);
        p2.getCards(c1);
        p3.getCards(c1);
        c1.setHoleCard();


        System.out.print("玩家1：");
        System.out.println(Arrays.toString(p1.playerCards));

        System.out.print("玩家2：");
        System.out.println(Arrays.toString(p2.playerCards));

        System.out.print("玩家3：");
        System.out.println(Arrays.toString(p3.playerCards));

        System.out.print("底牌：");
        System.out.println(Arrays.toString(c1.holeCard));

    }
}
