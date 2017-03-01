package ru.bespalov;

/**
* Max of 2 numbers.
* @author nik1202
* @since 08.02.2017
* @version 0.1
*/

public class Max {

	/**
	* Max of 2 numbers.
	* @param first - first numbers.
	* @param second - second number.
	* @return max number.
	*/
	int max(int first, int second) {
		return (first > second) ? first : second;
	}

	/**
	* Max of 3 numbers.
	* @param first - first numbers.
	* @param second - second number.
	* @param third - third number.
	* @return max number.
	*/
	int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}