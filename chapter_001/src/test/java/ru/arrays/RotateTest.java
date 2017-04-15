package ru.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Rotate Array.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class RotateTest {
    /**
     * Test rotate array.
     */
    @Test
    public void whenArrayLengthIsThreeThenRotate() {
		int[][] expect = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		int[][] result = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Rotate r = new Rotate();
		r.rotate(result);
		assertThat(result, is(expect));
    }
}