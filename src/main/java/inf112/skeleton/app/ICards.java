package inf112.skeleton.app;

public interface ICards {


    /**
     * give cards to player form cardstack
     * get the deck of cards
     */
    ICards getDeck();

    //shuffle the deck so its randomly ordered
    ICards shuffle(Stack<> c);

    //get 9 random cards from the deck
    ICards getCards();

    //pick 5 cards of the 9 drawn
    ICards pickCards();

    //Choose the order to play your cards, then phase through the 5 phases for each card choosen
    ICards cardOrder();


    // After the 5 phases
    ICards discardCards();

    /**
     * shuffles the discarded cards with the 'normal' cards
     */
    ICards reshuffle();
}
