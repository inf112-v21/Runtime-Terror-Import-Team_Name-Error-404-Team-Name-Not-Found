package inf112.skeleton.app;

public enum Cards {
    TURN_AROUND,
    ROTATE_LEFT,
    ROTATE_RIGHT,
    MOVE_FORWARDS_ONE,
    MOVE_FORWARDS_TWO,
    MOVE_FORWARDS_THREE,
    MOVE_BACKWARDS;

    @Override
    public String toString() {
        return super.toString().replace("_"," ");
    }
}
