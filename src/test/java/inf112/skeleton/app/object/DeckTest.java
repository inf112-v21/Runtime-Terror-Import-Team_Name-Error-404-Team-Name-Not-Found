package inf112.skeleton.app.object;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck;

    @Test
    void getZeroCardsFromDeck() {
        deck = new Deck();
        ArrayList<Card> the_cards = deck.getCards(0);

        ArrayList<Card> empty_card_list = new ArrayList<Card>();

        assertEquals(the_cards,empty_card_list);
    }

    @Test
    void testShuffleNotGiveSameDeck() {
        deck = new Deck();
        Deck deck2 = new Deck();
        deck.shuffle();
        assertNotEquals(deck,deck2);
    }

    @Test
    void getNineCardsFromDeck() {
        deck = new Deck();

        ArrayList<Card> cards_on_hand = deck.getCards(9);

        assertEquals(cards_on_hand.size(),9);
    }


}