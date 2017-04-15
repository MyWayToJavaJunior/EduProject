package ru.unimas;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Union 2 arrays.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class UnimasTest {
    /**
     * Test union 2 arrays with equal sizes.
     */
    @Test
    public void whenUnion2ArraysEqualThenArray() {
		int[] mas1 = new int[] {1, 2, 5, 7};
		int[] mas2 = new int[] {3, 4, 5, 9};
		int[] mas = new int[] {1, 2, 3, 4, 5, 5, 7, 9};
		Unimas u = new Unimas();
		int[] result = u.union(mas1, mas2);
		assertThat(result, is(mas));
    }
	/**
     * Test union 2 arrayswith not equal sizes.
     */
    @Test
    public void whenUnion2ArraysNotEqualThenArray() {
		int[] mas1 = new int[] {1, 2, 5, 7};
		int[] mas2 = new int[] {3, 4, 5, 9, 11, 15};
		int[] mas = new int[] {1, 2, 3, 4, 5, 5, 7, 9, 11, 15};
		Unimas u = new Unimas();
		int[] result = u.union(mas1, mas2);
		assertThat(result, is(mas));
    }
}