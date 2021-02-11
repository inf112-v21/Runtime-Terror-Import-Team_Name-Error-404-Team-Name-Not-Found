package inf112.skeleton.app.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

public class Robot {
    private Location location;
    private TiledMapTileLayer.Cell cellState;

    public TiledMapTileLayer.Cell playerCell_alive;
    public TiledMapTileLayer.Cell playerCell_dead;
    public TiledMapTileLayer.Cell playerCell_win;

    private Board board;

    public Robot(Location location, String fileName, Board aBoard){
        this.location = location;
        this.board = aBoard;

        Texture texture = new Texture(fileName);
        TextureRegion textureRegion = new TextureRegion();
        TextureRegion[][] textureRegions = textureRegion.split(texture,300, 300);

        playerCell_alive = new TiledMapTileLayer.Cell();
        playerCell_dead = new TiledMapTileLayer.Cell();
        playerCell_win = new TiledMapTileLayer.Cell();

        playerCell_alive.setTile(new StaticTiledMapTile(textureRegions[0][0]));
        playerCell_dead.setTile(new StaticTiledMapTile(textureRegions[0][1]));
        playerCell_win.setTile(new StaticTiledMapTile(textureRegions[0][2]));

        cellState = playerCell_alive;
    }

    public Direction getDirection() {
        return this.location.getDirection();
    }
    
    public IntVector getPosition() {
        return this.location.getPosition();
    }

    public void erase(){
        board.players_MapLayer.setCell(location.getPosition().getX(), location.getPosition().getY(), new TiledMapTileLayer.Cell());
    }

    public void draw(){
        board.players_MapLayer.setCell(location.getPosition().getX(), location.getPosition().getY(), cellState);
    }

    public static int getMaxLives(){
        return 3;
    }

    public static int getMaxHealth() {
        return 10;
    }

    public void setLocation(int x, int y){
        this.location = new Location(x,y,location.getDirection());
    }

    public boolean onBoard(int x, int y) {
        if (x >= 0 && x < board.getHeight()) {
            if(y >= 0 && y < board.getWidth()){
                System.out.println(board.getHeight());
                System.out.println(board.getWidth());
                System.out.println(x);
                System.out.println(y);
                return true;
            }
        }
        return false;
    }

    public void onWin(){
        cellState = playerCell_win;
        erase();
        draw();
    }

    public void onDeath(){
        cellState = playerCell_dead;
        erase();
        draw();
    }

    public void walk(String way){
        switch (way){
            case "up":
                if(onBoard(getPosition().getX(), getPosition().getY()+1)) {
                    erase();
                    setLocation(getPosition().getX(), getPosition().getY() + 1);
                    draw();
                }
                break;
            case "right":
                if(onBoard(getPosition().getX()+1, getPosition().getY())) {
                    erase();
                    setLocation(getPosition().getX() + 1, getPosition().getY());
                    draw();
                }
                break;
            case "left":
                if(onBoard(getPosition().getX()-1, getPosition().getY())) {
                    erase();
                    setLocation(getPosition().getX() - 1, getPosition().getY());
                    draw();
                }
                break;
            case "down":
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
