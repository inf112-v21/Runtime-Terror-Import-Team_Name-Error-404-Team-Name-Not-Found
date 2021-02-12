package inf112.skeleton.app.board;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import inf112.skeleton.app.object.Flag;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.skeleton.app.object.Hole;
import inf112.skeleton.app.object.Robot;

import java.util.ArrayList;

public class Board {
    public ArrayList<Flag> flags;
    public ArrayList<Hole> holes;

    public TiledMap map_TiledMap;

    private TiledMapTileLayer board_MapLayer;
    public TiledMapTileLayer players_MapLayer;
    private TiledMapTileLayer flags_MapLayer;
    private TiledMapTileLayer holes_MapLayer;

    private int height;
    private int width;
    private int tileHeight;

    /**
     * construct a game board form the map that is inputted with a filename
     *
     * @param fileName a map file
     */
    public Board(String fileName){
        map_TiledMap = new TmxMapLoader().load(fileName);

        height = (int) map_TiledMap.getProperties().get("height");
        width = (int) map_TiledMap.getProperties().get("width");
        tileHeight = (int) map_TiledMap.getProperties().get("tileheight");

        board_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Board");
        players_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Players");
        flags_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Flags");
        holes_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Holes");



        flags = new ArrayList<Flag>();
        holes = new ArrayList<Hole>();

        initFlags();
        initHoles();
    }


    /**
     * for tests
     */
    public Board(int width, int height) {
        map_TiledMap = new TiledMap();
        map_TiledMap.getProperties().put("width", width);
        map_TiledMap.getProperties().put("height", height);
        MapLayers layers = map_TiledMap.getLayers();

        int tileSize = 300;
        TiledMapTileLayer playerLayer = new TiledMapTileLayer(width, height, tileSize, tileSize);
        playerLayer.setName("Players");
        layers.add(playerLayer);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                playerLayer.setCell(i, j, new TiledMapTileLayer.Cell());
                TiledMapTile tile = new StaticTiledMapTile(new TextureRegion());
                tile.getProperties().put("type", "Players");
                getTileLayer().getCell(i, j).setTile(tile);
            }
        }

        this.height = height;
        this.width = width;

        flags = new ArrayList<Flag>();
        holes = new ArrayList<Hole>();

        this.players_MapLayer = (TiledMapTileLayer) map_TiledMap.getLayers().get("Players");

    }

    /**
     * check the entire map for all the flags and adds them to a list of flags
     *
     */
    private void initFlags(){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                TiledMapTileLayer.Cell cell = flags_MapLayer.getCell(x, y);
                if (cell != null) {
                    switch ((int) cell.getTile().getId()) {
                        case 49:
                            flags.add(new Flag(new Location(x, y, Direction.NORTH), 1));
                            break;
                        case 56:
                            flags.add(new Flag(new Location(x, y, Direction.NORTH), 2));
                            break;
                        case 63:
                            flags.add(new Flag(new Location(x, y, Direction.NORTH), 3));
                            break;
                        case 70:
                            flags.add(new Flag(new Location(x, y, Direction.NORTH), 4));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    /**
     * check all the holes on the hole layer and adds them to the hole list.
     */
    private void initHoles() {
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                TiledMapTileLayer.Cell cell = holes_MapLayer.getCell(x, y);
                if (cell != null) {
                    if ((int) cell.getTile().getId() == 6) {
                        holes.add(new Hole(new Location(x, y, Direction.NORTH)));
                    }
                }
            }
        }
    }

    /**
     * check if the input (x,y) position mach with the wining flag
     *
     * @param robot the players robot
     * @return return true if matching otherwise false
     */
    public boolean checkWin(Robot robot){
        IntVector pos = robot.getPosition();
        for (Flag flag : flags) {
            if (flag.getPosition().getX() == pos.getX() && flag.getPosition().getY() == pos.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * check if the input (x,y) position mach with the hole
     *
     * @param robot the players robot
     * @return return true if matching otherwise false
     */
    public boolean checkHole(Robot robot) {
        IntVector pos = robot.getPosition();

        for (Hole hole : holes) {
            if (hole.getPosition().getX() == pos.getX() && hole.getPosition().getY() == pos.getY()) {
                return true;
            }
        }
        return false;
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

    public TiledMapTileLayer getTileLayer() {
        return (TiledMapTileLayer) map_TiledMap.getLayers().get("Players");
    }

    public ArrayList<Flag> getFlags() {
        return flags;
    }
}
