package ru.loops;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Paint Pyramid.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    /**
     * Test Paint.
     */
    @Test
    public void whenHeightIsThreeThenPaint() {
		Paint p = new Paint();
		final String result = p.piramid(3);
		assertThat(result, is("  ^\n ^ ^\n^   ^\n"));
    }
}