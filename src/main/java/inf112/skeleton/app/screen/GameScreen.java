package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
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

        /*
         * Adds det inputhandler for the game inputs to te multiplexer
         */
        inputMultiplexer.addProcessor(new GameScreenInputHandler(game, this));

        /*
         * Create the board, this class also renders the map
         */
        board = new Board("./assets/map_001.tmx");

        /*
         * set up the camera
         */
        camera = new OrthographicCamera();
        camera.setToOrtho(false, (float) board.getHeight(), (float) board.getWidth());
        camera.translate(0,-1);
        /*
         * Render the tiles on to the camera
         */
        renderer = new OrthogonalTiledMapRenderer(board.getMap(), 1 / (float) board.getTileHeight());
        renderer.setView(camera);
        /*
         * Initlize the player robot(s)
         */
        robot = new Robot(new Location(new IntVector(1, 1), Direction.NORTH), board);
        robot.setRobotTexture("assets/player.png");
    }

    @Override
    public void show() {
        super.show();
        robot.draw();
    }

    @Override
    public void render(float delta) {

        /*
         * clearing the screen before everything is redrawn
         */
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.render();


        /*
         * Here we check the win and death condition.
         */
        if (board.checkWin(robot)) {
            robot.onWin();
        }
        if (board.checkHole(robot)) {
            robot.onDeath();
        }
    }

    @Override
    public void resize(int width, int height)
    {
        if (width > height) {
            camera.viewportWidth = 12f* width/height;
            camera.viewportHeight = 14f;
        } else {
            camera.viewportWidth = 12f;
            camera.viewportHeight = 14f* height/width;
        }
        camera.update();
        renderer.setView(camera);
    }
}
