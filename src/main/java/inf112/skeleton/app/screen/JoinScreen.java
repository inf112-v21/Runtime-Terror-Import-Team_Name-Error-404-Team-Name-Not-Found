package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.GdxRuntimeException;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.JoinScreenInputHandler;
import inf112.skeleton.app.networking.Client;

import java.util.Timer;
import java.util.TimerTask;

public class JoinScreen extends ParentScreen {

    private Texture backgroundTexture;
    private Sprite backgroundSprite;
    private Client client;
    private Timer timer = new Timer(true);
    private List<String> playerList;
    private Boolean isHost = false;


    public JoinScreen(RoboRally aGame) {
        super(aGame);
        inputMultiplexer.addProcessor(new JoinScreenInputHandler(game, this));
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
        title.setPosition(0, Gdx.graphics.getHeight() - row_height * 1);
        title.setAlignment(Align.center);
        return title;
    }


    @Override
    public void show() {
        super.show();
        try {
            client = new Client("127.0.0.1", 5009);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    doState();
                }
            }, 0, 150);
        } catch (GdxRuntimeException e) {
            Gdx.app.log(this.getClass().getName(), e.toString());
            TitleScreen titleScreen = new TitleScreen(game);
            game.setScreen(titleScreen);
        }
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

    private void doState() {
        String state = client.getGameState();
        switch (state) {
            case "waiting":
                updatePlayers();
                break;
            case "bad":
                leave();
                break;
            case "start":
                startGame();
                break;
            default:
        }

    }

    private void startGame() {
        timer.cancel();
        game.startGame();
    }

    private void updatePlayers() {
        String[] players = client.getPlayers();
        if (players == null) {
            players = new String[]{"","","",""};
        }
        playerList.setItems(players);
    }

    private void leave() {
        if(isHost) {
            client.closeHost();
        } else {
            client.closeConnection();
        }
        client = null;
        game.getScreen().dispose();
        game.setScreen(new TitleScreen(game));;
    }
}
