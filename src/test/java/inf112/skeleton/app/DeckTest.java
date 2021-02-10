package inf112.skeleton.app;

import org.junit.Test;

public class CardTest {
    @Test
    public void gettingACardShouldGiveUsACard() {
        // Precondition
        IDeck the_deck_to_get_cards_from = new Deck();
        // Act
        ICard the_card_we_drew_from_the_deck = the_deck_to_get_cards_from.getCard();
        // Assert/postcondition
        AsserTrue(ICard.isinstanceof(the_card_we_drew_from_the_deck));

    }
}
