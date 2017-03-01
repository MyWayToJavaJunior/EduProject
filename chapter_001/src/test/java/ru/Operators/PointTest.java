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
public class Max2Test {
    /**
     * Test Point.
     */
    @Test
    public void whenPointOneAndTwoThenDistance() {
        Point p1 = Point(1, 1);
		Point p2 = Point(2, 2);
		final double result = p1.distanceTo(p2);
		assertThat(result, closeTo(1.4142d, 0.01));
    }
}