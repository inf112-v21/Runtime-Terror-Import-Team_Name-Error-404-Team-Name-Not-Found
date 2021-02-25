package inf112.skeleton.app.object;

import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

/**
 * a class for the object hole
 */
public class Hole {
    private final Location location;


    public Hole(Location pos) {
        this.location = pos;
    }

    public IntVector getPosition() {
        return this.location.getPosition();
    }
}
