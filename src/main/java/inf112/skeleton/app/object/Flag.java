package inf112.skeleton.app.object;

import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

public class Flag {
    private Location location;
    private int nr;

    public Flag(Location pos, int flagNr) {
        this.location = pos;
        this.nr = flagNr;
    }

    public IntVector getPosition() {
        return this.location.getPosition();
    }

}