package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.RoboRally;

public class GameScreen extends ParentScreen {
    private TiledMap map_TiledMap;
    private TiledMapTileLayer board_MapLayer;
    private TiledMapTileLayer holes_MapLayer;
    private TiledMapTileLayer flags_MapLayer;
    private TiledMapTileLayer players_MapLayer;

    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;

    private float MAP_SIZE_X;
    private float MAP_SIZE_Y;
    private float TILE_SIZE;


    public GameScreen(RoboRally aGame) {
        super(aGame);

        /**
         * Load the map and split each layer into a map layer
         */
        map_TiledMap = new TmxMapLoader().load("./assets/map_001.tmx");

        board_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Board");
        holes_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Holes");
        flags_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Flags");
        players_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Players");

        /**
         * Defines the size of the map and resolution of the tiles
         */
        MAP_SIZE_X = 12;
        MAP_SIZE_Y = 12;
        TILE_SIZE = 300;

        /**
         * set up the camera
         */
        camera = new OrthographicCamera();
        camera.setToOrtho(false, MAP_SIZE_X, MAP_SIZE_Y);
        camera.update();

        /**
         * Render the tiles on to the camera
         */
        renderer = new OrthogonalTiledMapRenderer(map_TiledMap, 1/TILE_SIZE);
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
