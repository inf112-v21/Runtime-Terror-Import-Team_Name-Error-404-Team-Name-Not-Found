package inf112.skeleton.app.inputHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.screen.JoinScreen;

public class JoinScreenInputHandler extends InputAdapter {
    private final RoboRally game;
    private final JoinScreen screen;

    public JoinScreenInputHandler(RoboRally aGame, JoinScreen aScreen) {
        this.game = aGame;
        this.screen = aScreen;
    }
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                game.pauseGame();
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

