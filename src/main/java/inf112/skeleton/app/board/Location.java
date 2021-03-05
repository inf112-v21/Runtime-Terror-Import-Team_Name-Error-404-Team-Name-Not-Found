package inf112.skeleton.app.board;

import java.util.Objects;

/**
 * location of a object that shows what way its facing and where it is
 */
public class Location {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return position.equals(location.position) && direction == location.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

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
