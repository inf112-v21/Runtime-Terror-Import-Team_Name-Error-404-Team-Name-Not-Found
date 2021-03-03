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
        int width_center = Gdx.graphics.getWidth()/2;

        Label title = makeTitleLabel(row_height);
        TextButton playButton = makePlayButton(width_center, row_height);
        TextButton hostButton = makeHostButton(width_center, row_height);
        TextButton joinButton = makeJoinButton(width_center, row_height);
        /*
         * Add the elements to the stage
         */
        stage.addActor(title);
        stage.addActor(playButton);
        stage.addActor(hostButton);
        stage.addActor(joinButton);

    }

    private void initBackgroundImage() {
        /*
         * Background
         */
        backgroundTexture = new Texture("assets/Robot.png");
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

    private TextButton makePlayButton(int center, int row_height) {
        /*
         * Play button
         */
        TextButton playButton = new TextButton("Play", RoboRally.skin, "default");
        playButton.setWidth(center);
        playButton.setPosition(center -playButton.getWidth()/2,Gdx.graphics.getHeight()- row_height *4);
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

    private TextButton makeHostButton(int center, int row_height) {
        /*
         * Play button
         */
        TextButton multiplayerButton = new TextButton("Host a game", RoboRally.skin, "default");
        multiplayerButton.setWidth(center);
        multiplayerButton.setPosition(center - multiplayerButton.getWidth()/2,Gdx.graphics.getHeight()- row_height *6);
        multiplayerButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Hosting the game...");
                game.startMultiplayer();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return multiplayerButton;
    }

    private TextButton makeJoinButton(int center, int row_height){
        TextButton joinButton = new TextButton("Join a Game", RoboRally.skin, "lobby");
        joinButton.setWidth(center);
        joinButton.setPosition(center - joinButton.getWidth()/2,Gdx.graphics.getHeight()- row_height *5);
        joinButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Joining the game...");
                game.joinGame();
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
