package inf112.skeleton.app.board;

import inf112.skeleton.app.object.Belt;
import inf112.skeleton.app.object.Card;
import inf112.skeleton.app.object.CardType;
import inf112.skeleton.app.object.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveOnCardTest{

    private Board board;
    private Robot robot;
    private Card card;

    @Test
    public void TestCardMoveForwardThree(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_FORWARDS_THREE, 200);

        Location expected = new Location(2,5,Direction.NORTH);

        robot.UseCards(card);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardMoveForwardTow(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_FORWARDS_TWO, 200);

        Location expected = new Location(2,4,Direction.NORTH);

        robot.UseCards(card);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardMoveForwardOne(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_FORWARDS_ONE, 200);

        Location expected = new Location(2,3,Direction.NORTH);

        robot.UseCards(card);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardMoveBackwards(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.MOVE_BACKWARDS, 200);

        Location expected = new Location(2,1,Direction.NORTH);

        robot.UseCards(card);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardRotateLeft(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.ROTATE_LEFT, 200);

        Location expected = new Location(2,2,Direction.WEST);

        robot.UseCards(card);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardRotateRight(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.ROTATE_RIGHT, 200);

        Location expected = new Location(2,2,Direction.EAST);

        robot.UseCards(card);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

    @Test
    public void TestCardTurnAround(){
        board = new Board(10,10);
        robot = new Robot(new Location(2,2, Direction.NORTH), board);
        card = new Card(CardType.TURN_AROUND, 200);

        Location expected = new Location(2,2,Direction.SOUTH);

        robot.UseCards(card);

        assertEquals(expected.getPosition(),robot.getPosition());
    }

}
