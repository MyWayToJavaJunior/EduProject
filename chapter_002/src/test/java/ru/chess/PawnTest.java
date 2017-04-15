package ru.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/30/2017.
 */
public class PawnTest {
    /**
     * Test pawn go to cell.
     */
    @Test
    public void whenPawnCanGoThenOk() {
        Cell position = new Cell(3, 3);
        Figure f = new Pawn(position);
        Cell dist = new Cell(3, 5);
        Cell[] result = f.way(dist);
        Cell[] testData = new Cell[] {new Cell(3, 4), new Cell(3, 5)};
        assertThat(testData, is(result));
    }

    /**
     * Test pawn can't go.
     */
    @Test (expected = ImposibleMoveException.class)
    public void whenPawnCantGoThenException() {
        Cell position = new Cell(3, 3);
        Figure f = new Pawn(position);
        Cell dist = new Cell(5, 3);
        Cell[] result = f.way(dist);
    }
}
