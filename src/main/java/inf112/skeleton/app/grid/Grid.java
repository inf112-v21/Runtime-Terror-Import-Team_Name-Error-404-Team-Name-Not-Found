package inf112.skeleton.app.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<T> implements IGrid<T>, Iterable<T> {
    private final List<T> cells;
    private final IBoard board;

    public Grid(IBoard board, T initElement) {
        if (board == null) {
            throw new IllegalArgumentException();
        }

        this.board = board;
        this.cells = new ArrayList<T>(board.getSize());
        for (int i = 0; i < board.getSize(); ++i) {
            cells.add(initElement);
        }
    }

    public Grid(int height, int width, T Element) {
        this(new Board(width, height), Element);
    }

    @Override
    public void set(int x, int y, T element) {
        cells.set(board.to1DCord(x, y), element);
    }

    @Override
    public T get(int x, int y) {
        return cells.get(board.to1DCord(x, y));
    }

    @Override
    public int getHeight() {
        return board.getWidth();
    }

    @Override
    public int getWidth() {
        return board.getWidth();
    }

    public IBoard getBoard() {return board;}

    @Override
    public boolean isValid(int x, int y) {
        return board.inBoard(x, y);
    }

    @Override
    public Iterator<T> iterator() {
        return cells.iterator();
    }
}
