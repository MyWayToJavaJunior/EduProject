package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/26/2017.
 */
public class BishopTest {
    /**
     * Test Bishop go to cell.
     */
    @Test
    public void whenBishopCanGoThenOk() {
        Cell position = new Cell(3, 3);
        Bishop b = new Bishop(position);
        Cell dist = new Cell(3, 1);
        Cell[] result = b.way(dist);
        Cell[] testData = new Cell[] {new Cell(3, 2), new Cell(3, 1)};

        assertThat(testData, is(result));
    }

    /**
     * Test bishop can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenBishopCantGoThenException() {
        Cell position = new Cell(3, 3);
        Bishop b = new Bishop(position);

        Cell dist = new Cell(4, 6);

        Cell[] result = b.way(dist);
    }
}
