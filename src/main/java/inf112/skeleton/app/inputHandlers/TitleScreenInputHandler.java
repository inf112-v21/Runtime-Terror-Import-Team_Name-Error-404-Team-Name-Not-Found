package inf112.skeleton.app.inputHandlers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.screen.TitleScreen;

/**
 * a class that handles the input form keyboard when on title screen, to execute commands
 */
public class TitleScreenInputHandler extends InputAdapter {
    private RoboRally game;
    private TitleScreen screen;

    public TitleScreenInputHandler(RoboRally aGame, TitleScreen aScreen) {
        game = aGame;
        screen = aScreen;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                break;
            case Input.Keys.UP:
                break;
            case Input.Keys.LEFT:
                break;
            case Input.Keys.RIGHT:
                break;
            default:

        }
        return true;
    }

}
