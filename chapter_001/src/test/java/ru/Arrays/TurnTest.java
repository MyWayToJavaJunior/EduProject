package ru.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Turn Array.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {
    /**
     * Test turn array.
     */
    @Test
    public void whenArrayLengthIsThreeThenTurn() {
		int[] expect = new int[] {3, 2, 1};
		int[] result = new int[] {1, 2, 3};
		Turn t = new Turn();
		t.back(result);
		assertThat(result, is(expect));
    }
}