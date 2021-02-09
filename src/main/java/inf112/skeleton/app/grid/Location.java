package inf112.skeleton.app.grid;

import java.util.ArrayList;
import java.util.Collection;

public class Location implements ILocation{

    Board b;

    protected final int x;
    protected final int y;
    protected final int idx;
    protected final int edge;

    public Location(int x, int y, int idx, int edgeMask) {
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.edge = edgeMask;
    }

    @Override
    public boolean canGo(Direction dir) {
        return (edge & dir.getMask()) == 0;
    }

    @Override
    public ILocation go(Direction dir) {
        return b.location(x + dir.getDx(), y + dir.getDy());
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
