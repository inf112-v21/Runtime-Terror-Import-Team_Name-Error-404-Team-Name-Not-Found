package inf112.skeleton.app.object;

import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

public class Wall {
    private Location location;


    public Wall(Location pos) {
        this.location = pos;
    }

    public IntVector getPosition() {
        return this.location.getPosition();
    }
}

