package ru.bespalov;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Point.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    /**
     * Test Point.
     */
    @Test
    public void whenPointOneAndTwoThenDistance() {
        Point p1 = new Point(1.0, 1.0);
		Point p2 = new Point(2.0, 2.0);
		final double result = p1.distanceTo(p2);
		assertThat(result, closeTo(1.4142d, 0.01));
    }
}