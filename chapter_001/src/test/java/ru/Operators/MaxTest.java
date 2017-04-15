package ru.operators;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Max of 2 numbers.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    /**
     * Test Max 2.
     */
    @Test
    public void whenMaxOneAndTwoThenTwo() {
        Max max = new Max();
		final int result = max.max(1, 2);
		assertThat(result, is(2));
    }

	/**
     * Test Max 3.
     */
    @Test
    public void whenMaxOneAndTwoAndThreeThenTree() {
        Max max = new Max();
		final int result = max.max(1, 2, 3);
		assertThat(result, is(3));
    }
}