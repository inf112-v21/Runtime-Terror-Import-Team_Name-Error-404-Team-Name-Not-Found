package inf112.skeleton.app.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;

public class Robot {
    private Vector2 position;
    private Direction direction;
    private TiledMapTileLayer.Cell cellState;


    public TiledMapTileLayer.Cell playerCell_alive;
    public TiledMapTileLayer.Cell playerCell_dead;
    public TiledMapTileLayer.Cell playerCell_win;

    private Board board;

    public Robot(Vector2 pos, Direction dir, String fileName, Board aBoard){
        this.position = pos;
        this.direction = dir;
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
        return this.direction;
    }
    
    public Vector2 getPosition() {
        return this.position;
    }

    public void erase(){
        board.players_MapLayer.setCell((int) position.x, (int) position.y, new TiledMapTileLayer.Cell());
    }

    public void draw(){
        board.players_MapLayer.setCell((int) position.x, (int) position.y, cellState);
    }

    public void walk(int amount){
        erase();
        position.add(1,0);
        draw();
    }




}
