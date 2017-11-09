package ru.datatype;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculator controller.
 *
 * @author nik1202
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddTwoAndTwoThenFour() {
        Calculator calc = new Calculator();
		calc.add(2, 2);
		final double result = calc.getResult();
		assertThat(result, is(4d));
    }

	/**
     * Test multiple.
     */
	@Test
	public void whenMulTwoAndTwoThenFour() {
        Calculator calc = new Calculator();
		calc.multiple(2, 2);
		final double result = calc.getResult();
		assertThat(result, is(4d));
    }

	/**
     * Test Div.
     */
	@Test
	public void whenDivTwoAndTwoThenOne() {
        Calculator calc = new Calculator();
		calc.div(2, 2);
		final double result = calc.getResult();
		assertThat(result, is(1d));
    }

	/**
     * Test Sub.
     */
	@Test
	public void whenSubTwoAndTwoThenZero() {
        Calculator calc = new Calculator();
		calc.substruct(2, 2);
		final double result = calc.getResult();
		assertThat(result, is(0d));
    }

	/**
     * Test Div by zero.
     */
	@Test
	public void whenDivByZeroThenZero() {
        Calculator calc = new Calculator();
		calc.div(2, 0);
		final double result = calc.getResult();
		assertThat(result, is(0d));
    }
}