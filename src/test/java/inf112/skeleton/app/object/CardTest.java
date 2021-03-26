package inf112.skeleton.app.object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card card;

    @Test
    void getCorrectCardType() {
        card = new Card(CardType.MOVE_FORWARDS_THREE,123);

        assertEquals(card.getCardType(),CardType.MOVE_FORWARDS_THREE);
    }

}