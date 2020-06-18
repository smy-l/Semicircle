package club.banyuan.test;

import club.banyuan.test.Card;

public class Player {
    public final int cardNum = 17;
    public String[] playerCards = new String[cardNum];
    public static int nums = 0;


    public void getCards(Card c1) {
        for (int i = 0; i < cardNum; i++) {
            int index = (int) (Math.random() * (c1.cards.length - i - (nums * cardNum)));
            playerCards[i] = c1.cards[index];
            c1.cards[index] = c1.cards[c1.cards.length - i - 1 - (nums * cardNum)];
        }
        nums++;
    }

}
