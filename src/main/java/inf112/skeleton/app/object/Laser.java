package inf112.skeleton.app.object;

import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.IntVector;
import inf112.skeleton.app.board.Location;

public class Laser {
    private final Location location;
    private final LaserType laserType;

    public Laser(Location pos, LaserType type) {
        this.location = pos;
        laserType = type;
    }

    public IntVector getPosition() {
        return location.getPosition();
    }

    public Direction getDirection() {
        return location.getDirection();
    }

    public LaserType getLaserType() {
        return laserType;
    }
}
