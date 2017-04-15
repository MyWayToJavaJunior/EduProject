package ru.strategy;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/19/2017.
 */
public class PaintTest {
    /**
     * Test print square.
     */
    @Test
    public void whenDrawSquareThenReturnSquare() {
       Paint p = new Paint();
       String result = p.draw(new Square());
       String square = "*****\n*****\n*****\n*****\n*****\n";
        assertThat(result, is(square));
    }
    /**
     * Test print Triagle.
     */
    @Test
    public void whenDrawTriangleThenReturnTriangle() {
        Paint p = new Paint();
        String result = p.draw(new Triagle());
        String triangle = "*\n**\n***\n****\n*****\n";
        assertThat(result, is(triangle));
    }
}
