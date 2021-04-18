package inf112.skeleton.app.inputHandlers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.screen.GameScreen;

/** * a class that handles the input form keyboard when playing, making us able to play with the arrow keys
 *
 */
public class GameScreenInputHandler extends InputAdapter {
    private RoboRally game;
    private GameScreen screen;

    public GameScreenInputHandler(RoboRally aGame, GameScreen aScreen) {
        game = aGame;
        screen = aScreen;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                game.pauseGame();
                break;
            case Input.Keys.UP:
            case Input.Keys.W:
                if (screen != null) {
                    screen.robot.walk(Direction.NORTH);
                    game.render();
                }
                break;
            case Input.Keys.LEFT:
            case Input.Keys.A:
                if (screen != null) {
                    screen.robot.walk(Direction.WEST);
                    game.render();
                }
                break;
            case Input.Keys.DOWN:
            case Input.Keys.S:
                if (screen != null) {
                    screen.robot.walk(Direction.SOUTH);
                    game.render();
                }
                break;
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                if (screen != null) {
                    screen.robot.walk(Direction.EAST);
                    game.render();
                }
                break;
            default:
                break;

        }
        return true;
    }
}
