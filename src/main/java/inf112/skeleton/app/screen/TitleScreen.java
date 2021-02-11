package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.inputHandlers.TitleScreenInputHandler;

public class TitleScreen extends ParentScreen{

    public TitleScreen(RoboRally aGame) {
        super(aGame);
        inputMultiplexer.addProcessor(new TitleScreenInputHandler(game, this));

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont(Gdx.files.internal("skin/arial_black.fnt"));
        labelStyle.font = myFont;
        labelStyle.fontColor = Color.RED;

        int row_height = Gdx.graphics.getWidth() / 12;

        Label title = new Label("Title",labelStyle);
        title.setSize(Gdx.graphics.getWidth(),row_height);
        title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
        title.setAlignment(Align.center);
        stage.addActor(title);


        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = myFont;
        buttonStyle.fontColor = Color.BLUE;
        TextButton playButton = new TextButton("Play",buttonStyle);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,
                Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
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
        stage.addActor(playButton);

    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
