package inf112.skeleton.app.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.board.Board;

public class GameScreen extends ParentScreen {
    Board board;

    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;


    public GameScreen(RoboRally aGame) {
        super(aGame);

        /**
         * Load the map and split each layer into a map layer
         */

        board = new Board("./assets/testMap.tmx");

        /**
         * set up the camera
         */
        camera = new OrthographicCamera();
        camera.setToOrtho(false, (float) board.getHeight(), (float) board.getWidth());
        camera.update();

        /**
         * Render the tiles on to the camera
         */
        renderer = new OrthogonalTiledMapRenderer(board.getMap(), 1/(float) board.getTileHeight());
        renderer.setView(camera);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        renderer.render();
    }
}
