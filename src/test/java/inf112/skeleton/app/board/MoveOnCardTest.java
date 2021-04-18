package inf112.skeleton.app.board;

import inf112.skeleton.app.object.Belt;
import inf112.skeleton.app.object.Card;
import inf112.skeleton.app.object.CardType;
import inf112.skeleton.app.object.Robot;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveOnCardTest extends TestCase {

    private Board board;
    private Robot robot;
    private Card card;

    @Test
    public void TestCardMoveForwardThree(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_FORWARDS_THREE, 200);

        Location expected = new Location(2,5,Direction.NORTH);

        robot.UseCards(card,robot);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardMoveForwardTow(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_FORWARDS_TWO, 200);

        Location expected = new Location(2,4,Direction.NORTH);

        robot.UseCards(card,robot);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardMoveForwardOne(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_FORWARDS_TWO, 200);

        Location expected = new Location(2,3,Direction.NORTH);

        robot.UseCards(card,robot);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardMoveForwardOne(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_FORWARDS_TWO, 200);

        Location expected = new Location(2,3,Direction.NORTH);

        robot.UseCards(card,robot);

        assertEquals(expected.getPosition(),robot.getPosition());
    }





}
