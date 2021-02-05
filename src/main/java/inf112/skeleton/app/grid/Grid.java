package inf112.skeleton.app.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<T> implements IGrid<T>, Iterable<T> {
    protected List<T> cells;
    protected int height;
    protected int width;

    public Grid(int height, int width, T Element) {

        if(width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Error: the higth and width cant be below 0");
        }

        this.height = height;
        this.width = width;
        cells = new ArrayList<>(height*width);
        for (int i = 0; i < height*width; i++) {
            cells.add(Element);
        }

    }


    @Override
    public void set(int x, int y, T element) {
        if(y < 0 || y >= height)
            throw new IndexOutOfBoundsException("Error: The X coordinate has to be inside the gameboard!");
        if(x < 0 || x >= width)
            throw new IndexOutOfBoundsException("Error: The X coordinate has to be inside the gameboard!");

        cells.set(coordinateToIndex(x, y), element);
    }

    @Override
    public T get(int x, int y) {
        if(y < 0 || y >= height)
            throw new IndexOutOfBoundsException("Error: The X coordinate has to be inside the gameboard!");
        if(x < 0 || x >= width)
            throw new IndexOutOfBoundsException("Error: The X coordinate has to be inside the gameboard!");

        return cells.get(coordinateToIndex(x, y));
    }

    private int coordinateToIndex(int x, int y) {
        return x + y*width;
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
    public Iterator<T> iterator() {
        return cells.iterator();
    }
}
