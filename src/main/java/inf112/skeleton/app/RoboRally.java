package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import inf112.skeleton.app.screen.TitleScreen;

public class RoboRally extends Game {
    static public Skin skin;

    @Override
    public void create() {
        skin = new Skin();
        this.setScreen(new TitleScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public void dispose() {
        skin.dispose();
    }
}
