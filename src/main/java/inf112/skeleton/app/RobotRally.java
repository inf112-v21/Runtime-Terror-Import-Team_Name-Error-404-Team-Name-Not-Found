package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;

public class RobotRally implements ApplicationListener {
    private InputHandling inputs;

    @Override
    public void create() {
        inputs = new InputHandling();
    }

    @Override
    public void render() {
        inputs.checkInputs();

        // Main loop




    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
