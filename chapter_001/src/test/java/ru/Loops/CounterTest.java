package ru.bespalov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Counter of range.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    /**
     * Test Counter.
     */
    @Test
    public void whenStartIsOneAndFinoshIsTenThenThirty() {
        Counter count = new Counter();
		final int result = count.add(1, 10);
		assertThat(result, is(30));
    }
}