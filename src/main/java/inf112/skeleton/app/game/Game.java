package inf112.skeleton.app.game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.networking.Client;
import inf112.skeleton.app.screen.GameScreen;


public class Game extends InputAdapter {

    private final Client client;
    private boolean roundRunning = false;

    private final GameScreen gameScreen;
    private final InputMultiplexer inputMultiPlexer;

    public Game(RoboRally game, Client client, Boolean isHost) {
        this.client=client;
        inputMultiPlexer = new InputMultiplexer();
        inputMultiPlexer.addProcessor(this);

        gameScreen = new GameScreen(game);
        game.setScreen(gameScreen);
        client.ready();
        if (isHost) {
            new HostGame(client);
        }
    }
}
