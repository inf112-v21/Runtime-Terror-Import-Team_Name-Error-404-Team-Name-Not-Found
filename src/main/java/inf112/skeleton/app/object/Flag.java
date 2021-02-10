package inf112.skeleton.app.object;

import com.badlogic.gdx.math.Vector2;

public class Flag {
    private Vector2 position;
    private int nr;

    public Flag(Vector2 pos, int flagNr) {
        position = pos;
        nr = flagNr;
    }
}
