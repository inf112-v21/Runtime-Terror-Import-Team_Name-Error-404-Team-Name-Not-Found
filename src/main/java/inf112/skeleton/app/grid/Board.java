package inf112.skeleton.app.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Board implements IBoard {

    protected final int width;
    protected final int height;
    protected final List<ILocation> locsList;
    protected final int size;
    protected final boolean horizWrap;
    protected final boolean vertWrap;

    public Board(int width, int height) {
        this(width, height, false, false);
    }

    private Board(int width, int height, boolean horizWrap, boolean vertWrap) {
        if (width < 1 || height <1) {
            throw new IllegalArgumentException("Width and height must be grater then 1");
        }
        this.width = width;
        this.height = height;
        this.horizWrap = horizWrap;
        this.vertWrap = vertWrap;
        this.size = width * height;
        List<ILocation> loc = new ArrayList<>(size);
        for (int y = 0, z = 0; y < height; y++) {
            int edge = (y == 0 ? Direction.NORTH.getMask() : 0)
                    | (y == height - 1 ? Direction.SOUTH.getMask() : 0);
            for (int x = 0; x < width; x++, z++) {
                int e = edge | (x == 0 ? Direction.WEST.getMask() : 0)
                        | (x == width - 1 ? Direction.EAST.getMask() : 0);
                loc.add(new Location(x,y,z,e));
            }
        }
        locsList = Collections.unmodifiableList(loc);

    }

    @Override
    public boolean inBoard(int x, int y) {
        y = yWrap(y);
        x = xWrap(x);

        return y >= 0 && y < height && x >= 0 && x < width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public ILocation location(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            throw new IndexOutOfBoundsException("(" + x + "," + y + ")");
        int i = x + y * width;
        return locsList.get(i);
    }

    @Override
    public List<ILocation> locations() {
        return locsList;
    }

    @Override
    public ILocation from1DCord(int i) {
        if (i >= 0 && i < size)
            return locsList.get(i);
        else
            throw new IndexOutOfBoundsException(i+ "is not on the board");
    }

    @Override
    public int to1DCord(int x, int y) {

        return y * width + x;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<ILocation> iterator() {
        return locsList.iterator();
    }

    protected int xWrap(int x) {
        if (vertWrap) {
            if (x < 0) {
                return getWidth() + x % getWidth();
            } else {
                return x % getWidth();
            }
        } else {
            return x;
        }
    }

    protected int yWrap(int y) {
        if (horizWrap) {
            if (y < 0) {
                return getHeight() + y % getHeight();
            } else {
                return y % getHeight();
            }
        } else {
            return y;
        }
    }

    protected int xCheck(int x) {
        x = xWrap(x);
        if (x < 0 || x >= width) {
            throw new IndexOutOfBoundsException("x=" + x);
        }

        return x;
    }

    protected int yCheck(int y) {
        y = yWrap(y);
        if (y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("y=" + y);
        }
        return y;
    }
}
