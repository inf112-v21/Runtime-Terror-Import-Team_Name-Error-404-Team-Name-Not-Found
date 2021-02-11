package inf112.skeleton.app.board;

import com.badlogic.gdx.math.Vector2;

public class Location {
    private final IntVector position;
    private final Direction direction;

    public Location(IntVector pos, Direction dir){
        this.position = pos;
        this.direction = dir;
    }

    public Location (int x, int y, Direction dir) {
        this(new IntVector(x,y), dir);
    }

    public IntVector getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
