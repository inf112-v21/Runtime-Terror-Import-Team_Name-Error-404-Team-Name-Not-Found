package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.skeleton.app.RoboRally;


/**
 * This is the parent class for the different screens.
 *
 * it is very primitive and contains stuff that is needed for all the different screens
 *
 * It stores the game and stage, sets up an input multiplexer
 * and do some basic renders, clearing the screen first.
 *
 */
public class ParentScreen implements Screen {
    RoboRally game;
    SpriteBatch spriteBatch;
    Stage stage;

    InputMultiplexer inputMultiplexer;


    public ParentScreen(RoboRally aGame) {
        game = aGame;

        stage = new Stage(new ScreenViewport());

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float v) {
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
