package inf112.skeleton.app.object;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Location;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.lwjgl.system.CallbackI;


public class RobotTest extends TestCase {

    private Robot robot;
    private Board board;

    @Test
    public void testWalkNorth() {
        board = new Board(5, 5);
        robot = new Robot(new Location(1, 1, Direction.NORTH), board);
        robot.walk(Direction.NORTH);
        Location expected = new Location(1, 2, Direction.NORTH);
        assertEquals(expected.getPosition().getX(), robot.getPosition().getX());
        assertEquals(expected.getPosition().getY(), robot.getPosition().getY());
    }

    @Test
    public void testWalkEast() {
        board = new Board(5, 5);
        robot = new Robot(new Location(1, 1, Direction.NORTH), board);
        robot.walk(Direction.EAST);
        Location expected = new Location(2, 1, Direction.NORTH);
        assertEquals(expected.getPosition().getX(), robot.getPosition().getX());
        assertEquals(expected.getPosition().getY(), robot.getPosition().getY());
    }

    @Test
    public void testWalkWest() {
        board = new Board(5, 5);
        robot = new Robot(new Location(1, 1, Direction.NORTH), board);
        robot.walk(Direction.WEST);
        Location expected = new Location(0, 1, Direction.NORTH);
        assertEquals(expected.getPosition().getX(), robot.getPosition().getX());
        assertEquals(expected.getPosition().getY(), robot.getPosition().getY());
    }

    @Test
    public void testWalkSouth() {
        board = new Board(5, 5);
        robot = new Robot(new Location(1, 1, Direction.NORTH), board);
        robot.walk(Direction.SOUTH);
        Location expected = new Location(1, 0, Direction.NORTH);
        assertEquals(expected.getPosition().getX(), robot.getPosition().getX());
        assertEquals(expected.getPosition().getY(), robot.getPosition().getY());
    }

    @Test
    public void testSetLocation() {
        board = new Board(5, 5);
        robot = new Robot(new Location(1, 1, Direction.NORTH), board);
        robot.setLocation(2, 2);
        Location expected = new Location(2, 2, Direction.NORTH);
        assertEquals(expected.getPosition().getX(), robot.getPosition().getX());
        assertEquals(expected.getPosition().getY(), robot.getPosition().getY());
    }
}