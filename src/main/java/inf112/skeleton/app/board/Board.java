package inf112.skeleton.app.board;

import inf112.skeleton.app.object.Flag;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.skeleton.app.object.Hole;

import java.util.ArrayList;

public class Board {
    private ArrayList<Flag> flags;
    private ArrayList<Hole> holes;

    private TiledMap map_TiledMap;

    private TiledMapTileLayer board_MapLayer;
    public TiledMapTileLayer players_MapLayer;
    private TiledMapTileLayer flags_MapLayer;
    private TiledMapTileLayer holes_MapLayer;

    private int height;
    private int width;
    private int tileHeight;
    private int numberofflags;

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

        int numberofflags = flags.size();

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
     * @param x x - coordinate
     * @param y y - coordinate
     * @return return true if matching otherwise false
     */
    public boolean checkWin(int x, int y){
        for (Flag flag : flags) {
            if (flag.getPosition().getX() == x && flag.getPosition().getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * check if the input (x,y) position mach with the hole
     *
     * @param x x - coordinate
     * @param y y - coordinate
     * @return return true if matching otherwise false
     */
    public boolean checkHole(int x, int y) {
        for (Hole hole : holes) {
            if (hole.getPosition().getX() == x && hole.getPosition().getY() == y) {
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

    public ArrayList<Flag> getFlags() {
        return flags;
    }
}
