package inf112.skeleton.app.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.board.Board;

public class GameScreen extends ParentScreen {
    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;

    Board board;


    public GameScreen(RoboRally aGame) {
        super(aGame);

        board = new Board("assets/map_001.tmx");


        /**
         * set up the camera
         */
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 12, 12);
        camera.update();

        /**
         * Render the tiles on to the camera
         */
        renderer = new OrthogonalTiledMapRenderer(board.getMap(), 1/ 300);
        renderer.setView(camera);

        /**
         *
         */




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
