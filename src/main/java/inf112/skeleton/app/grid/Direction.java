package inf112.skeleton.app.grid;

import java.util.List;
import java.util.Arrays;

public enum Direction {
    NORTH(0, 0, -1), EAST(90, 1, 0 ), SOUTH(180, -1, 0), WEST(270, 0, 1);


    private final double degrees;
    private final int dx;
    private final int dy;

    public static final List<Direction> DIRECTIONS = Arrays.asList(NORTH,EAST,SOUTH,WEST);


    Direction(double degrees, int dx, int dy) {
        this.degrees = degrees;
        this.dx = dx;
        this.dy = dy;
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
}
