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
                    //gameScreen.robot.erase();
                    //gameScreen.robot.setLocation(gameScreen.robot.getPosition().getX(), gameScreen.robot.getPosition().getY()+1);
                    //gameScreen.robot.draw();
                    gameScreen.robot.walk("up");
                    game.render();
                }
                break;
            case Input.Keys.LEFT:
                if (gameScreen != null){
                    //gameScreen.robot.erase();
                    //gameScreen.robot.setLocation(gameScreen.robot.getPosition().getX()-1, gameScreen.robot.getPosition().getY());
                    //gameScreen.robot.draw();
                    gameScreen.robot.walk("left");
                    game.render();
                }
                break;
            case Input.Keys.RIGHT:
                if (gameScreen != null){
                    //gameScreen.robot.erase();
                    //gameScreen.robot.setLocation(gameScreen.robot.getPosition().getX()+1, gameScreen.robot.getPosition().getY());
                    //gameScreen.robot.draw();
                    gameScreen.robot.walk("right");
                    game.render();
                }
                break;
            case Input.Keys.DOWN:
                if (gameScreen != null){
                    //gameScreen.robot.erase();
                    //gameScreen.robot.setLocation(gameScreen.robot.getPosition().getX(), gameScreen.robot.getPosition().getY()-1);
                    //gameScreen.robot.draw();
                    gameScreen.robot.walk("down");
                    game.render();
                }
                break;
            default:

        }
        return true;
    }

}
