package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class RoboRally implements ApplicationListener {
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

    @Override
    public void create() {

        map_TiledMap = new TmxMapLoader().load("./assets/testMap.tmx");

        board_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Board");
        holes_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Holes");
        flags_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Flags");
        players_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Players");

        MAP_SIZE_X = 5;
        MAP_SIZE_Y = 5;
        TILE_SIZE = 300;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, MAP_SIZE_X, MAP_SIZE_Y);
        camera.update();

        renderer = new OrthogonalTiledMapRenderer(map_TiledMap, 1/TILE_SIZE);
        renderer.setView(camera);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        renderer.render();
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
