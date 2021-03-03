package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.MultiplayerScreenInputHandler;
import inf112.skeleton.app.networking.Client;
import inf112.skeleton.app.networking.Host;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LobbyScreen extends ParentScreen{

    Texture backgroundTexture;
    Sprite backgroundSprite;
    SpriteBatch spriteBatch;

    private List<String> playerList;
    private String hostIP = "127.0.0.1";
    private Boolean isHost = true;
    private Client client;
    private String gameState = "waiting";


    public LobbyScreen(RoboRally aGame) {
        // This is the "host" screen for now
        super(aGame);
        inputMultiplexer.addProcessor(new MultiplayerScreenInputHandler(game, this));

        initBackgroundImage();




        int row_height = Gdx.graphics.getWidth() / 12;
        int center = Gdx.graphics.getWidth()/2;

        playerList = new List<String>(RoboRally.skin);
        playerList.setItems(" ", " ", " ", " ");


        Label title = makeTitleLabel(row_height);
        Button leaveButton = leaveButton(center);

        Table table = new Table();

        table.setFillParent(true);
        table.defaults().pad(5);
        table.add(title);
        table.add(playerList);
        table.row();
        table.add(leaveButton);
        /*
         * Add the elements to the stage
         */
        stage.addActor(table);
    }

    private void initBackgroundImage() {
        /*
         * Background
         */
        backgroundTexture = new Texture("assets/stars.png");
        backgroundSprite = new Sprite(backgroundTexture);
        spriteBatch = new SpriteBatch();
    }

    private Label makeTitleLabel(int row_height) {
        /*
         * Title label
         */
        Label title = new Label("Game Lobby", RoboRally.skin, "lobby");
        title.setSize(Gdx.graphics.getWidth(), row_height);
        title.setPosition(0,Gdx.graphics.getHeight()- row_height *3);
        title.setAlignment(Align.center);
        return title;
    }

    private void leave() {
        if(isHost) {
            client.closeHost();
        } else {
            client.closeConnection();
        }
        client = null;
        Gdx.app.postRunnable(() -> game.setScreen(new TitleScreen(game)));
    }


    private Button leaveButton(int where) {
        Button leaveButton = new TextButton("Leave lobby", RoboRally.skin, "lobby");
        leaveButton.setWidth(where);
        leaveButton.setPosition(where -leaveButton.getWidth()/2,
                where -leaveButton.getHeight()/2);
        leaveButton.addListener(new InputListener() {
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                leave();
            }

            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return leaveButton;
    }

    private void updatePlayers() {
        String[] players = client.getPlayers();
        if (players == null) {
            players = new String[]{"","","",""};
        }
        playerList.setItems(players);
    }

    @Override
    public void show() {
        Thread gameHost = new Thread(() -> new Host(hostIP));
        gameHost.setName("Host");
        gameHost.start();

        // Self client
        client = new Client(hostIP, 5009);

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                doState();
            }
        }, 0, 100);
    }

    private void doState() {
        switch (gameState){
            case "waiting":
                updatePlayers();
                break;
            default:
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
}
