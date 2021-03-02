package inf112.skeleton.app.object;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    ArrayList<Card> discard;

    public Deck() {
        cards = new ArrayList<Card>();
        discard = new ArrayList<Card>();

        init();
    }

    private void init() {
        for (int i = 0; i < 2; i++){
            cards.add(new Card (CardType.MOVE_FORWARDS_ONE, 900+i*50));
            cards.add(new Card (CardType.MOVE_FORWARDS_TWO, 500+i*50));
            cards.add(new Card (CardType.MOVE_FORWARDS_THREE, 400+i*50));
            cards.add(new Card (CardType.MOVE_BACKWARDS, 100+i*50));
            cards.add(new Card (CardType.ROTATE_LEFT, 300+i*50));
            cards.add(new Card (CardType.ROTATE_RIGHT, 700+i*50));
            cards.add(new Card (CardType.TURN_AROUND, 600+i*50));
        }
    }

    public void shuffle() {
        cards.addAll(discard);
        discard.removeAll(discard);
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards(int nrOfCards) {
        ArrayList<Card> drawnCards = new ArrayList<Card>();

        for (int i = 0; i < nrOfCards; i++){
            if (!cards.isEmpty()){
                drawnCards.add(cards.get(0));
                cards.remove(0);
            } else {
                shuffle();
                drawnCards.add(cards.get(0));
                cards.remove(0);
            }
        }

        return drawnCards;
    }

    public void putCards(ArrayList<Card> cards) {
        discard.addAll(cards);
    }
}
