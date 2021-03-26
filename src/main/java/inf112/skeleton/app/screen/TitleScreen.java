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

    private HorizontalGroup mainMenu;
    private HorizontalGroup multiplayerMenu;
    private HorizontalGroup optionsMenu;

    public TitleScreen(RoboRally aGame) {
        super(aGame);
        inputMultiplexer.addProcessor(new TitleScreenInputHandler(game, this));

        initBackgroundImage();

        Table table = new Table();
        table.setFillParent(true);

        Stack stack = new Stack();

        mainMenu = createMainMenu();
        multiplayerMenu = createMultiplayerMenu();
        optionsMenu = createOptionsMenu();

        stack.addActor(mainMenu);
        stack.addActor(multiplayerMenu);
        stack.addActor(optionsMenu);



        table.add(stack);

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

    private HorizontalGroup createMainMenu() {
        HorizontalGroup horizontalGroup = new HorizontalGroup();
        horizontalGroup.align(Align.center);
        horizontalGroup.wrap();
        horizontalGroup.wrapSpace(5.0f);

        // TITLE

        Label label = new Label("RoboRally", RoboRally.skin, "title");
        horizontalGroup.addActor(label);

        // BUTTONS

        TextButton textButton;


        textButton = new TextButton("Play", RoboRally.skin);
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
                mainMenu.setVisible(false);
                multiplayerMenu.setVisible(true);
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
                mainMenu.setVisible(false);
                optionsMenu.setVisible(true);
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

    private HorizontalGroup createMultiplayerMenu() {
        HorizontalGroup horizontalGroup = new HorizontalGroup();
        horizontalGroup.align(Align.center);
        horizontalGroup.wrap();
        horizontalGroup.wrapSpace(5.0f);
        horizontalGroup.setVisible(false);


        TextButton textButton;
        TextField textField;

        textButton = new TextButton("Host", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        horizontalGroup.addActor(textButton);

        textField = new TextField(null, RoboRally.skin);
        textField.setMessageText("IP ADDRESS");
        horizontalGroup.addActor(textField);

        textButton = new TextButton("Join", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        horizontalGroup.addActor(textButton);

        textButton = new TextButton("Back", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                multiplayerMenu.setVisible(false);
                mainMenu.setVisible(true);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        horizontalGroup.addActor(textButton);

        return horizontalGroup;
    }

    private HorizontalGroup createOptionsMenu() {
        HorizontalGroup horizontalGroup = new HorizontalGroup();
        horizontalGroup.align(Align.center);
        horizontalGroup.wrap();
        horizontalGroup.wrapSpace(5.0f);
        horizontalGroup.setVisible(false);

        TextButton textButton;


        textButton = new TextButton("Back", RoboRally.skin);
        textButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                optionsMenu.setVisible(false);
                mainMenu.setVisible(true);
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
