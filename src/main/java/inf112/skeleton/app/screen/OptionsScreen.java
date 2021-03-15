package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.TitleScreenInputHandler;

public class OptionsScreen extends ParentScreen{
    Texture backgroundTexture;
    Sprite backgroundSprite;
    SpriteBatch spriteBatch;

    public OptionsScreen(RoboRally aGame) {
        super(aGame);
        inputMultiplexer.addProcessor(new TitleScreenInputHandler(game, this));

        initBackgroundImage();

        Table table = new Table();
        table.setFillParent(true);

        table.add(makeTitle());
        table.row();

        table.add(makeButtons());

        stage.addActor(table);
    }

    private void initBackgroundImage() {
        /*
         * Background
         */
        backgroundTexture = new Texture("assets/Robot.png");
        backgroundSprite = new Sprite(backgroundTexture);
        spriteBatch = new SpriteBatch();
    }

    private Label makeTitle() {
        Label label = new Label("RoboRally", RoboRally.skin, "title");
        return label;
    }

    private HorizontalGroup makeButtons() {
        HorizontalGroup horizontalGroup = new HorizontalGroup();
        horizontalGroup.align(Align.center);
        horizontalGroup.wrap();

        TextButton textButton = new TextButton("Play", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.startGame();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        horizontalGroup.addActor(textButton);

        textButton = new TextButton("Multiplayer", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.goToMultiplayer();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        horizontalGroup.addActor(textButton);

        textButton = new TextButton("Options", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.goToOptions();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        horizontalGroup.addActor(textButton);

        textButton = new TextButton("Exit", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        horizontalGroup.addActor(textButton);

        return horizontalGroup;
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
