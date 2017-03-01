package ru.bespalov;

/**
* Sum of range.
* @author nik1202
* @since 01.03.2017
* @version 0.1
*/

public class Factorial {

	/**
	* Factorial.
	* @param num - number.
	* @return result factorial of numnber.
	*/
	int fac(int num) {
		int result = 1;
		for (int i = 2; num >= i; i++) {
			result *= i;
		}
		return result;
	}
}