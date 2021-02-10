package inf112.skeleton.app.object;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.board.Direction;

public class Robot {
    private Vector2 position;
    private Direction direction;

    public Robot(Vector2 pos, Direction dir){
        this.position = pos;
        this.direction = dir;
    }

    public Direction getDirection() {
        return this.direction;
    }
    
    public Vector2 getPosition() {
        return this.position;
    }




}
