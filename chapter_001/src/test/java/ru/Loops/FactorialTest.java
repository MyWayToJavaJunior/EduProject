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
public class FactorialTest {
    /**
     * Test Factorial.
     */
    @Test
    public void whenNumIsFiveThenOneHundredAndTwenty() {
        Factorial f = new Factorial();
		final int result = f.fac(5);
		assertThat(result, is(120));
    }
}