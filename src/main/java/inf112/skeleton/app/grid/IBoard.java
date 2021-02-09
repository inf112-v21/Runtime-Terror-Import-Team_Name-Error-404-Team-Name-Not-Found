package inf112.skeleton.app.grid;

import java.util.List;

public interface IBoard extends Iterable<ILocation> {

    /**
     * Check if the pos (x,y) is inside the board.
     *
     * @param x
     * @param y
     * @return
     */
    boolean inBoard(int x,int y);

    /**
     *@return Height of the board
     */
    int getHeight();

    /**
     * @return Width of the board
     */
    int getWidth();

    /**
     * Get a location object to (x,y)
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     * @return The location object (x,y)
     */
    ILocation location(int x, int y);

    /**
     * Get all locations on the board
     * @return list with all the locations on the board
     */
    List<ILocation> locations();
}
