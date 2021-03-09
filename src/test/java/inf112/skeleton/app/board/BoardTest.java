package inf112.skeleton.app.board;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.object.Flag;
import inf112.skeleton.app.object.Hole;
import inf112.skeleton.app.object.Robot;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class BoardTest extends TestCase {

    private Board board;
    private Robot robot;

    @Test
    public void testCheckWin() {
        board = new Board(5, 5);
        board.flags.add(new Flag(new Location(1, 1, Direction.NORTH), 1));
        robot = new Robot(new Location(1, 1, Direction.NORTH), board);

        assertTrue(board.checkWin(robot));
    }

    @Test
    public void testCheckHole() {
        board = new Board(5, 5);
        board.holes.add(new Hole(new Location(1, 1, Direction.NORTH)));
        robot = new Robot(new Location(1, 1, Direction.NORTH), board);

        assertTrue(board.checkHole(robot));
    }

}