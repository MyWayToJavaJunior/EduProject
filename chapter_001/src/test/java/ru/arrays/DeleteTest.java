package ru.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Delete duplicates Array.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class DeleteTest {
    /**
     * Test delete duplicates array.
     */
    @Test
    public void whenArrayLengthIsSixThenDelete() {
		String[] expect = new String[] {"Hello", "world", "qwe"};
		String[] result = new String[] {"Hello", "world", "world", "Hello", "qwe", "Hello"};
		Delete d = new Delete();
		String[] s = d.del(result);
		assertThat(s, is(expect));
    }
}