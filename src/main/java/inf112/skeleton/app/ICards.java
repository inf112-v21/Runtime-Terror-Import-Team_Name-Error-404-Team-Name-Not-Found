package inf112.skeleton.app;

public interface ICards {


    /**
     * give cards to player form cardstack
     * get the deck of cards
     */
    ICards getCards();

    ICards shuffle(Stack<> c)
}
