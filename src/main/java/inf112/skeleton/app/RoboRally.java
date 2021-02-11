package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.skeleton.app.screen.GameScreen;
import inf112.skeleton.app.screen.TitleScreen;

public class RoboRally extends Game {
    static public Skin skin;


    @Override
    public void create() {
        skin = new Skin();
        this.setScreen(new TitleScreen(this));

    }

    /**
     * Games main loop method
     */
    @Override
    public void render() {
        super.render();
    }

    public void dispose() {
        skin.dispose();
    }


    /**
     * Game methods
     */

    public void startGame(){
        this.getScreen().dispose();
        this.setScreen(new GameScreen(this));
    }

    public void pauseGame(){
        this.getScreen().dispose();
        this.setScreen(new TitleScreen(this));
    }

    public void setFullscreen(){
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

    }

    public void setWindowed(){
        Gdx.graphics.setWindowedMode(1000,1000);
    }
}
