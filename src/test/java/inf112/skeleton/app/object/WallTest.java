package inf112.skeleton.app.object;

import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private Board board;
    private Robot robot;

    @Test
    public void testWallsNorth(){
        board = new Board(5,5);
        board.walls.add(new Wall(new Location(2,3, Direction.SOUTH)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("north");

        Location expected = new Location(2,2, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testWallsSouth(){
        board = new Board(5,5);
        board.walls.add(new Wall(new Location(2,1, Direction.NORTH)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("south");

        Location expected = new Location(2,2, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testWallsEast(){
        board = new Board(5,5);
        board.walls.add(new Wall(new Location(3,2, Direction.WEST)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("east");

        Location expected = new Location(2,2, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testWallsWest(){
        board = new Board(5,5);
        board.walls.add(new Wall(new Location(1,2, Direction.EAST)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("west");

        Location expected = new Location(2,2, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }

    @Test
    public void testWalkBetweenToWalls(){
        board = new Board(5,5);
        board.walls.add(new Wall(new Location(2,3, Direction.WEST)));
        board.walls.add(new Wall(new Location(3,3, Direction.WEST)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("north");

        Location expected = new Location(2,3, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());
    }


    @Test
    public void testCantWalkOverWallsFacingOppositeWay(){
        board = new Board(5,5);
        board.walls.add(new Wall(new Location(2,3, Direction.NORTH)));
        robot = new Robot(new Location(2,2, Direction.NORTH), board);

        robot.walk("north");
        robot.walk("north");
        robot.walk("north");

        Location expected = new Location(2,3, Direction.NORTH);

        assertEquals(expected.getPosition(), robot.getPosition());

    }

}