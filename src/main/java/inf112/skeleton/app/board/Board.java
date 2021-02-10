package inf112.skeleton.app.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.object.Flag;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;

public class Board {
    private ArrayList<Flag> flags;

    private TiledMap map_TiledMap;

    private TiledMapTileLayer board_MapLayer;
    public TiledMapTileLayer players_MapLayer;
    private TiledMapTileLayer flags_MapLayer;

    private int height;
    private int width;
    private int tileHeight;

    public Board(String fileName){
        map_TiledMap = new TmxMapLoader().load(fileName);

        height = (int) map_TiledMap.getProperties().get("height");
        width = (int) map_TiledMap.getProperties().get("width");
        tileHeight = (int) map_TiledMap.getProperties().get("tileheight");

        board_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Board");
        players_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Players");
        flags_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Flags");



        flags = new ArrayList<Flag>();

        initFlags(height, width);

    }

    private void initFlags(int height, int width){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                TiledMapTileLayer.Cell cell = flags_MapLayer.getCell(x, y);
                if (cell != null) {
                    switch ((int) cell.getTile().getId()) {
                        case 49:
                            flags.add(new Flag(new Vector2(x, y), 1));
                            break;
                        case 56:
                            flags.add(new Flag(new Vector2(x, y), 2));
                            break;
                        case 63:
                            flags.add(new Flag(new Vector2(x, y), 3));
                            break;
                        case 70:
                            flags.add(new Flag(new Vector2(x, y), 4));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    public TiledMap getMap(){
        return map_TiledMap;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getTileHeight(){
        return tileHeight;
    }

    public ArrayList<Flag> getFlags() {
        return flags;
    }
}
