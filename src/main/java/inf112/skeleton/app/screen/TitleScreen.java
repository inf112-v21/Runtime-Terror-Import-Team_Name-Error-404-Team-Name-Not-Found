package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.TitleScreenInputHandler;

/*
 * This is a child of the parent screen class.
 *
 * Is displays the Title screen, all it does is to draw the label and button,
 * and give the button an action when it is pressed.
 *
 */
public class TitleScreen extends ParentScreen{

    Texture backgroundTexture;
    Sprite backgroundSprite;
    SpriteBatch spriteBatch;

    public TitleScreen(RoboRally aGame) {
        super(aGame);
        inputMultiplexer.addProcessor(new TitleScreenInputHandler(game, this));

        initBackgroundImage();

        int row_height = Gdx.graphics.getWidth() / 12;
        int center = Gdx.graphics.getWidth()/2;

        Label title = makeTitleLabel(row_height);
        TextButton playButton = makePlayButton(center);
        TextButton multiplayerButton = makeMultiplayerButton(center);
        /*
         * Add the elements to the stage
         */
        stage.addActor(title);
        stage.addActor(playButton);
        stage.addActor(multiplayerButton);

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
        Label title = new Label("RoboRally", RoboRally.skin, "default");
        title.setSize(Gdx.graphics.getWidth(), row_height);
        title.setPosition(0,Gdx.graphics.getHeight()- row_height *3);
        title.setAlignment(Align.center);
        return title;
    }

    private TextButton makePlayButton(int center) {
        /*
         * Play button
         */
        TextButton playButton = new TextButton("Play", RoboRally.skin, "default");
        playButton.setWidth(center);
        playButton.setPosition(center -playButton.getWidth()/2,
                center -playButton.getHeight()/2);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.startGame();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return playButton;
    }

    private TextButton makeMultiplayerButton(int center) {
        /*
         * Play button
         */
        TextButton multiplayerButton = new TextButton("Multiplayer", RoboRally.skin, "default");
        multiplayerButton.setWidth(center);
        multiplayerButton.setPosition(center - multiplayerButton.getWidth()/2,(center/4));
        multiplayerButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.startMultiplayer();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return multiplayerButton;
    }

    private TextButton makeJoinButton(int center){
        TextButton joinButton = new TextButton("Join a Game", RoboRally.skin, "lobby");
        joinButton.setWidth(center);
        joinButton.setPosition(center - joinButton.getWidth()/2,center/4);
        joinButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Yehaw mf");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        return joinButton;
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
