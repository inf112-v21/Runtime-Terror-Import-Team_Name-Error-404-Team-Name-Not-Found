package inf112.skeleton.app.inputHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.screen.LobbyScreen;

public class MultiplayerScreenInputHandler extends InputAdapter {
    private final LobbyScreen screen;
    private final RoboRally game;

    public MultiplayerScreenInputHandler(RoboRally aGame, LobbyScreen aScreen) {
        game = aGame;
        screen = aScreen;
    }
    @Override
    public boolean keyUp(int keycode){
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
