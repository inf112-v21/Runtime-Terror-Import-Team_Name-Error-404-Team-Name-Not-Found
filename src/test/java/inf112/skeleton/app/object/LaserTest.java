package inf112.skeleton.app.object;

import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaserTest {

    private Board board;
    private Robot robot;

    @Test
    public void testTakingDamageWhenWalkOnSingleLaser(){
        board = new Board(10,10);
        board.lasers.add(new Laser(new Location(5,6, Direction.NORTH), LaserType.SINGLE));
        robot = new Robot(new Location(5,5,Direction.NORTH), board);

        robot.walk(Direction.NORTH);

        int expectedHeath = 9;

        assertEquals(expectedHeath, robot.getHealth());
    }

    @Test
    public void testTakingDamageWhenWalkOnDoubleLaser(){
        board = new Board(10,10);
        board.lasers.add(new Laser(new Location(5,6, Direction.NORTH), LaserType.DOUBLE));
        robot = new Robot(new Location(5,5,Direction.NORTH), board);

        robot.walk(Direction.NORTH);

        int expectedHeath = 8;

        assertEquals(expectedHeath, robot.getHealth());
    }

}