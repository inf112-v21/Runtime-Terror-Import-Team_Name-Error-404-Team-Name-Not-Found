package inf112.skeleton.app.grid;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class GridTest {
    Random random = new Random();

    @Test
    public void constructTest1() {
        IGrid<String> grid = new Grid<>(11, 17, "S");

        // TODO: sjekk at bredde og høyde faktisk er 11 og 17
        Assert.assertEquals(11, grid.getHeight());
        Assert.assertEquals(17, grid.getWidth());
    }

    /**
     * Tests that trying to access outside of the dimensions of the grid throws
     * an IndexOutOfBoundsException.
     */
    @Test
    public void outOfBoundsTest() {
        IGrid<String> grid = new Grid<>(10, 10, "S");

        try {
            grid.set(11, 0, "S");
            Assert.fail("Should throw exception");
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            grid.set(0, 11, "S");
            Assert.fail("Should throw exception");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void setGetTest1() {
        IGrid<String> grid = new Grid<>(100, 100, "S");

        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++) {
                String cs = ""+random.nextDouble();
                grid.set(x, y, cs);
                Assert.assertEquals(cs, grid.get(x, y));
            }
    }

    @Test
    public void setGetTest2() {
        IGrid<String> grid = new Grid<>(100, 100, "S");

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                grid.set(x, y, ""+random.nextDouble());
            }
        }

        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++) {
                String cs = ""+random.nextDouble();
                grid.set(x, y, cs);
                Assert.assertEquals(cs, grid.get(x, y));
            }
    }
}