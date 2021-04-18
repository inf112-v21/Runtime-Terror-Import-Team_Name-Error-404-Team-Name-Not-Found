package inf112.skeleton.app.board;

import java.util.List;
import java.util.Arrays;

/**
 * Direction to know what way items and players/ robots is looking
 *
 */
public enum Direction {
    NORTH(0), EAST(90),
    SOUTH(180), WEST(270);


    private final int degrees;

    public static final List<Direction> DIRECTIONS = Arrays.asList(NORTH,EAST,SOUTH,WEST);


    Direction(int degrees) {
        this.degrees = degrees;
    }

    public int getDegrees() {
        return degrees;
    }
}
