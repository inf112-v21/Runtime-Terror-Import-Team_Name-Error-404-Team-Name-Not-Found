package inf112.skeleton.app.grid;

import java.util.Collection;

public interface ILocation {


    /**
     * Checks if you can go in an direction
     *
     * @param dir
     * @return True if you can go in dir or False if not
     */
    boolean canGo(Direction dir);

    /**
     * Return the next location in direction dir
     *
     * @param dir
     * @return a neighbouring location
     */
    ILocation go(Direction dir);

    /**
     * Iterate over neighbours
     * @return The neighbours tiles
     */
    Collection<ILocation> Neighbours();

}
