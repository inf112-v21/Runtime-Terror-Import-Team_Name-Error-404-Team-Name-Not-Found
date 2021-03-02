package inf112.skeleton.app.object;

public class Card {
    private CardType cardType;
    private int priority;

    public Card(CardType cardType, int priority) {
        this.cardType = cardType;
        this.priority = priority;
    }

    public CardType getCardType() {
        return cardType;
    }
}

