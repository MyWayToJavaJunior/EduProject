package ru.bespalov;

/**
* Calculator.
* @author nik1202
* @since 08.02.2017
* @version 0.1
*/

public class Calculator {

	/**
     * result.
     */
	private double result = 0;

	/**
     * add (+).
     * @param first - first value.
	 * @param second - second value.
     */
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
     * substruct (-).
     * @param first - first value.
	 * @param second - second value.
     */
	public void substruct(double first, double second) {
		this.result = first - second;
	}

	/**
     * div (/). if second == 0 thwn result = 0.
     * @param first - first value.
	 * @param second - second value.
     */
	public void div(double first, double second) {
		if (second == 0) {
			this.result = 0;
		} else {
			this.result = first / second;
		}
	}

	/**
     * multiple (*).
     * @param first - first value.
	 * @param second - second value.
     */
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
     * getResult - return result.
     * @return result.
     */
	public double getResult() {
		return this.result;
	}
}