package ru.operators;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Area of treangle test.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**
     * Test area.
     */
    @Test
    public void whenAreaIsCalcThenTwo() {
        Point p1 = new Point(1, 1);
		Point p2 = new Point(3, 1);
		Point p3 = new Point(2, 3);
		Triangle triangle = new Triangle(p1, p2, p3);
		final double result = triangle.area();
		assertThat(result, closeTo(1.9992d, 0.01));
    }

	    /**
     * Test area.
     */
    @Test
    public void whenAreaIsNotCalcThenMinusOne() {
        Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 2);
		Point p3 = new Point(1, 3);
		Triangle triangle = new Triangle(p1, p2, p3);
		final double result = triangle.area();
		assertThat(result, closeTo(-1d, 0.01));
    }
}