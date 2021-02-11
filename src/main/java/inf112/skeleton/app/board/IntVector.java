package inf112.skeleton.app.board;

import com.badlogic.gdx.math.Vector2;

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

}
