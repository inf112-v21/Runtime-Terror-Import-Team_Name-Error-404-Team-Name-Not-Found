package inf112.skeleton.app.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

/*
 * a class for the object Robot
 */
public class Robot {
    private Location location;
    private TiledMapTileLayer.Cell cellState;

    public TiledMapTileLayer.Cell playerCell_alive;
    public TiledMapTileLayer.Cell playerCell_dead;
    public TiledMapTileLayer.Cell playerCell_win;

    private Board board;

    /*
     * a constructor for the robot object
     *
     * @param location the location of a robot
     * @param fileName image of the robot
     * @param aBoard  the board
     */
    public Robot(Location location, String fileName, Board aBoard){
        this.location = location;
        this.board = aBoard;

        TextureRegion[][] textureRegions = getRobotTexture(fileName);

        playerCell_alive = new TiledMapTileLayer.Cell();
        playerCell_dead = new TiledMapTileLayer.Cell();
        playerCell_win = new TiledMapTileLayer.Cell();

        playerCell_alive.setTile(new StaticTiledMapTile(textureRegions[0][0]));
        playerCell_dead.setTile(new StaticTiledMapTile(textureRegions[0][1]));
        playerCell_win.setTile(new StaticTiledMapTile(textureRegions[0][2]));

        cellState = playerCell_alive;
    }

    /**
     * Loads the Robot texture and return a textured region of the loaded texture
     *
     * @param fileName filepath of the texture to be loaded
     * @return TextureRegion[][] The texture split in 300X300 pixels
     */
    private TextureRegion[][] getRobotTexture(String fileName) {
        Texture texture = new Texture(fileName);
        TextureRegion textureRegion = new TextureRegion();
        TextureRegion[][] textureRegions = textureRegion.split(texture,300, 300);
        return textureRegions;
    }

    /**
     * construct a robot with a empty map
     * used for tests and development
     *
     * @param location - an location
     * @param aBoard - a board
     */
    public Robot(Location location, Board aBoard) {
        this.location = location;
        this.board = aBoard;

        playerCell_alive = new TiledMapTileLayer.Cell();
        playerCell_dead = new TiledMapTileLayer.Cell();
        playerCell_win = new TiledMapTileLayer.Cell();

        cellState = playerCell_alive;
    }

    /**
     * @return direction the robot is facing
     */
    public Direction getDirection() {
        return this.location.getDirection();
    }

    /**
     * @return robots position
     */
    public IntVector getPosition() {
        return this.location.getPosition();
    }

    /*
     * removes the robot form the game board
     */
    public void erase(){
        board.players_MapLayer.setCell(location.getPosition().getX(), location.getPosition().getY(), new TiledMapTileLayer.Cell());
    }

    /*
     * draws the robot on the game board
     */
    public void draw(){
        board.players_MapLayer.setCell(location.getPosition().getX(), location.getPosition().getY(), cellState);
    }

    /**
     * @return the max lives a robot can have
     */
    public static int getMaxLives(){
        return 3;
    }

    /**
     * @return the max health a robot can have
     */
    public static int getMaxHealth() {
        return 10;
    }

    /**
     * set the location of a robot to a (x,y) position
     *
     * @param x x - coordinate
     * @param y y - coordinate
     */
    public void setLocation(int x, int y){
        this.location = new Location(x,y,location.getDirection());
    }

    /**
     * check if the given (x,y) posision is on the board
     *
     * @param x - x coordinate
     * @param y - Y coordinate
     * @return false if outside the board
     */
    public boolean onBoard(int x, int y) {
        if (x >= 0 && x < board.getHeight()) {
            return y >= 0 && y < board.getWidth();
        }
        return false;
    }

    /*
     * change the texture of the robot when it has won the game
     *
     */
    public void onWin(){
        cellState = playerCell_win;
        erase();
        draw();
    }

    /*
     * change the texture of the robot when the robot has died
     *
     */
    public void onDeath(){
        cellState = playerCell_dead;
        erase();
        draw();
    }

    /**
     * moves the robot to 1 tile in 4 directions up, down, left and right
     *
     * @param way they way you want it to move
     */
    public void walk(String way){
        switch (way){
            case "north":
                if(onBoard(getPosition().getX(), getPosition().getY()+1)) {
                    erase();
                    setLocation(getPosition().getX(), getPosition().getY() + 1);
                    draw();
                }
                break;
            case "east":
                if(onBoard(getPosition().getX()+1, getPosition().getY())) {
                    erase();
                    setLocation(getPosition().getX() + 1, getPosition().getY());
                    draw();
                }
                break;
            case "west":
                if(onBoard(getPosition().getX()-1, getPosition().getY())) {
                    erase();
                    setLocation(getPosition().getX() - 1, getPosition().getY());
                    draw();
                }
                break;
            case "south":
                if(onBoard(getPosition().getX(), getPosition().getY()-1)) {
                    erase();
                    setLocation(getPosition().getX(), getPosition().getY() - 1);
                    draw();
                }
                break;
            default:
                break;
        }
    }






}
