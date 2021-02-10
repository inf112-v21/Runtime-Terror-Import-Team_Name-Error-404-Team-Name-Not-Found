package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.skeleton.app.InputHandler;
import inf112.skeleton.app.RoboRally;

public class ParentScreen implements Screen {
    RoboRally game;
    Stage stage;

    InputMultiplexer inputMultiplexer;


    public ParentScreen(RoboRally aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(new InputHandler(game,this));
        inputMultiplexer.addProcessor(stage);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
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