package inf112.skeleton.app;

/*public enum points {
    public static int oneHundred = 100;
    public static int twoHundred = 200;
    public static int fiveHundred = 500;
    public static int sevenHundredAndFifty = 750;
}*/

/*public enum Cards {
    TURN_AROUND,
    ROTATE_LEFT,
    ROTATE_RIGHT,
    MOVE_FORWARDS_ONE,
    MOVE_FORWARDS_TWO,
    MOVE_FORWARDS_THREE,
    MOVE_BACKWARDS;

    @Override
    public String toString() {
        return super.toString().replace("_", " ");
    }
}*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class getCards {

    public static Stack<String> cardList(){
        Stack<String> cards = new Stack<String>();
        cards.add("TURN_AROUND");
        cards.add("ROTATE_LEFT");
        cards.add("ROTATE_RIGHT");
        cards.add("MOVE_FORWARDS_ONE");
        cards.add("MOVE_FORWARDS_TWO");
        cards.add("MOVE_FORWARDS_THREE");
        cards.add("MOVE_BACKWARDS");

        return cards;
    }

}

