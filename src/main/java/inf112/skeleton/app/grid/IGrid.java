package inf112.skeleton.app.grid;

/**
 * IGrid is a generic gid system used for the backend and frontend
 *
 */
public interface IGrid<T>{

    /**
     *
     * Set the contents of the cell in the given x,y location.
     *
     * y must be 0 or higher but less or the same as the map height (getHeight()).
     * x must be 0 or higher but less or the same as the map width (getWidth()).
     *
     * @param x The x coordinate of the cell to change the contents of.
     * @param y The y coordinate of the cell to change the contents of.
     * @param element The contents that should be set in the cell.
     */
    void set(int x, int y, T element);

    /**
     *
     * Get the contents of the cell in the given x,y location.
     *
     * y must be 0 or higher but less or the same as the map height (getHeight()).
     * x must be 0 or higher but less or the same as the map width (getWidth()).
     *
     * @param x The x coordinate of the cell to get the contents of.
     * @param y The y coordinate of the cell to get the contents of.
     */
    T get(int x, int y);

    /**
     * @return The height of the grid.
     */
    int getHeight();

    /**
     * @return The width of the grid.
     */
    int getWidth();

    /**
     * Check if coordinates are valid.
     *
     * Valid coordinates are 0 <= x < getWidth(), 0 <= y < getHeight().
     *
     * @param x an x coordinate
     * @param y an y coordinate
     * @return true if the (x,y) position is within the grid
     */
    boolean isValid(int x, int y);

}
