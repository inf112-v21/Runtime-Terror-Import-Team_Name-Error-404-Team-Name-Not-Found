package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.TitleScreenInputHandler;

public class MultiplayerScreen extends ParentScreen{
    Texture backgroundTexture;
    Sprite backgroundSprite;
    SpriteBatch spriteBatch;

    public MultiplayerScreen(RoboRally aGame) {
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
        Label label = new Label("Multiplayer", RoboRally.skin, "title");
        return label;
    }

    private HorizontalGroup makeButtons() {
        HorizontalGroup horizontalGroup = new HorizontalGroup();
        horizontalGroup.align(Align.center);
        horizontalGroup.wrap();

        TextField textField = new TextField(null, RoboRally.skin);
        textField.setMessageText("IP ADDRESS");
        horizontalGroup.addActor(textField);

        TextButton textButton = new TextButton("Back", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.goToMenu();
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


