package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.MultiplayerScreenInputHandler;
import inf112.skeleton.app.inputHandlers.TitleScreenInputHandler;
import inf112.skeleton.app.networking.Client;
import inf112.skeleton.app.networking.Host;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class LobbyScreen extends ParentScreen {

    Texture backgroundTexture;
    Sprite backgroundSprite;
    SpriteBatch spriteBatch;

    private List<String> playerList;
    private String hostIP;
    private Boolean isHost;
    private Client client;
    private final Timer timer = new Timer(true);
    private RoboRally game;


    public LobbyScreen(RoboRally aGame, String hostIP, Boolean isHost) {
        super(aGame);
        this.hostIP = hostIP;
        this.isHost = isHost;
        this.game = aGame;

        inputMultiplexer.addProcessor(new MultiplayerScreenInputHandler(game, this));

        initBackgroundImage();


        int row_height = Gdx.graphics.getWidth() / 12;
        int center = Gdx.graphics.getWidth()/2;

        playerList = new List<>(RoboRally.skin);
        playerList.setItems(" ", " ", " ", " ");


        Label title = makeTitleLabel(row_height);
        Button leaveButton = leaveButton(center);
        Button startButton = startButton();
        Label waiting = waitingLabel();

        Table table = new Table();

        table.setFillParent(true);
        table.setDebug(false);
        table.defaults().pad(5);
        table.add(title);
        table.row();
        if (!isHost) {
            table.add(waiting);
        }
        table.add(playerList).prefWidth(200);
        table.row();
        if (isHost) {
            table.add(startButton).prefWidth(200);
            table.row();
        }
        table.add(leaveButton).prefWidth(200);
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

    private Label waitingLabel() {
        /*
         * waiting label
         */
        Label title = new Label("Waiting for host to start", RoboRally.skin, "lobby");
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
        game.getScreen().dispose();
        game.setScreen(new TitleScreen(game));;
    }


    private Button leaveButton(int where) {
        Button leaveButton = new TextButton("Leave lobby", RoboRally.skin, "lobby");
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

    private Button startButton() {
        Button startButton = new TextButton("Start Game", RoboRally.skin, "lobby");
        startButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.startGame();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return startButton;
    }

    private void updatePlayers() {
        String[] players = client.getPlayers();
        if (players == null) {
            players = new String[]{" "," "," "," "};
        }
        playerList.setItems(players);
    }

    private void setGameStart() {
        client.setGameState("setStart");
    }

    private void startGame() {
        timer.cancel();
        game.startGame();
    }


    @Override
    public void show() {
        super.show();
        if (isHost) {
            Thread hostThread = new Thread(() -> new Host(hostIP));
            hostThread.setName("Host");
            hostThread.start();
        }

        try {
            client = new Client(hostIP, 5009);
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
    };

    private void doState() {
        String state = client.getGameState();
        switch (state){
            case "waiting":
                updatePlayers();
                System.out.println(Arrays.toString(client.getPlayers()));
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
