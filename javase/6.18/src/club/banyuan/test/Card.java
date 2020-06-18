package club.banyuan.test;

import club.banyuan.test.Player;

public class Card {
    public final int SIZE = 54;
    public final int LAST_SIZE = 3;
    public String[] cards = new String[SIZE];
    public String[] huaSe = {"♠", "♥", "♣", "♦"};
    public String[] holeCard = new String[3];

    public void setCards() {
        int huaSeIndex = 0;
        for (int i = 0; i < SIZE - 2; i++) {
            int cardNum = i % 13 + 1;
            if (i != 0 && i % 13 == 0) {
                huaSeIndex++;
            }
            if (cardNum == 11) {
                cards[i] = huaSe[huaSeIndex] + "J";
            } else if (cardNum == 12) {
                cards[i] = huaSe[huaSeIndex] + "Q";
            } else if (cardNum == 13) {
                cards[i] = huaSe[huaSeIndex] + "K";
            } else if (cardNum == 1) {
                cards[i] = huaSe[huaSeIndex] + "A";
            } else {
                cards[i] = huaSe[huaSeIndex] + cardNum;
            }
        }
        cards[52] = "小王";
        cards[53] = "大王";
    }

    public void setHoleCard(){
//        for (int i = 0; i < holeCard.length; i++) {
//            int index = (int) (Math.random() * (cards.length - i - (Player.nums * 17)));
//            holeCard[i] = cards[index];
//            holeCard[index] = cards[cards.length - i - 1 - (Player.nums * 17)];
//        }

        System.arraycopy(cards, 0, holeCard, 0, holeCard.length);
    }
}

