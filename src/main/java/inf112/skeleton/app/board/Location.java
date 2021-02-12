package inf112.skeleton.app.board;

/**
 * location of a object that shows what way its facing and where it is
 */
public class Location {
    private IntVector position;
    private Direction direction;

    public Location(IntVector pos, Direction dir){
        this.position = pos;
        this.direction = dir;
    }

    public Location (int x, int y, Direction dir) {
        this(new IntVector(x,y), dir);
    }

    /**
     * @return return a object position on the board
     */
    public IntVector getPosition() {
        return position;
    }

    /**
     * @return return the direction a objet is facing
     */
    public Direction getDirection() {
        return direction;
    }
}
