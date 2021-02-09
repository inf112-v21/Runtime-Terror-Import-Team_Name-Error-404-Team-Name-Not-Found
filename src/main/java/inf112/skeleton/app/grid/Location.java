package inf112.skeleton.app.grid;

import java.util.ArrayList;
import java.util.Collection;

public class Location implements ILocation{

    protected final int x;
    protected final int y;
    protected final int idx;

    public Location(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }




    @Override
    public boolean canGo(Direction dir) {
        return false;
    }

    @Override
    public ILocation go(Direction dir) {
        return null;
    }

    @Override
    public Collection<ILocation> Neighbours() {
        Collection<ILocation> nighbours = new ArrayList<>(4);
        for (Direction dir : Direction.DIRECTIONS){
            if (canGo(dir)) {
                nighbours.add(go(dir));
            }
        }
        return nighbours;
    }
}
