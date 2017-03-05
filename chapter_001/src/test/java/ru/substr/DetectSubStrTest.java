package ru.substr;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Detect subtring in string.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class DetectSubStrTest {
    /**
     * Test detect subtring in string(true).
     */
    @Test
    public void whenStringIsContainsSubStringThenTrue() {
		String origin = "Hello world!";
		String sub = "wor";
		DetectSubStr d = new DetectSubStr();
		boolean result = d.contains(origin, sub);
		assertThat(result, is(true));
    }
	/**
     * Test detect subtring in string(false).
     */
	@Test
    public void whenStringIsNotContainsSubStringThenTrue() {
		String origin = "Hello world!";
		String sub = "word";
		DetectSubStr d = new DetectSubStr();
		boolean result = d.contains(origin, sub);
		assertThat(result, is(false));
    }
}