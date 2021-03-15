package inf112.skeleton.app.inputHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.screen.MultiplayerScreen;
import inf112.skeleton.app.screen.TitleScreen;

/**
 * a class that handles the input form keyboard when on title screen, to execute commands
 */
public class TitleScreenInputHandler extends InputAdapter {
    private RoboRally game;
    private Screen screen;

    public TitleScreenInputHandler(RoboRally aGame, Screen aScreen) {
        game = aGame;
        screen = aScreen;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                Gdx.app.exit();
                break;
            case Input.Keys.F:
                game.setFullscreen();
                break;
            case Input.Keys.G:
                game.setWindowed();
                break;
            default:

        }
        return true;
    }

}
