package inf112.skeleton.app.object;

import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeltTest {

    private Board board;
    private Robot robot;

    @Test
    public void testBeltNorth(){
        board = new Board(5,5);
        board.belts.add(new Belt(new Location(2,3, Direction.NORTH)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("north");

        Location expected = new Location(2,4, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testBeltSouth(){
        board = new Board(5,5);
        board.belts.add(new Belt(new Location(2,1, Direction.SOUTH)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("south");

        Location expected = new Location(2,0, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testBeltWest(){
        board = new Board(5,5);
        board.belts.add(new Belt(new Location(1,2, Direction.WEST)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("west");

        Location expected = new Location(0,2, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testBeltEast(){
        board = new Board(5,5);
        board.belts.add(new Belt(new Location(3,2, Direction.EAST)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("east");

        Location expected = new Location(4,2, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testWalkingOnSideWayBelt(){
        board = new Board(5,5);
        board.belts.add(new Belt(new Location(2,3, Direction.EAST)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("north");

        Location expected = new Location(3,3, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

}