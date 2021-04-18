package inf112.skeleton.app.object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

import java.util.ArrayList;
import java.util.Objects;

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
  
    /**
     * a constructor for the robot object
     *
     * @param location the location of a robot
     * @param aBoard   the board
     */
    public Robot(Location location, Board aBoard) {
        this.location = location;
        this.board = aBoard;
    }

    /**
     * Loads the Robot texture and return a textured region of the loaded texture
     *
     * @param fileName filepath of the texture to be loaded
     */
    public void setRobotTexture(String fileName) {
        Texture texture = new Texture(fileName);
        TextureRegion textureRegion = new TextureRegion();
        TextureRegion[][] textureRegions = textureRegion.split(texture, 300, 300);
        playerCell_alive = new TiledMapTileLayer.Cell();
        playerCell_dead = new TiledMapTileLayer.Cell();
        playerCell_win = new TiledMapTileLayer.Cell();

        playerCell_alive.setTile(new StaticTiledMapTile(textureRegions[0][0]));
        playerCell_dead.setTile(new StaticTiledMapTile(textureRegions[0][1]));
        playerCell_win.setTile(new StaticTiledMapTile(textureRegions[0][2]));

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
    public void erase() {
        board.players_MapLayer.setCell(location.getPosition().getX(), location.getPosition().getY(), new TiledMapTileLayer.Cell());
    }

    /*
     * draws the robot on the game board
     */
    public void draw() {
        board.players_MapLayer.setCell(location.getPosition().getX(), location.getPosition().getY(), cellState);
    }

    /**
     * @return the max lives a robot can have
     */
    public static int getMaxLives() {
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
    public void setLocation(int x, int y) {
        this.location = new Location(x, y, location.getDirection());
    }

    public void setDirection(Direction direction){
        this.location = new Location(location.getPosition(), direction);
    }


    /*
     * change the texture of the robot when it has won the game
     *
     */
    public void onWin() {
        cellState = playerCell_win;
        erase();
        draw();
    }

    /*
     * change the texture of the robot when the robot has died
     *
     */
    public void onDeath() {
        cellState = playerCell_dead;
        erase();
        draw();
    }

    /**
     * moves the robot to 1 tile in 4 directions up, down, left and right and check for belts
     *
     * @param way they way you want it to move
     */
    public void walk(Direction way) {
        Wall wall = board.checkWall(this.getPosition());
        switch (way) {
            case NORTH:
                Wall nextNorth = board.checkWall(new IntVector(getPosition().getX(), getPosition().getY() +1));
                if (wall == null || wall.getDirection() != Direction.NORTH) {
                    if(nextNorth == null || nextNorth.getDirection() != Direction.SOUTH) {
                        if (board.onBoard(getPosition().getX(), getPosition().getY() + 1)) {
                            erase();
                            setLocation(getPosition().getX(), getPosition().getY() + 1);
                            draw();
                            IntVector pos = this.getPosition();
                            board.checkBelts(this);
                            if (pos == getPosition()) {
                                board.checkExpressBelts(this);
                            }
                        }
                    }
                }

                break;
            case EAST:
                Wall nextEast = board.checkWall(new IntVector(getPosition().getX()+1, getPosition().getY()));
                if (wall == null || wall.getDirection() != Direction.EAST) {
                    if(nextEast == null || nextEast.getDirection() != Direction.WEST) {
                        if (board.onBoard(getPosition().getX() + 1, getPosition().getY())) {
                            erase();
                            setLocation(getPosition().getX() + 1, getPosition().getY());
                            draw();
                            IntVector pos = this.getPosition();
                            board.checkBelts(this);
                            if (pos == getPosition()) {
                                board.checkExpressBelts(this);
                            }
                        }
                    }
                }

                break;
            case WEST:
                Wall nextWest = board.checkWall(new IntVector(getPosition().getX()-1, getPosition().getY()));
                if (wall == null || wall.getDirection() != Direction.WEST){
                    if (nextWest == null || nextWest.getDirection() != Direction.EAST) {
                        if (board.onBoard(getPosition().getX() - 1, getPosition().getY())) {
                            erase();
                            setLocation(getPosition().getX() - 1, getPosition().getY());
                            draw();
                            IntVector pos = this.getPosition();
                            board.checkBelts(this);
                            if (pos == getPosition()) {
                                board.checkExpressBelts(this);
                            }
                        }
                    }

                }

                break;
            case SOUTH:
                Wall nextSouth = board.checkWall(new IntVector(getPosition().getX(), getPosition().getY() -1));
                if (wall == null || wall.getDirection() != Direction.SOUTH) {
                    if (nextSouth== null || nextSouth.getDirection() != Direction.NORTH) {
                        if (board.onBoard(getPosition().getX(), getPosition().getY() - 1)) {
                            erase();
                            setLocation(getPosition().getX(), getPosition().getY() - 1);
                            draw();
                            IntVector pos = this.getPosition();
                            board.checkBelts(this);
                            if (pos == getPosition()) {
                                board.checkExpressBelts(this);
                            }
                        }
                    }

                }
                break;
            default:
                break;
        }
    }

    public void UseCards(Card card){
        CardType type = card.getCardType();
        switch (type){
            case MOVE_FORWARDS_THREE:
                for (int i = 0; i < 3; i++) {
                    walk(getDirection());
                }
                break;
            case MOVE_FORWARDS_TWO:
                for (int i = 0; i < 2; i++) {
                    walk(getDirection());
                }
                break;
            case MOVE_FORWARDS_ONE:
                walk(getDirection());
                break;
            case MOVE_BACKWARDS:
                walk(giveDirection(getDirection().getDegrees()+180));
                break;
            case ROTATE_LEFT:
                setDirection(giveDirection(getDirection().getDegrees()+270));
                break;
            case ROTATE_RIGHT:
                setDirection(giveDirection(getDirection().getDegrees()+90));
                break;
            case TURN_AROUND:
                setDirection(giveDirection(getDirection().getDegrees()+180));
                break;
            default:
                break;
        }
    }

    public Direction giveDirection(int degrees){
        switch (degrees){
            case 360:
            case 0:
                return Direction.NORTH;
            case 540:
            case 180:
                return Direction.SOUTH;
            case 450:
            case 90:
                return Direction.EAST;
            case 630:
            case 270:
                return Direction.WEST;
            default:
                break;
        }
        return null;
    }


}
