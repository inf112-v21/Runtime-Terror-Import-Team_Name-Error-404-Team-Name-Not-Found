package inf112.skeleton.app.inputHandlers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.object.CardType;
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
            case Input.Keys.NUM_1:
                if (screen != null){
                    screen.robot.UseCards(CardType.MOVE_BACKWARDS);
                }
                break;
            case Input.Keys.NUM_2:
                if (screen != null) {
                    screen.robot.UseCards(CardType.MOVE_FORWARDS_ONE);
                }
                break;
            case Input.Keys.NUM_3:
                if (screen != null) {
                    screen.robot.UseCards(CardType.MOVE_FORWARDS_TWO);
                }
                break;
            case Input.Keys.NUM_4:
                if (screen != null) {
                    screen.robot.UseCards(CardType.MOVE_FORWARDS_THREE);
                }
                break;
            case Input.Keys.NUM_5:
                if (screen != null) {
                    screen.robot.UseCards(CardType.ROTATE_LEFT);
                }
                break;
            case Input.Keys.NUM_6:
                if (screen != null) {
                    screen.robot.UseCards(CardType.ROTATE_RIGHT);
                }
                break;
            case Input.Keys.NUM_7:
                if (screen != null) {
                    screen.robot.UseCards(CardType.TURN_AROUND);
                }
                break;
            default:
                break;

        }
        return true;
    }
}
