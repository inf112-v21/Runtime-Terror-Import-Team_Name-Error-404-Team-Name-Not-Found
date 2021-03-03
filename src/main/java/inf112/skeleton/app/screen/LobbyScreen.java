package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.MultiplayerScreenInputHandler;
import inf112.skeleton.app.networking.Client;

import java.util.ArrayList;

public class LobbyScreen extends ParentScreen{

    Texture backgroundTexture;
    Sprite backgroundSprite;
    SpriteBatch spriteBatch;

    private ArrayList<String> playerList;
    private String hostIP;
    private Boolean isHost;
    private Client client;


    public LobbyScreen(RoboRally aGame) {
        // This is the "host" screen for now
        super(aGame);
        inputMultiplexer.addProcessor(new MultiplayerScreenInputHandler(game, this));

        initBackgroundImage();



        int row_height = Gdx.graphics.getWidth() / 12;
        int center = Gdx.graphics.getWidth()/2;

        Label title = makeTitleLabel(row_height);


        /*
        * Add the elements to the stage
        */
        stage.addActor(title);

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
}
