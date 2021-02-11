package inf112.skeleton.app.inputHandlers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.screen.GameScreen;

/**
 * a class that handles the input form keyboard when playing, making us able to play with the arrow keys
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
                if (screen != null) {
                    screen.robot.walk("up");
                    game.render();
                }
                break;
            case Input.Keys.LEFT:
                if (screen != null) {
                    screen.robot.walk("left");
                    game.render();
                }
                break;
            case Input.Keys.RIGHT:
                if (screen != null) {
                    screen.robot.walk("right");
                    game.render();
                }
                break;
            case Input.Keys.DOWN:
                if (screen != null) {
                    screen.robot.walk("down");
                    game.render();
                }
                break;
            default:

        }
        return true;
    }
}
