package inf112.skeleton.app.board;

import com.badlogic.gdx.math.Vector2;

import java.util.Objects;

/**
 * changes Vector2 float vectors into int vectors for easier use
 */
public class IntVector {
    private Vector2 vector;

    public IntVector(Vector2 vector){
        this.vector = vector;
    }

    public IntVector(int x, int y){
        this(new Vector2(x, y));
    }

    public int getX() {
        return (int) vector.x;
    }

    public int getY() {
        return (int) vector.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntVector intVector = (IntVector) o;
        return Objects.equals(vector, intVector.vector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }
}
