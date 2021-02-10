package inf112.skeleton.app;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.screen.GameScreen;
import inf112.skeleton.app.screen.TitleScreen;

public class InputHandler extends InputAdapter {
    private RoboRally game;
    private Screen screen;
    private GameScreen gameScreen;

    public InputHandler(RoboRally aGame, Screen aScreen) {
        game = aGame;
        screen = aScreen;
    }
    public InputHandler(RoboRally aGame, GameScreen aScreen) {
        game = aGame;
        gameScreen = aScreen;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                game.setScreen(new TitleScreen(game));
                break;
            case Input.Keys.UP:
                if (gameScreen != null){
                    gameScreen.robot.walk(1);
                    game.render();
                }
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
