package inf112.skeleton.app.object;

import java.util.ArrayList;

/**
 * a class for the object Player
 */
public class Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> programmingRegister;

    private final Robot robot;
    private GameElements gameElements;

    public Player(Robot robot, GameElements gameElements){
        this.robot = robot;
        this.gameElements = gameElements;
    }



    private void drawCard(){
        hand = gameElements.deck.getCards(9);
    }

    public void selectCard(int cardNrIndex){
        programmingRegister.add(hand.get(cardNrIndex));
        hand.remove(cardNrIndex);
    }

    public void unselectCard(int cardNrIndex){
        hand.add(programmingRegister.get(cardNrIndex));
        programmingRegister.remove(cardNrIndex);
    }

    public void discardHand(){
        gameElements.deck.putCards(hand);
        hand.clear();
    }

    public void emptyRegister(){
        gameElements.deck.putCards(programmingRegister);
        programmingRegister.clear();
    }


}
