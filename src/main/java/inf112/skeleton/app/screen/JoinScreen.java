package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.JoinScreenInputHandler;

public class JoinScreen extends ParentScreen{

    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    public JoinScreen(RoboRally aGame) {
        super(aGame);
        inputMultiplexer.addProcessor(new JoinScreenInputHandler(game,this));
        initBackgroundImage();

        int row_height = Gdx.graphics.getWidth() / 12;
        stage.addActor(makeTitleLabel(row_height));
    }

    private void initBackgroundImage() {
        /*
         * Background
         */
        backgroundTexture = new Texture("assets/stars.jpg");
        backgroundSprite = new Sprite(backgroundTexture);
        spriteBatch = new SpriteBatch();
    }

    private Label makeTitleLabel(int row_height) {
        /*
         * Title label
         */
        Label title = new Label("Waiting for host to start...", RoboRally.skin, "default");
        title.setSize(Gdx.graphics.getWidth(), row_height);
        title.setPosition(0,Gdx.graphics.getHeight()- row_height *1);
        title.setAlignment(Align.center);
        return title;
    }


    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        /*
         * clearing the screen before everything is redrawn
         */
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        spriteBatch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
