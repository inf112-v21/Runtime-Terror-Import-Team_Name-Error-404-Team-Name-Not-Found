package inf112.skeleton.app.object;

import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressBeltTest {

    private Board board;
    private Robot robot;

    @Test
    public void testExpressBeltNorth(){
        board = new Board(10,10);
        board.expressBelts.add(new ExpressBelt(new Location(5,6, Direction.NORTH)));
        board.expressBelts.add(new ExpressBelt(new Location(5,7, Direction.NORTH)));
        robot = new Robot(new Location(5,5, Direction.NORTH), board);

        robot.walk("north");

        Location expected = new Location(5,8, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testExpressBeltSouth(){
        board = new Board(10,10);
        board.expressBelts.add(new ExpressBelt(new Location(5,4, Direction.SOUTH)));
        board.expressBelts.add(new ExpressBelt(new Location(5,3, Direction.SOUTH)));
        robot = new Robot(new Location(5,5, Direction.NORTH), board);

        robot.walk("south");

        Location expected = new Location(5,2, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testExpressBeltWest(){
        board = new Board(10,10);
        board.expressBelts.add(new ExpressBelt(new Location(4,5, Direction.WEST)));
        board.expressBelts.add(new ExpressBelt(new Location(3,5, Direction.WEST)));
        robot = new Robot(new Location(5,5, Direction.NORTH), board);

        robot.walk("west");

        Location expected = new Location(2,5, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testExpressBeltEast(){
        board = new Board(10,10);
        board.expressBelts.add(new ExpressBelt(new Location(6,5, Direction.EAST)));
        board.expressBelts.add(new ExpressBelt(new Location(7,5, Direction.EAST)));
        robot = new Robot(new Location(5,5, Direction.NORTH), board);

        robot.walk("east");

        Location expected = new Location(8,5, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testWalkOnSideWayExpressBelt(){
        board = new Board(10,10);
        board.expressBelts.add(new ExpressBelt(new Location(5,6, Direction.EAST)));
        board.expressBelts.add(new ExpressBelt(new Location(6,6, Direction.EAST)));
        robot = new Robot(new Location(5,5, Direction.NORTH), board);

        robot.walk("north");

        Location expected = new Location(7,6, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

}