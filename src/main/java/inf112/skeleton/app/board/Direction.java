package inf112.skeleton.app.board;

import java.util.List;
import java.util.Arrays;

/**
 * Direction to know what way items and players/ robots is looking
 *
 */
public enum Direction {
    NORTH(0, 0, -1, 1), EAST(90, 1, 0, 4 ),
    SOUTH(180, -1, 0, 2), WEST(270, 0, 1, 8);


    private final double degrees;
    private final int dx;
    private final int dy;
    private final int mask;

    public static final List<Direction> DIRECTIONS = Arrays.asList(NORTH,EAST,SOUTH,WEST);


    Direction(double degrees, int dx, int dy, int mask) {
        this.degrees = degrees;
        this.dx = dx;
        this.dy = dy;
        this.mask = mask;
    }

    public double getDegrees() {
        return degrees;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getMask(){
        return mask;
    }
}
