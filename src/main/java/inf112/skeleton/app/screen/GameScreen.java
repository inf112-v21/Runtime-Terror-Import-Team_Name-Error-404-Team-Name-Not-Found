package inf112.skeleton.app.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;
import inf112.skeleton.app.inputHandlers.GameScreenInputHandler;
import inf112.skeleton.app.object.Robot;

public class GameScreen extends ParentScreen {
    Board board;

    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;

    public Robot robot;


    public GameScreen(RoboRally aGame) {
        super(aGame);

        /**
         * Adds det inputhandler for the game inputs to te multiplexer
         */
        inputMultiplexer.addProcessor(new GameScreenInputHandler(game,this));

        /**
         * Create the board, this class also renders the map
         */
        board = new Board("./assets/map_001.tmx");

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

        robot = new Robot(new Location(new IntVector(1,1),Direction.NORTH), "assets/player.png", board);
    }

    @Override
    public void show() {
        super.show();
        robot.draw();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        renderer.render();


        /**
         * Here we check the win and death condition.
         */
        if (board.checkWin(robot.getPosition().getX(),robot.getPosition().getY())){
            robot.onWin();
        }
        if (board.checkHole(robot.getPosition().getX(),robot.getPosition().getY())){
            robot.onDeath();
        }
    }
}
