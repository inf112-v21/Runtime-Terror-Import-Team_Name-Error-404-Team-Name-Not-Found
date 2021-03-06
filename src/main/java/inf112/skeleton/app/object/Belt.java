package inf112.skeleton.app.object;

import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

/**
 * a class for the object belt
 */
public class Belt {
    private final Location location;


    public Belt(Location pos) {
        this.location = pos;
    }

    public IntVector getPosition() {
        return this.location.getPosition();
    }
    public Direction getDirection() { return this.location.getDirection(); }
}
